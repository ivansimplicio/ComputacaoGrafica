package cg.enums;

/**
 * Mapeia os tipos de algoritmos para desenhar circunferência e elipse.
 * 
 * @author Ivanildo Simplício
 */
public enum EnumCircunferencia {
    EQUACAO_EXPLICITA("Equação Explícita"), PONTO_MEDIO("Ponto Médio"), TRIGONOMETRICO("Trigonométrico"), ELIPSE("Elipse");
    
    private final String titulo;

    EnumCircunferencia(String titulo) {
        this.titulo = titulo;
    }
    
    public String getTitulo() {
        return titulo;
    }
}