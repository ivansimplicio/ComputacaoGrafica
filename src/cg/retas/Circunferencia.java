package cg.retas;

import cg.panels.PlanoCartesiano;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Algoritmos para desenhar circunferências.
 *
 * @author Ivanildo Simplício
 */
public class Circunferencia {

    private static Circunferencia instance;
    private final PlanoCartesiano planoCartesiano;
    public static int x, y, d_old, x_dif, y_dif;
    private List<Ponto> listaPontos;

    /**
     * Construtor padrão.
     */
    private Circunferencia() {
        listaPontos = new ArrayList<>();
        planoCartesiano = PlanoCartesiano.getInstance();
    }

    public static synchronized Circunferencia getInstance() {
        if (instance == null) {
            instance = new Circunferencia();
        }
        return instance;
    }

    /**
     * Algoritmo da função explicita.
     */
    public void funcaoExplicita(int raio, Color cor) {
        planoCartesiano.redesenha();
        
        for (int i = -raio; i < raio; i++) {
            planoCartesiano.drawPixel(i + planoCartesiano.getValorCentroX(), planoCartesiano.getValorCentroY() - ((int) Math.sqrt(raio * raio - i * i)), cor);
            planoCartesiano.drawPixel(i + planoCartesiano.getValorCentroX(), planoCartesiano.getValorCentroY() - (-1 * (int) Math.sqrt(raio * raio - i * i)), cor);
        }
    }

    /**
     * Algoritmo da função trigonométrica.
     */
    public void funcaoTrigonometrica(int raio, Color cor) {
        planoCartesiano.redesenha();
        for (int i = -raio; i <= raio; i++) {
            drawPontos(((int) (raio * (double) Math.cos(Math.toRadians(i)))), -((int) (raio * (double) Math.sin(Math.toRadians(i)))), cor);
        }
    }

    /**
     * Algoritmo do ponto médio.
     */
    public void funcaoPontoMedio(int raio, Color cor) {
        planoCartesiano.redesenha();
        
        x = 0;
        y = raio;
        d_old = 1 - raio;
        
        drawPontos(x, y, cor);
        while (y > x) {
            if (d_old < 0) {
                d_old += 2 * x + 3;
            } else {
                d_old += 2 * x - 2 * y + 5;
                y--;
            }
            x++;
            drawPontos(x, y, cor);
        }
    }

    /**
     * Algoritmo para desenhar uma elipse por varredura usando o algoritmo do ponto médio.
     */
    public List<Ponto> funcaoElipse(int a, int b, Color cor) {
        planoCartesiano.redesenha();
        listaPontos.clear();

        x = 0;
        y = 0;
        double d1;
        double d2;
        
        //valores iniciais
        x = 0;
        y = b;
        d1 = b * b - a * a * b + a * a / 4.0;

        drawElipse(x, y, cor);

        while (a * a * (y - 0.5) > b * b * (x + 1)) {

            if (d1 < 0) {
                d1 = d1 + b * b * (2 * x + 3);
                x++;
            } else {
                d1 = d1 + b * b * (2 * x + 3) + a * a * (-2 * y + 2);
                x++;
                y--;
            }
            drawElipse(x, y, cor);
        }

        d2 = b * b * (x + 0.5) * (x + 0.5) + a * a * (y - 1) * (y - 1) - a * a * b * b;
        while (y > 0) {

            if (d2 < 0) {
                d2 = d2 + b * b * (2 * x + 2) + a * a * (-2 * y + 3);
                x++;
                y--;
            } else {
                d2 = d2 + a * a * (-2 * y + 3);
                y--;
            }
            drawElipse(x, y, cor);
        }

        return listaPontos;
    }

    /**
     * Desenha em cada oitante.
     */
    private void drawPontos(int x, int y, Color cor) {
        
        planoCartesiano.drawPixel(x + planoCartesiano.getValorCentroX(), planoCartesiano.getValorCentroY() - y, cor);
        planoCartesiano.drawPixel(x + planoCartesiano.getValorCentroX(), planoCartesiano.getValorCentroY() + y, cor);
        planoCartesiano.drawPixel(-x + planoCartesiano.getValorCentroX(), planoCartesiano.getValorCentroY() - y, cor);
        planoCartesiano.drawPixel(-x + planoCartesiano.getValorCentroX(), planoCartesiano.getValorCentroY() + y, cor);
        
        planoCartesiano.drawPixel(y + planoCartesiano.getValorCentroX(), planoCartesiano.getValorCentroY() - x, cor);
        planoCartesiano.drawPixel(y + planoCartesiano.getValorCentroX(), planoCartesiano.getValorCentroY() + x, cor);
        planoCartesiano.drawPixel(-y + planoCartesiano.getValorCentroX(), planoCartesiano.getValorCentroY() - x, cor);
        planoCartesiano.drawPixel(-y + planoCartesiano.getValorCentroX(), planoCartesiano.getValorCentroY() + x, cor);
    }

    /**
     * Desenha os pontos da elipse
     */
    private void drawElipse(int x, int y, Color cor) { 
        planoCartesiano.drawPixel(x + planoCartesiano.getValorCentroX(), planoCartesiano.getValorCentroY() - y, cor);
        planoCartesiano.drawPixel(x + planoCartesiano.getValorCentroX(), planoCartesiano.getValorCentroY() + y, cor);
        planoCartesiano.drawPixel(-x + planoCartesiano.getValorCentroX(), planoCartesiano.getValorCentroY() - y, cor);
        planoCartesiano.drawPixel(-x + planoCartesiano.getValorCentroX(), planoCartesiano.getValorCentroY() + y, cor);
        
        if (listaPontos == null) {
            listaPontos = new ArrayList<>();
        }
        listaPontos.add(new Ponto((double) (x + planoCartesiano.getValorCentroX()), (double) (planoCartesiano.getValorCentroY() - y)));
        listaPontos.add(new Ponto((double) (x + planoCartesiano.getValorCentroX()), (double) (planoCartesiano.getValorCentroY() + y)));
        listaPontos.add(new Ponto((double) (-x + planoCartesiano.getValorCentroX()), (double) (planoCartesiano.getValorCentroY() - y)));
        listaPontos.add(new Ponto((double) (-x + planoCartesiano.getValorCentroX()), (double) (planoCartesiano.getValorCentroY() + y)));
    }
}