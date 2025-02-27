package cg.transformacoes;

import cg.enums.EnumEixo;
import cg.panels.PlanoCartesiano;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Métodos para transformações em imagens.
 * 
 */
public class TransformacoesImagem {

    private static TransformacoesImagem instance;
    private double[] origemPixelCentro = new double[]{0, 0};
    private double[][] matrizM;

    /**
     * Construtor default.
     */
    private TransformacoesImagem() {
    }

    public static synchronized TransformacoesImagem getInstance() {
        if (instance == null) {
            instance = new TransformacoesImagem();
        }
        return instance;
    }

    /**
     * Aplica translação no objeto passado como parametro e de acordo com os fatores de translação.
     */
    public void translacao(Imagem img, double tx, double ty) {
        double[][] matrizM = new double[img.getWidth()][img.getHeight()];
        try {
            double[][] pixels;
            for (int i = 0; i < img.getWidth(); i++) {
                for (int j = 0; j < img.getHeight(); j++) {
                    pixels = new double[1][3];
                    pixels[0][0] = i;
                    pixels[0][1] = j;
                    pixels[0][2] = 1;

                    int hwidth = img.getWidth() / 2;
                    int hheight = img.getHeight() / 2;

                    int xt = i - hwidth;
                    int yt = j - hheight;

                    double[][] transformado = new double[1][3];

                    // translada
                    matrizM = Matriz.multiplicaMatrizes(pixels, geraMatrizTranslacao(tx, ty));

                    int pixelX = (int) transformado[0][0];
                    int pixelY = (int) transformado[0][1];

                    // Transforma o pixel.
                    if (pixelX < img.getWidth() && pixelX > 0 && pixelY < img.getHeight() && pixelY > 0) {
                        matrizM[pixelX][pixelY] = img.getMatrizPixel()[i][j];
                    }

                    // Guarda a origem.
                    if ((int) (img.getWidth() / 2) == i && (int) (img.getHeight() / 2) == j) {
                        origemPixelCentro = new double[]{i - pixelX, j - pixelY};
                    }
                }
            }
            PlanoCartesiano.getInstance().drawImage(img.getMatrizPixel(), matrizM);
        } catch (Exception ex) {
            Logger.getLogger(TransformacoesImagem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Aplica rotacao no objeto passado como parametro, de acordo com angulo.
     */
    public void rotacao(Imagem imagem, double angulo) {
        int width = imagem.getBufferedImage().getWidth();
        int height = imagem.getBufferedImage().getHeight();

        imagem.setBufferedImage(tratarImagem(imagem));

        /**
         * Aplica a translação usando o AffineTransform
         */
        PlanoCartesiano panel = PlanoCartesiano.getInstance();
        Graphics2D g2d = (Graphics2D) panel.getGraphics();
        panel.redesenha();

        BufferedImage img = rotate(imagem.getBufferedImage(), angulo);
        g2d.drawImage(img, panel.getValorCentroX(), panel.getValorCentroY() - height, null);
    }

    public BufferedImage rotate(BufferedImage image, double angle) {
        double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
        int w = image.getWidth(), h = image.getHeight();
        int neww = (int) Math.floor(w * cos + h * sin), newh = (int) Math.floor(h * cos + w * sin);
        GraphicsConfiguration gc = getDefaultConfiguration();
        BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
        Graphics2D g = result.createGraphics();
        g.translate((neww - w) / 2, (newh - h) / 2);
        g.rotate(angle, w / 2, h / 2);
        g.drawRenderedImage(image, null);
        g.dispose();
        return result;
    }

    private GraphicsConfiguration getDefaultConfiguration() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        return gd.getDefaultConfiguration();
    }

    /**
     * Aplica escala no objeto passado como parametro, de acordo com os fatores de escala.
     */
    public void escala(Imagem imagem, double sx, double sy) {
        double fatorX = imagem.getWidth() * sx;
        double fatorY = imagem.getHeight() * sy;

        int width = (int) fatorX;
        int height = (int) fatorY;

        /**
         * Aplica a translação usando o AffineTransform
         */
        PlanoCartesiano panel = PlanoCartesiano.getInstance();
        Graphics2D g2d = (Graphics2D) panel.getGraphics();
        panel.redesenha();

        imagem.setBufferedImage(tratarImagem(imagem));

        BufferedImage after = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
        at.scale(sx, sy);
        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        after = scaleOp.filter(imagem.getBufferedImage(), after);

        g2d.drawImage(after, panel.getValorCentroX(), panel.getValorCentroY() - height, null);
    }

    /**
     * Aplica reflexão no objeto passado como parametro, de acordo com o eixo escolhido.
     */
    public void reflexao(Imagem imagem, String eixo) {
        BufferedImage image = tratarImagem(imagem);
        AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
        tx.translate(0, -imagem.getBufferedImage().getHeight(null));
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        image = op.filter(image, null);

        tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-image.getWidth(null), 0);
        op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        image = op.filter(image, null);
        PlanoCartesiano panel = PlanoCartesiano.getInstance();
        Graphics2D g2d = (Graphics2D) panel.getGraphics();
        panel.redesenha();
        g2d.drawImage(image, panel.getValorCentroX(), panel.getValorCentroY() - image.getHeight(), null);
    }

    /**
     * Aplica cisalhamento no objeto passado como parametro, de acordo com os fatores de a e b.
     */
    public void cisalhamento(Imagem imagem, double cx, double cy) {
        double fatorX = imagem.getWidth() * cx;
        double fatorY = imagem.getHeight() * cy;

        /**
         * Aplica a translação usando o AffineTransform
         */
        PlanoCartesiano panel = PlanoCartesiano.getInstance();
        Graphics2D g2d = (Graphics2D) panel.getGraphics();
        panel.redesenha();

        imagem.setBufferedImage(tratarImagem(imagem));

        AffineTransform at = new AffineTransform();
        at.translate(panel.getValorCentroX() + imagem.getWidth() * cx, panel.getValorCentroY() - imagem.getHeight());
        at.shear(-cx, -cy);

        g2d.drawImage(imagem.getBufferedImage(), at, null);
    }
    
    /**
     * Gera matriz de translação.
     */
    public double[][] geraMatrizTranslacao(double tx, double ty) {
        double[][] matriz = new double[3][3];

        matriz[0][0] = 1;
        matriz[0][1] = 0;
        matriz[0][2] = tx;

        matriz[1][0] = 0;
        matriz[1][1] = 1;
        matriz[1][2] = ty;

        matriz[2][0] = 0;
        matriz[2][1] = 0;
        matriz[2][2] = 1;

        return matriz;
    }

    /**
     * Gera matriz de escala.
     */
    public double[][] geraMatrizEscala(double sx, double sy) {
        double[][] matriz = new double[3][3];
        sx = (sx == 0) ? 1 : sx;
        sy = (sy == 0) ? 1 : sy;

        matriz[0][0] = sx;
        matriz[1][0] = 0;
        matriz[2][0] = 0;

        matriz[0][1] = 0;
        matriz[1][1] = sy;
        matriz[2][1] = 0;

        matriz[0][2] = 0;
        matriz[1][2] = 0;
        matriz[2][2] = 1;

        return matriz;
    }

    /**
     * Gera matriz de rotação.
     */
    public double[][] geraMatrizRotacao(double angulo) {
        double[][] matriz = new double[3][3];

        double sen = Math.sin(Math.toRadians(angulo));
        double cos = Math.cos(Math.toRadians(angulo));

        // Coluna 0
        matriz[0][0] = cos;
        matriz[1][0] = sen;
        matriz[2][0] = 0;

        // Coluna 1
        matriz[0][1] = -sen;
        matriz[1][1] = cos;
        matriz[2][1] = 0;

        // Coluna 2
        matriz[0][2] = 0;
        matriz[1][2] = 0;
        matriz[2][2] = 1;

        return matriz;
    }

    /**
     * Gera matriz de reflexão em torno do eixo passado como parametro X, Y ou X e Y.
     */
    public double[][] geraMatrizReflexao(String eixo) {
        double[][] matriz = new double[3][3];

        eixo = eixo.toUpperCase();

        // Rotação em XY
        matriz[0][0] = -1;
        matriz[1][0] = 0;
        matriz[2][0] = 0;

        matriz[0][1] = 0;
        matriz[1][1] = -1;
        matriz[2][1] = 0;

        matriz[0][2] = 0;
        matriz[1][2] = 0;
        matriz[2][2] = 1;

        // Rotação em X
        if (eixo.equals(EnumEixo.X.getValor())) {
            matriz[0][0] = 1;
        } else if (eixo.equals(EnumEixo.Y.getValor())) {
            matriz[1][1] = 1;
        }

        return matriz;
    }

    /**
     * Gera matriz de cisalhamento.
     */
    public double[][] geraMatrizCisalhamento(double cx, double cy) {
        double[][] matriz = new double[3][3];

        matriz[0][0] = 1;
        matriz[1][0] = cy;
        matriz[2][0] = 0;

        matriz[0][1] = cx;
        matriz[1][1] = 1;
        matriz[2][1] = 0;

        matriz[0][2] = 0;
        matriz[1][2] = 0;
        matriz[2][2] = 1;

        return matriz;
    }

    private BufferedImage tratarImagem(Imagem imagem) {
        BufferedImage bufferedImg = new BufferedImage(imagem.getBufferedImage().getWidth(), imagem.getBufferedImage().getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int row = 0; row < imagem.getBufferedImage().getWidth(); row++) {
            for (int col = 0; col < imagem.getBufferedImage().getHeight(); col++) {
                // Prepara a imagem para ser desenhada no jpanel
                if (row < 256 && col < 256) {
                    bufferedImg.setRGB(row, col, PlanoCartesiano.getInstance().getCorPixel(imagem.getMatrizPixel()[row][col]));
                }
            }
        }
        return bufferedImg;
    }
}