package cg.transformacoes;

/**
 * Implementa operações entre matrizes.
 *
 * @author Ivanildo Simplício
 */
public class Matriz {

    /**
     * Realiza multiplicação entre duas matrizes e retorna o resultado.
     */
    public static double[][] multiplicaMatrizes(double[][] matrizA, double[][] matrizB){
        double[][] matrizResultado = new double[matrizA.length][matrizB[0].length];

        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizB[0].length; j++) {
                for (int k = 0; k < matrizA[0].length; k++) {
                    matrizResultado[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }
        return matrizResultado;
    }
}