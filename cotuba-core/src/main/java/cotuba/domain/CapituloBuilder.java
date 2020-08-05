package cotuba.domain;

public class CapituloBuilder {

    private String conteudoHtml;
    private String titulo;

    public String getConteudoHtml() {
        return conteudoHtml;
    }

    public CapituloBuilder setConteudoHtml(String conteudoHtml) {
        this.conteudoHtml = conteudoHtml;
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public CapituloBuilder setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Capitulo build() {
        return new Capitulo(conteudoHtml, titulo);
    }
}
