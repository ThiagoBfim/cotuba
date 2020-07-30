package cotuba.domain;

import cotuba.application.GeradorEbook;
import cotuba.gerador.GeradorEPUB;
import cotuba.gerador.GeradorPDF;

public enum Formato {

    PDF(new GeradorPDF()),
    EPUB(new GeradorEPUB());

    private GeradorEbook geradorEbook;

    Formato(GeradorEbook geradorEbook) {
        this.geradorEbook = geradorEbook;
    }

    public GeradorEbook getGeradorEbook() {
        return geradorEbook;
    }
}
