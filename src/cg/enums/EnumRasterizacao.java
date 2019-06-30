package cg.enums;

/**
 * Mapeia os tipos de algoritmos para rasterização da reta.
 * 
 * @author Ivanildo Simplício
 */
public enum EnumRasterizacao {
    DDA("DDA (Digital Differential Analyser)"), PONTO_MEDIO("Bresenham (Ponto Médio)");
    
    private final String titulo;

    EnumRasterizacao(String titulo) {
        this.titulo = titulo;
    }
    
    public String getTitulo() {
        return titulo;
    }
}
