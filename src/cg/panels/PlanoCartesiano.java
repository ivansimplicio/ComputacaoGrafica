package cg.panels;

import cg.retas.Ponto;
import cg.retas.Rasterizacao;
import cg.transformacoes.Imagem;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Representa um plano cartesiano e implementa todas as funcionalidades a qual o mesmo é responsável.
 *
 * @author Ivanildo Simplício
 */
public class PlanoCartesiano extends JPanel {

    private static PlanoCartesiano instance;

    /**
     * Construtor default.
     */
    private PlanoCartesiano() {

    }

    /**
     * Fornece instância única do Plano Cartesiano
     */
    public static synchronized PlanoCartesiano getInstance() {
        if (instance == null) {
            instance = new PlanoCartesiano();
        }
        return instance;
    }

    /**
     * Retorna a largura/comprimento do plano cartesiano.
     */
    public int getLargura() {
        return super.getWidth();
    }

    /**
     * Retorna a altura do plano cartesiano.
     */
    public int getAltura() {
        return super.getHeight();
    }

    /**
     * Retorna o valor central X (width/2)
     */
    public int getValorCentroX() {
        return getLargura() / 2;
    }

    /**
     * Retorna o valor central Y (height/2)
     */
    public int getValorCentroY() {
        return getAltura() / 2;
    }
    
    /**
     * Retorna o valor em RGB de acordo com o valor do pixel
     */
    public int getCorPixel(int corRGB) {
        return new Color(corRGB, corRGB, corRGB).getRGB();
    }

    /**
     * Desenha o plano cartesiano.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.WHITE);
        /*g.setColor(Color.LIGHT_GRAY);
        g.drawLine(0, getValorCentroY(), getLargura(), getValorCentroY()); //reta x
        g.drawLine(getValorCentroX(), 0, getValorCentroX(), getAltura()); //reta y*/
        //reta x
        Rasterizacao.getInstance().metodoPontoMedio(new Ponto(-getLargura()/2,0), new Ponto(getLargura()/2,0), Color.LIGHT_GRAY, null);
        //reta y
        Rasterizacao.getInstance().metodoPontoMedio(new Ponto(0, -getAltura()/2), new Ponto(0, getAltura()/2), Color.LIGHT_GRAY, null);
    }

    /**
     * Redesenha o plano cartesiano. Útil quando se quer apagar os objetos desenhados nele.
     */
    public void redesenha() {
        if (instance != null) {
            instance.getGraphics().clearRect(0, 0, this.getLargura(), this.getAltura());
            this.paint(this.getGraphics()); // Desenha o plano cartesiano novamente
        }
    }

    /**
     * Desenha o eixo Z no plano cartesiano.
     */
    public void desenhaEixoZ() {
        Rasterizacao.getInstance().metodoPontoMedio(new Ponto(0, 0), new Ponto(-getAltura(), -getAltura()), Color.LIGHT_GRAY, null);
        Rasterizacao.getInstance().metodoPontoMedio(new Ponto(0, 0), new Ponto(getAltura(), getAltura()), Color.LIGHT_GRAY, null);
    }

    /**
     * Redesenha o espaço 3D. Útil quando se quer apagar os objetos desenhados nele.
     */
    public void redesenha3D() {
        redesenha();
        desenhaEixoZ();
    }

    /**
     * Desenha o pixel no plano cartesiano de acordo com os parametros. OBS: Os pontos não são normalizados.
     */
    public void drawPixel(int x, int y, Color color) {
        Graphics g = super.getGraphics();
        g.setColor(color);
        g.fillRect(x, y, 1, 1); //acende um pixel (x,y) no plano.
    }

    /**
     * Desenha um pixel no plano cartesiano de acordo com os parametros. OBS: Os pontos são normalizados!
     */
    public void drawPixel(double x, double y, Color color) {
        //Normalizando os pontos
        x = (x + PlanoCartesiano.getInstance().getValorCentroX());
        y = (PlanoCartesiano.getInstance().getValorCentroY() - y);
        drawPixel(Math.round((float) x), Math.round((float) y), color);
    }

    /**
     * Desenha objeto 2D no plano cartesiano.
     */
    public void drawObjeto2D(double[][] matrizObjeto, Color color) {
        redesenha();
        Rasterizacao rast = Rasterizacao.getInstance();
        
        rast.metodoPontoMedio(new Ponto(matrizObjeto[0][0], matrizObjeto[1][0]), new Ponto(matrizObjeto[0][1], matrizObjeto[1][1]), color, null);
        rast.metodoPontoMedio(new Ponto(matrizObjeto[0][1], matrizObjeto[1][1]), new Ponto(matrizObjeto[0][2], matrizObjeto[1][2]), color, null);
        rast.metodoPontoMedio(new Ponto(matrizObjeto[0][2], matrizObjeto[1][2]), new Ponto(matrizObjeto[0][3], matrizObjeto[1][3]), color, null);
        rast.metodoPontoMedio(new Ponto(matrizObjeto[0][3], matrizObjeto[1][3]), new Ponto(matrizObjeto[0][0], matrizObjeto[1][0]), color, null);  
    }

    /**
     * Desenha objeto 3D no espaço.
     */
    public void drawObjeto3D(double[][] matrizObjeto3D, Color color) {
        redesenha3D();
        Rasterizacao rast = Rasterizacao.getInstance();

        double fatorCentroCubo = 0; //matrizObjeto3D[0][4]/2; // (profundidade / 2)/2
        Ponto A = new Ponto(matrizObjeto3D[0][0] - fatorCentroCubo, matrizObjeto3D[1][0] - fatorCentroCubo, matrizObjeto3D[2][0] - fatorCentroCubo);
        Ponto B = new Ponto(matrizObjeto3D[0][1] - fatorCentroCubo, matrizObjeto3D[1][1] - fatorCentroCubo, matrizObjeto3D[2][1] - fatorCentroCubo);
        Ponto C = new Ponto(matrizObjeto3D[0][2] - fatorCentroCubo, matrizObjeto3D[1][2] - fatorCentroCubo, matrizObjeto3D[2][2] - fatorCentroCubo);
        Ponto D = new Ponto(matrizObjeto3D[0][3] - fatorCentroCubo, matrizObjeto3D[1][3] - fatorCentroCubo, matrizObjeto3D[2][3] - fatorCentroCubo);
        Ponto E = new Ponto(matrizObjeto3D[0][4] - fatorCentroCubo, matrizObjeto3D[1][4] - fatorCentroCubo, matrizObjeto3D[2][4] - fatorCentroCubo);
        Ponto F = new Ponto(matrizObjeto3D[0][5] - fatorCentroCubo, matrizObjeto3D[1][5] - fatorCentroCubo, matrizObjeto3D[2][5] - fatorCentroCubo);
        Ponto G = new Ponto(matrizObjeto3D[0][6] - fatorCentroCubo, matrizObjeto3D[1][6] - fatorCentroCubo, matrizObjeto3D[2][6] - fatorCentroCubo);
        Ponto H = new Ponto(matrizObjeto3D[0][7] - fatorCentroCubo, matrizObjeto3D[1][7] - fatorCentroCubo, matrizObjeto3D[2][7] - fatorCentroCubo);

        //Desenha usando o algoritmo de rasterização do Ponto Médio
        rast.metodoPontoMedio(A, B, color, null);
        rast.metodoPontoMedio(B, C, color, null);
        rast.metodoPontoMedio(C, D, color, null);
        rast.metodoPontoMedio(D, A, color, null);
        rast.metodoPontoMedio(E, F, color, null);
        rast.metodoPontoMedio(F, G, color, null);
        rast.metodoPontoMedio(G, H, color, null);
        rast.metodoPontoMedio(H, E, color, null);
        rast.metodoPontoMedio(A, E, color, null);
        rast.metodoPontoMedio(B, F, color, null);
        rast.metodoPontoMedio(C, G, color, null);
        rast.metodoPontoMedio(D, H, color, null);
    }
    
    /**
     * Desenha a ViewPort no plano cartesiano.
     * @param listaPontos vértices do ViewPort.
     */
    public void desenhaViewPort(List<Ponto> listaPontos) {
        this.redesenha();
        Rasterizacao rast = Rasterizacao.getInstance();
       
        rast.metodoPontoMedio(listaPontos.get(0), listaPontos.get(1), Color.BLACK, null);
        rast.metodoPontoMedio(listaPontos.get(1), listaPontos.get(2), Color.BLACK, null);
        rast.metodoPontoMedio(listaPontos.get(2), listaPontos.get(3), Color.BLACK, null);
        rast.metodoPontoMedio(listaPontos.get(3), listaPontos.get(0), Color.BLACK, null);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Desenha imagem no plano cartesiano.
     */
    public void drawImage(Imagem img) {
        BufferedImage bufferedImg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int row = 0; row < img.getWidth(); row++) {
            for (int col = 0; col < img.getHeight(); col++) {
                // Prepara a imagem para ser desenhada no jpanel
                bufferedImg.setRGB(row, col, getCorPixel(img.getMatrizPixel()[row][col]));
            }
        }
        this.drawImage(bufferedImg);
    }

    /**
     * Desenha a imagem no plano cartesiano
     */
    public void drawImage(int[][] matrizImage, double[][] matrizPosicao) {
        redesenha();
        
        BufferedImage bufferedImg = new BufferedImage(matrizImage.length, matrizImage.length, BufferedImage.TYPE_INT_RGB);
        for (int row = 0; row < bufferedImg.getWidth(); row++) {
            for (int col = 0; col < bufferedImg.getHeight(); col++) {
                // Prepara a imagem para ser desenhada no jpanel
                bufferedImg.setRGB(col, row, getCorPixel((int) matrizImage[row][col]));
            }
        }
        this.drawImage(bufferedImg);
    }

    /**
     * Desenha imagem no plano cartesiano.
     */
    public void drawImage(BufferedImage bufferedImg) {
        redesenha();
        this.getGraphics().drawImage(bufferedImg, getValorCentroX(), getValorCentroY() - bufferedImg.getHeight(), null);
    }

    /**
     * Recebe a imagem a ser processada e o AffineTransform contendo as
     * transformações na imagem e desenha no plano cartesiano.
     */
    public void drawImage(Imagem img, AffineTransform affineTransform) {
        BufferedImage bufferedImg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int row = 0; row < img.getBufferedImage().getWidth(); row++) {
            for (int col = 0; col < img.getBufferedImage().getHeight(); col++) {
                // Prepara a imagem para ser desenhada no jpanel
                if (row < 256 && col < 256) {
                    bufferedImg.setRGB(row, col, getCorPixel(img.getMatrizPixel()[row][col]));
                }
            }
        }
        img.setBufferedImage(bufferedImg);

        redesenha(); // redesenha plano cartesiano

        /**
         * Printa a imagem no plano cartesiano
         */
        Graphics2D g2d = (Graphics2D) this.getGraphics();
        g2d.setTransform(affineTransform);
        g2d.drawImage(img.getBufferedImage(), getValorCentroX(), getValorCentroY() - img.getBufferedImage().getHeight(), null);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
}