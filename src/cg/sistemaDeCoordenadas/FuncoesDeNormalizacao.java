package cg.sistemaDeCoordenadas;

/**
 * Realiza as transformacoes entre os diferentes tipos de sistemas de coordenadas.
 * 
 * @author Ivanildo Simplício
 */
public class FuncoesDeNormalizacao {

    private static double ndcx;
    private static double ndcy;
    private static double dcx;
    private static double dcy;

    public static double calcularNDCX(float ndh, float dcx) {
        ndcx = dcx / (ndh - 1);
        return ndcx;
    }
    
    public static double calcularNDCY(float ndv, float dcy) {
        ndcy = (dcy / (ndv - 1));
        return ndcy;
    }
    
    public static int calcularDCX(float ndh, float ndcx) {
        dcx = ((ndh - 1) * ndcx);
        return (int) Math.round(dcx);
    }

    public static int calcularDCY(float ndv, float ndcy) {
        dcy = ((ndv - 1) * ndcy);
        return (int) Math.round(dcy);
    }
}