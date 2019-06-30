package cg.retas;

import cg.panels.PlanoCartesiano;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JTextArea;

/**
 * Classe que implementa os algoritmos de rasterização da reta.
 *
 * @author Ivanildo Simplício
 */
public class Rasterizacao {

    private static Rasterizacao instance;

    private final PlanoCartesiano planoCartesiano;
    
    private final List<Ponto> pontos;

    /**
     * Construtor padrão.
     */
    private Rasterizacao() {
        planoCartesiano = PlanoCartesiano.getInstance();
        pontos = new LinkedList<>();
    }

    public static synchronized Rasterizacao getInstance() {
        if (instance == null) {
            instance = new Rasterizacao();
        }
        return instance;
    }

    /**
     * Algoritmo DDA (Digital Differential Analyser).
     */
    public void metodoDDA(Ponto pInicial, Ponto pFinal, Color cor, JTextArea textAreaSolution) {
        double x1 = pInicial.getX();
        double x2 = pFinal.getX();
        double y1 = pInicial.getY();
        double y2 = pFinal.getY();
        double dx = (x2 - x1);
        double dy = (y2 - y1);
        int count = 0;

        if (Math.abs(y2 - y1) <= Math.abs(x2 - x1)) {
            if ((x1 == x2) && (y1 == y2)) {
                planoCartesiano.drawPixel(x1, y1, cor);
                setSolution(textAreaSolution, x1, y1, ++count);
            } else {
                if (x2 < x1) {
                    double tmp = x2;
                    x2 = x1;
                    x1 = tmp;

                    tmp = y2;
                    y2 = y1;
                    y1 = tmp;
                }
                double k = dy / dx;
                int cele_y;
                double y = y1;
            }
        } else if (y2 < y1) {
            double tmp = x2;
            x2 = x1;
            x1 = tmp;

            tmp = y2;
            y2 = y1;
            y1 = tmp;
        }

        double k = dx / dy;
        double x = x1;
        for (int y = (int) y1; y <= y2; y++) {
            planoCartesiano.drawPixel(x, y, cor);
            setSolution(textAreaSolution, x, y, ++count);
            x += k;
        }
    }

    /**
     * Algoritmo do ponto médio (Bresenham).
     */
    public void metodoPontoMedio(Ponto pInicial, Ponto pFinal, Color cor, JTextArea textAreaSolution) {
        int x1 = (int) (pInicial.getX() + pInicial.getZ());
        int x2 = (int) (pFinal.getX() + pInicial.getZ());
        int y1 = (int) (pInicial.getY() + pFinal.getZ());
        int y2 = (int) (pFinal.getY() + pFinal.getZ());

        if ((x1 == x2) && (y1 == y2)) {
            planoCartesiano.drawPixel((double)x1, (double)y1, cor);
        } else {
            double dx = Math.abs(x2 - x1);
            double dy = Math.abs(y2 - y1);
            double rozdil = dx - dy;
            int posun_x, posun_y;

            if (x1 < x2) {
                posun_x = 1;
            } else {
                posun_x = -1;
            }
            if (y1 < y2) {
                posun_y = 1;
            } else {
                posun_y = -1;
            }

            int count = 0;
            planoCartesiano.drawPixel((double) x1, (double) y1, cor); // "pinta" o primeiro ponto
            setSolution(textAreaSolution, x1, y1, ++count);
            pontos.clear();
            pontos.add(new Ponto(x1, y1));

            while ((x1 != x2) || (y1 != y2)) {
                double p = 2 * rozdil;

                if (p > -dy) {
                    rozdil = rozdil - dy;
                    x1 = x1 + posun_x;
                }
                if (p < dx) {
                    rozdil = rozdil + dx;
                    y1 = y1 + posun_y;
                }

                planoCartesiano.drawPixel((double) x1, (double) y1, cor);
                setSolution(textAreaSolution, x1, y1, ++count);
                pontos.add(new Ponto(x1, y1));
            }
        }
    }

    /**
     * Popula o jTextArea com a solução do problema.
     */
    private static void setSolution(JTextArea textAreaSolution, double x, double y, int count) {
        if (textAreaSolution != null) {
            StringBuilder solucao = new StringBuilder();

            solucao.append(textAreaSolution.getText());
            solucao.append(String.format("%03d", count));
            solucao.append(" -> ");
            solucao.append("P(").append(Math.round(x)).append(", ").append(Math.round(y));
            solucao.append(")\n");
            textAreaSolution.setText(solucao.toString());
        }
    }
    
    /**
     * Retorna a lista dos pontos traçados pelo algoritmo de ponto médio.
     */
    public List getPontos(){
        return pontos;  
    }
}