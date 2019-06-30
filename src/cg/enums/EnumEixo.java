package cg.enums;

/**
 * Mapeia os tipos de eixos.
 * 
 * @author Ivanildo Simplício
 */
public enum EnumEixo {
    X("X"), Y("Y"), Z("Z"), XY("XY"), XZ("XZ"), YZ("YZ");
    
    private final String valor;

    EnumEixo(String value) {
        this.valor = value;
    }
    
    public String getValor() {
        return valor;
    }
}