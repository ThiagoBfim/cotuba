package cotuba.application;

import cotuba.gerador.GeradorEPUB;
import cotuba.gerador.GeradorPDF;

public class GeradorEbookFactory {

    public static GeradorEbook fabricar(String type) {
        if ("pdf".equals(type)) {
            return new GeradorPDF();
        } else if ("epub".equals(type)) {
            return new GeradorEPUB();
        } else {
            throw new RuntimeException("Formato do ebook inválido: " + type);
        }
    }
}
