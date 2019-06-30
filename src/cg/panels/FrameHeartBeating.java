package cg.panels;

import java.awt.*;
import java.awt.geom.*;
import java.util.Date;
import javax.swing.JFrame;

/**
 * Animação baseada em transformacões stepwise combinadas.
 *
 * @author Ivanildo Simplício
 */
public class FrameHeartBeating extends JFrame {

    private int windowWidth;
    private int windowHeight;
    private boolean printLine = false;

    /**
     * Construtor padrão.
     *
     * @param windowWidth da janela a ser criada.
     * @param windowHeight da janela a ser criada.
     */
    public FrameHeartBeating(int windowWidth, int windowHeight, boolean printLine) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.printLine = printLine;
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //Linhas com espessura de 2.0
        g2d.setStroke(new BasicStroke(2.0f));
        //Uso de antialiasing para ter linhas mais agradáveis.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        /* 
        * O yUp define uma conversão que permite a especificação de objetos em coordenadas "reais",
	* onde o eixo y aponta para cima e a origem do sistema de coordenadas está localizada no canto
	* inferior esquerdo da janela.
         */
        AffineTransform yUp = new AffineTransform();
        yUp.setToScale(1, -1);
        AffineTransform translate = new AffineTransform();
        translate.setToTranslation(0, windowHeight);
        yUp.preConcatenate(translate);

        // Aplica a transformação ao objeto Graphics2D para desenhar tudo em coordenadas "reais".
        g2d.transform(yUp);

        // Esse retângulo serve como background, enquadrando toda a tela.
        Rectangle2D.Double windowFrame = new Rectangle2D.Double(2, 2, windowWidth, windowHeight);

        // Desenho do objeto a ser movimentado.
        Rectangle2D.Double heart = new Rectangle2D.Double(2, 2, 2, 2);

        // Especifica o quanto deve se mover em cada etapa.
        AffineTransform singleTranslation = new AffineTransform();
        // Quanto vai ter cada movimento
        singleTranslation.setToTranslation(1, 0);

        // Essa transformação é para acumular as translações de etapa única.
        AffineTransform accumulatedTranslation = new AffineTransform();

        // Posição inicial
        accumulatedTranslation.setToTranslation(0, 100);
        clearWindow(g2d);
        
        // Neste loop, a posição do objeto é atualizada e a imagem atualizada é desenhada.
        for (int i = 0; i < windowWidth + 390; i++) {
            // Limpa a janela.
            if (!printLine) {
                clearWindow(g2d);
            }

            // Desenha o retângulo do background.
            g2d.draw(windowFrame);

            // Desenha a moldura do objeto.
            g2d.draw(accumulatedTranslation.createTransformedShape(heart));

            // Seta como vai percorrer o ponto
            if (i > 80 & i <= 130 || i > 200 & i <= 220 || i > 290 & i <= 320 || i > 360 & i <= 370
                    || i > 440 & i <= 500 || i > 580 & i <= 600 || i > 660 & i <= 690 || i > 760 & i <= 800) {
                singleTranslation.setToTranslation(0.3, 1);
            } else if (i > 130 & i <= 200 || i > 320 & i <= 360 || i > 500 & i <= 580 || i > 690 & i <= 760) {
                singleTranslation.setToTranslation(0.3, -1);
            } else {
                singleTranslation.setToTranslation(1, 0);
            }
            accumulatedTranslation.preConcatenate(singleTranslation);

            // Controla o tempo para redesenhar o objeto e a janela.
            sustain(10);
        }
        dispose();
    }

    /**
     * Método para limpar a janela.
     *
     * @param g2d Graphics2D usado para desenhar.
     */
    public void clearWindow(Graphics2D g2d) {
        g2d.setPaint(Color.BLACK);
        g2d.fill(new Rectangle(0, 0, windowWidth, windowHeight));
        g2d.setPaint(Color.RED);
    }

    /**
     * Um método para um atraso de t milissegundos. Este método é usado aqui
     * apenas para manter o programa simples. Esse método envolve espera ativa,
     * consumindo capicidade de processador desnecessária. Para aplicações
     * reais, os encadeamentos devem ser usados.
     *
     * @param t Tempo de espera.
     */
    public void sustain(long t) {
        long finish = (new Date()).getTime() + t;
        while ((new Date()).getTime() < finish) {
        }
    }
}