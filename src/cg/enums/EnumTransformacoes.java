package cg.enums;

/**
 * Mapeia os tipos de tranformações 2D/3D em objetos.
 *
 * @author Ivanildo Simplício
 */
public enum EnumTransformacoes {
    TRANSLACAO("Translação"), ESCALA("Escala"), ROTACAO("Rotação"), REFLEXAO("Reflexão"), CISALHAMENTO("Cisalhamento"), TRANSFORMACAO_COMPOSTA("Transformação Composta");

    private final String titulo;

    EnumTransformacoes(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
}