package cg.transformacoes;

import cg.enums.EnumEixo;
import cg.panels.PanelMenu2D;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 * Implementa os métodos para realizar as transformações em um objeto 2D.
 *
 * @author Ivanildo Simplício
 */
public class Transformacoes2D {

    private static Transformacoes2D instance;

    private double[][] matrizM;

    /**
     * Construtor default.
     */
    private Transformacoes2D() {
    }

    public static synchronized Transformacoes2D getInstance() {
        if (instance == null) {
            instance = new Transformacoes2D();
        }
        return instance;
    }

    /**
     * Aplica a transformação translacao no objeto 2D.
     */
    public double[][] translacao(double[][] matrizObjeto, double tx, double ty) {
        double[][] matrizResult = new double[matrizObjeto.length][matrizObjeto[0].length];

        try {
            matrizResult = Matriz.multiplicaMatrizes(geraMatrizTranslacao(tx, ty), matrizObjeto);
            PanelMenu2D.matrizObjeto = matrizResult; //atualiza a matriz objeto global.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na transformação: translação.", "ALERTA!", JOptionPane.WARNING_MESSAGE);
        }
        return matrizResult;
    }
    
    /**
     * Aplica a transformação escala no objeto 2D.
     */
    public double[][] escala(double[][] matrizObjeto, double sx, double sy) {
        double[][] matrizResult = new double[matrizObjeto.length][matrizObjeto[0].length];

        double tx = matrizObjeto[0][0], ty = matrizObjeto[1][0]; //fatores de translação.

        try {
            //matriz translação (Tx,Ty) * matriz escala (Sx, Sy)
            matrizM = Matriz.multiplicaMatrizes(geraMatrizTranslacao(tx, ty), geraMatrizEscala(sx, sy));
            //matrizM * matriz translação (-Tx,-Ty)
            matrizM = Matriz.multiplicaMatrizes(matrizM, geraMatrizTranslacao(-tx, -ty));
            //matrizM * objeto
            matrizResult = Matriz.multiplicaMatrizes(matrizM, matrizObjeto);
            PanelMenu2D.matrizObjeto = matrizResult; //atualiza a matriz objeto global.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na transformação: escala.", "ALERTA!", JOptionPane.WARNING_MESSAGE);
        }
        return matrizResult;
    }

    /**
     * Aplica a transformação rotação no objeto 2D.
     */
    public double[][] rotacao(double[][] matrizObjeto, double angulo) {
        double[][] matrizResult = new double[matrizObjeto.length][matrizObjeto[0].length];
        double tx = matrizObjeto[0][0], ty = matrizObjeto[1][0]; //fatores de translação.

        try {
            //matriz translação (Tx,Ty) * matriz rotacao
            matrizM = Matriz.multiplicaMatrizes(geraMatrizTranslacao(tx, ty), geraMatrizRotacao(angulo));
            //matrizM * matriz translação (-Tx,-Ty)
            matrizM = Matriz.multiplicaMatrizes(matrizM, geraMatrizTranslacao(-tx, -ty));
            //matrizM * objeto
            matrizResult = Matriz.multiplicaMatrizes(matrizM, matrizObjeto);
            PanelMenu2D.matrizObjeto = matrizResult; //atualiza a matriz objeto global.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na transformação: rotação.", "ALERTA!", JOptionPane.WARNING_MESSAGE);
        }
        return matrizResult;
    }

    /**
     * Aplica a transformação reflexao no objeto 2D.
     */
    public double[][] reflexao(double[][] matrizObjeto, String eixo) {
        double[][] matrizResult = new double[matrizObjeto.length][matrizObjeto[0].length];
        eixo = eixo.toUpperCase();
        try {
            //matrizM * objeto
            matrizResult = Matriz.multiplicaMatrizes(geraMatrizReflexao(eixo), matrizObjeto);
            PanelMenu2D.matrizObjeto = matrizResult; //atualiza a matriz objeto global.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na transformação: reflexão.", "ALERTA!", JOptionPane.WARNING_MESSAGE);
        }
        return matrizResult;
    }

    /**
     * Aplica a transformação cisalhamento no objeto 2D.
     */
    public double[][] cisalhamento(double[][] matrizObjeto, double cx, double cy) {
        double[][] matrizResult = new double[matrizObjeto.length][matrizObjeto[0].length];

        double tx = matrizObjeto[0][0], ty = matrizObjeto[1][0]; //fatores de translação

        try {
            //matriz translação (Tx,Ty) * matriz cisalhamento (Cx, Cy)
            matrizM = Matriz.multiplicaMatrizes(geraMatrizTranslacao(tx, ty), geraMatrizCisalhamento(cx, cy));
            //matrizM * matriz translação (-Tx,-Ty)
            matrizM = Matriz.multiplicaMatrizes(matrizM, geraMatrizTranslacao(-tx, -ty));
            //matrizM * objeto
            matrizResult = Matriz.multiplicaMatrizes(matrizM, matrizObjeto);
            PanelMenu2D.matrizObjeto = matrizResult; //atualiza a matriz objeto global.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na transformação: cisalhamento.", "ALERTA!", JOptionPane.WARNING_MESSAGE);
        }
        return matrizResult;
    }

    /**
     * Aplica uma transformação composta no objeto.
     */
    public double[][] composta(Stack<double[][]> listaDeTransformacoes, double[][] matrizObjeto) {
        Stack<double[][]> listaDeTransformacoesCopy = (Stack<double[][]>) listaDeTransformacoes.clone();

        double[][] matrizResult = new double[matrizObjeto.length][matrizObjeto[0].length];
        matrizM = listaDeTransformacoesCopy.pop();

        try {
            while (!listaDeTransformacoesCopy.isEmpty()) {
                matrizM = Matriz.multiplicaMatrizes(matrizM, listaDeTransformacoesCopy.pop());
            }
            //matrizM * objeto
            matrizResult = Matriz.multiplicaMatrizes(matrizM, matrizObjeto);
            PanelMenu2D.matrizObjeto = matrizResult; //atualiza a matriz objeto global.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na transformação composta.", "ALERTA!", JOptionPane.WARNING_MESSAGE);
        }

        return matrizResult;
    }

    /**
     * Gera matriz de translação.
     */
    public double[][] geraMatrizTranslacao(double tx, double ty) {
        double[][] matriz = new double[3][3];

        matriz[0][0] = 1;
        matriz[1][0] = 0;
        matriz[2][0] = 0;

        matriz[0][1] = 0;
        matriz[1][1] = 1;
        matriz[2][1] = 0;

        matriz[0][2] = tx;
        matriz[1][2] = ty;
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

        matriz[0][0] = cos;
        matriz[1][0] = sen;
        matriz[2][0] = 0;

        matriz[0][1] = -sen;
        matriz[1][1] = cos;
        matriz[2][1] = 0;

        matriz[0][2] = 0;
        matriz[1][2] = 0;
        matriz[2][2] = 1;

        return matriz;
    }

    /**
     * Gera matriz de reflexão em torno do eixo passado como parametro.
     */
    public double[][] geraMatrizReflexao(String eixo) {
        double[][] matriz = new double[3][3];

        eixo = eixo.toUpperCase();

        //rotacao em XY
        matriz[0][0] = -1;
        matriz[1][0] = 0;
        matriz[2][0] = 0;

        matriz[0][1] = 0;
        matriz[1][1] = -1;
        matriz[2][1] = 0;

        matriz[0][2] = 0;
        matriz[1][2] = 0;
        matriz[2][2] = 1;

        //rotacao em X
        if (eixo.equals(EnumEixo.X.getValor())) {
            matriz[0][0] = 1;
        } else if (eixo.equals(EnumEixo.Y.getValor())) { //rotacao em Y
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
}