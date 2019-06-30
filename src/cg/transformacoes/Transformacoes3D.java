package cg.transformacoes;

import cg.enums.EnumEixo;
import cg.panels.PanelMenu3D;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 * Métodos para realizar as transformações em objetos 3D.
 *
 * @author Ivanildo Simplício
 */
public class Transformacoes3D {

    private static Transformacoes3D instance;
    private double[][] matrizM;

    /**
     * Construtor padrão.
     */
    public Transformacoes3D() {
    }

    public static synchronized Transformacoes3D getInstance() {
        if (instance == null) {
            instance = new Transformacoes3D();
        }
        return instance;
    }

    /**
     * Aplica a transformação translacao no objeto 3D.
     */
    public double[][] translacao(double[][] matrizObjeto, double tx, double ty, double tz) {
        double[][] matrizResult = new double[matrizObjeto.length][matrizObjeto[0].length];

        try {
            matrizResult = Matriz.multiplicaMatrizes(geraMatrizTranslacao(tx, ty, tz), matrizObjeto);

            PanelMenu3D.matrizObjeto3D = matrizResult; //atualiza a matriz objeto global.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na transformação: translação.", "ALERTA!", JOptionPane.WARNING_MESSAGE);
        }
        return matrizResult;
    }

    /**
     * Aplica a transformação escala no objeto 3D.
     */
    public double[][] escala(double[][] matrizObjeto, double sx, double sy, double sz) {
        double[][] matrizResult = new double[matrizObjeto.length][matrizObjeto[0].length];
        double tx = matrizObjeto[0][0], ty = matrizObjeto[1][0], tz = matrizObjeto[2][0]; //fatores de translação

        try {
            //matriz translação (Tx,Ty,Tz) * matriz escala (Sx,Sy,Sz)
            matrizM = Matriz.multiplicaMatrizes(geraMatrizTranslacao(tx, ty, tz), geraMatrizEscala(sx, sy, sz));
            //matrizM * matriz translação (-Tx,-Ty,-Tz)
            matrizM = Matriz.multiplicaMatrizes(matrizM, geraMatrizTranslacao(-tx, -ty, -tz));
            //matrizM * objeto
            matrizResult = Matriz.multiplicaMatrizes(matrizM, matrizObjeto);

            PanelMenu3D.matrizObjeto3D = matrizResult; //atualiza a matriz objeto global.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na transformação: escala.", "ALERTA!", JOptionPane.WARNING_MESSAGE);
        }
        return matrizResult;
    }

    /**
     * Aplica a transformação rotacao no objeto 3D.
     */
    public double[][] rotacao(double[][] matrizObjeto, double angulo, String eixo) {
        double[][] matrizResult = new double[matrizObjeto.length][matrizObjeto[0].length];

        double tx = matrizObjeto[0][0], ty = matrizObjeto[1][0], tz = matrizObjeto[2][0]; //fatores de translação.

        try {
            //matriz translação (Tx,Ty,Tz) * matriz rotacao
            matrizM = Matriz.multiplicaMatrizes(geraMatrizTranslacao(tx, ty, tz), geraMatrizRotacao(angulo, eixo));
            //matrizM * matriz translação (-Tx,-Ty,-Tz)
            matrizM = Matriz.multiplicaMatrizes(matrizM, geraMatrizTranslacao(-tx, -ty, -tz));
            //matrizM * objeto
            matrizResult = Matriz.multiplicaMatrizes(matrizM, matrizObjeto);
            PanelMenu3D.matrizObjeto3D = matrizResult; //atualiza a matriz objeto global.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na transformação: rotação.", "ALERTA!", JOptionPane.WARNING_MESSAGE);
        }

        return matrizResult;
    }

    /**
     * Aplica a transformação reflexao no objeto 3D.
     */
    public double[][] reflexao(double[][] matrizObjeto, String eixo) {
        double[][] matrizResult = new double[matrizObjeto.length][matrizObjeto[0].length];
        eixo = eixo.toLowerCase();

        double tx = matrizObjeto[0][0], ty = matrizObjeto[1][0], tz = matrizObjeto[2][0]; //fatores de translação.
        
        try {
            //matriz translação (Tx,Ty,Tz) * matriz reflexão
            matrizM = Matriz.multiplicaMatrizes(geraMatrizTranslacao(tx, ty, tz), geraMatrizReflexao(eixo));
            //matrizM * matriz translação (-Tx,-Ty,-Tz)
            matrizM = Matriz.multiplicaMatrizes(matrizM, geraMatrizTranslacao(-tx, -ty, -tz));
            //matrizM * objeto
            matrizResult = Matriz.multiplicaMatrizes(geraMatrizReflexao(eixo), matrizObjeto);

            PanelMenu3D.matrizObjeto3D = matrizResult; //atualiza a matriz objeto global.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na transformação: reflexão.", "ALERTA!", JOptionPane.WARNING_MESSAGE);
        }
        return matrizResult;
    }

    /**
     * Aplica a transformação cisalhamento no objeto 3D.
     */
    public double[][] cisalhamento(double[][] matrizObjeto, double a, double b, String eixo) {
        double[][] matrizResult = new double[matrizObjeto.length][matrizObjeto[0].length];

        double tx = matrizObjeto[0][0], ty = matrizObjeto[1][0], tz = matrizObjeto[2][0]; //fatores de translação.

        try {
            //matriz translação (Tx,Ty,Tz) * matriz cisalhamento(a,b,eixo)
            matrizM = Matriz.multiplicaMatrizes(geraMatrizTranslacao(tx, ty, tz), geraMatrizCisalhamento(a, b, eixo));
            //matrizM * matriz translação (-Tx,-Ty,-Tz)
            matrizM = Matriz.multiplicaMatrizes(matrizM, geraMatrizTranslacao(-tx, -ty, -tz));
            //matrizM * objeto
            matrizResult = Matriz.multiplicaMatrizes(matrizM, matrizObjeto);

            PanelMenu3D.matrizObjeto3D = matrizResult; //atualiza a matriz objeto global.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na transformação: cisalhamento.", "ALERTA!", JOptionPane.WARNING_MESSAGE);
        }
        return matrizResult;
    }

    /**
     * Aplica uma transformação composta no objeto 3D.
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
            PanelMenu3D.matrizObjeto3D = matrizResult; //atualiza a matriz objeto global.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na transformação composta.", "ALERTA!", JOptionPane.WARNING_MESSAGE);
        }
        return matrizResult;
    }

    /**
     * Gera matriz de translação.
     */
    public double[][] geraMatrizTranslacao(double tx, double ty, double tz) {
        double[][] matriz = new double[4][4];

        matriz[0][0] = 1; 
        matriz[1][0] = 0;
        matriz[2][0] = 0;
        matriz[3][0] = 0;
        
        matriz[0][1] = 0; 
        matriz[1][1] = 1;
        matriz[2][1] = 0;
        matriz[3][1] = 0;
        
        matriz[0][2] = 0; 
        matriz[1][2] = 0;
        matriz[2][2] = 1;
        matriz[3][2] = 0;
        
        matriz[0][3] = tx; 
        matriz[1][3] = ty;
        matriz[2][3] = tz;
        matriz[3][3] = 1;
        
        return matriz;
    }

    /**
     * Gera matriz de escala.
     */
    public double[][] geraMatrizEscala(double sx, double sy, double sz) {
        double[][] matriz = new double[4][4];
        sx = (sx == 0) ? 1 : sx;
        sy = (sy == 0) ? 1 : sy;
        sz = (sz == 0) ? 1 : sy;

        matriz[0][0] = sx;
        matriz[1][0] = 0;
        matriz[2][0] = 0;
        matriz[3][0] = 0;

        matriz[0][1] = 0;
        matriz[1][1] = sy;
        matriz[2][1] = 0;
        matriz[3][1] = 0;

        matriz[0][2] = 0;
        matriz[1][2] = 0;
        matriz[2][2] = sz;
        matriz[3][2] = 0;

        matriz[0][3] = 0;
        matriz[1][3] = 0;
        matriz[2][3] = 0;
        matriz[3][3] = 1;

        return matriz;
    }

    /**
     * Gera matriz de rotação de acordo com o eixo passado por parâmetro.
     */
    public double[][] geraMatrizRotacao(double angulo, String eixo) {
        double[][] matriz = new double[4][4];
        double sin = Math.sin(Math.toRadians(angulo));
        double cos = Math.cos(Math.toRadians(angulo));
        eixo = eixo.toUpperCase();

        if (eixo.equals(EnumEixo.X.getValor())) { //rotacao em X
            matriz[0][0] = 1;
            matriz[1][0] = 0;
            matriz[2][0] = 0;
            matriz[3][0] = 0;

            matriz[0][1] = 0;
            matriz[1][1] = cos;
            matriz[2][1] = -sin;
            matriz[3][1] = 0;

            matriz[0][2] = 0;
            matriz[1][2] = sin;
            matriz[2][2] = cos;
            matriz[3][2] = 0;
        }else if (eixo.equals(EnumEixo.Y.getValor())) { //rotacao em Y
            matriz[0][0] = cos;
            matriz[1][0] = 0;
            matriz[2][0] = sin;
            matriz[3][0] = 0;

            matriz[0][1] = 0;
            matriz[1][1] = 1;
            matriz[2][1] = 0;
            matriz[3][1] = 0;

            matriz[0][2] = -sin;
            matriz[1][2] = 0;
            matriz[2][2] = cos;
            matriz[3][2] = 0;
        } else { //rotacao em Z
            matriz[0][0] = cos;
            matriz[1][0] = -sin;
            matriz[2][0] = 0;
            matriz[3][0] = 0;

            matriz[0][1] = sin;
            matriz[1][1] = cos;
            matriz[2][1] = 0;
            matriz[3][1] = 0;

            matriz[0][2] = 0;
            matriz[1][2] = 0;
            matriz[2][2] = 1;
            matriz[3][2] = 0;
        }
        matriz[0][3] = 0;
        matriz[1][3] = 0;
        matriz[2][3] = 0;
        matriz[3][3] = 1;

        return matriz;
    }

    /**
     * Gera matriz de reflexão de acordo com o eixo passado por parâmetro.
     */
    public double[][] geraMatrizReflexao(String eixo) {
        double[][] matriz = new double[4][4];
        eixo = eixo.toUpperCase();

        //reflexao em XZ
        matriz[0][0] = 1;
        matriz[1][0] = 0;
        matriz[2][0] = 0;
        matriz[3][0] = 0;

        matriz[0][1] = 0;
        matriz[1][1] = -1;
        matriz[2][1] = 0;
        matriz[3][1] = 0;

        matriz[0][2] = 0;
        matriz[1][2] = 0;
        matriz[2][2] = 1;
        matriz[3][2] = 0;

        matriz[0][3] = 0;
        matriz[1][3] = 0;
        matriz[2][3] = 0;
        matriz[3][3] = 1;

        if (eixo.equals(EnumEixo.XY.getValor())) { //reflexao em XY
            matriz[1][1] = 1;
            matriz[2][2] = -1;
        }else if (eixo.equals(EnumEixo.YZ.getValor())) { //rotacao em YZ
            matriz[0][0] = -1;
            matriz[1][1] = 1;
        }

        return matriz;
    }

    /**
     * Gera matriz de cisalhamento de acordo com o eixo passado por parâmetro.
     */
    public double[][] geraMatrizCisalhamento(double a, double b, String eixo) {
        double[][] matriz = new double[4][5];
        eixo = eixo.toUpperCase();

        //cisalhamento em X
        matriz[0][0] = 1;
        matriz[1][0] = a;
        matriz[2][0] = b;
        matriz[3][0] = 0;

        matriz[0][1] = 0;
        matriz[1][1] = 1;
        matriz[2][1] = 0;
        matriz[3][1] = 0;

        matriz[0][2] = 0;
        matriz[1][2] = 0;
        matriz[2][2] = 1;
        matriz[3][2] = 0;

        matriz[0][3] = 0;
        matriz[1][3] = 0;
        matriz[2][3] = 0;
        matriz[3][3] = 1;

        if (eixo.equals(EnumEixo.Y.getValor())) { //cisalhamento em Y
            matriz[1][0] = 0;
            matriz[2][0] = 0;
            matriz[0][1] = a;
            matriz[2][1] = b;
        }else if (eixo.equals(EnumEixo.Z.getValor())) { //cisalhamento em Z
            matriz[1][0] = 0;
            matriz[2][0] = 0;
            matriz[0][2] = a;
            matriz[1][2] = b;
        }

        return matriz;
    }
}