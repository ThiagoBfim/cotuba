package cotuba.domain;

public final class Capitulo {

    private final String conteudoHtml;
    private final String titulo;

    public Capitulo(String conteudoHtml, String titulo) {
        this.conteudoHtml = conteudoHtml;
        this.titulo = titulo;
    }

    public String getConteudoHtml() {
        return conteudoHtml;
    }

    public String getTitulo() {
        return titulo;
    }
}
