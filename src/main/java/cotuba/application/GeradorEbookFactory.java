package cotuba.application;

import cotuba.domain.Formato;
import cotuba.gerador.GeradorEPUB;
import cotuba.gerador.GeradorPDF;

public class GeradorEbookFactory {

    public static GeradorEbook fabricar(Formato formato) {
        if (formato == Formato.PDF) {
            return new GeradorPDF();
        } else if (formato == Formato.EPUB) {
            return new GeradorEPUB();
        } else {
            throw new RuntimeException("Formato do ebook inválido: " + formato.name());
        }
    }
}
