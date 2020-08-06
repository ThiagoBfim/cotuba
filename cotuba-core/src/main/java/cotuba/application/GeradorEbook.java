package cotuba.application;

import cotuba.domain.Ebook;
import cotuba.domain.Formato;

import java.util.ServiceLoader;

public interface GeradorEbook {

    void gerarEbook(Ebook ebook);

    Formato formato();

    static GeradorEbook cria(Formato formato) {
        for (GeradorEbook gerador : ServiceLoader.load(GeradorEbook.class)) {
            System.out.println(gerador.formato());
            if (gerador.formato().equals(formato)) {
                return gerador;
            }
        }
        throw new RuntimeException("Formato	do	ebook	inválido:	" + formato);
    }
}
