package cotuba.application;

import cotuba.domain.Formato;

public class GeradorEbookFactory {

    public static GeradorEbook fabricar(Formato formato) {
        return formato.getGeradorEbook();
    }
}
