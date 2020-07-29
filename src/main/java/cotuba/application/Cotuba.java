package cotuba.application;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;

import java.nio.file.Path;
import java.util.List;

public class Cotuba {

    public void executa(ParametrosExternos parametrosExternos) {
        final Path diretorioDosMD = parametrosExternos.getDiretorioDosMD();
        final String formato = parametrosExternos.getNomeFormatEbook();
        final Path arquivoDeSaida = parametrosExternos.getArquivoDeSaida();

        List<Capitulo> capitulos = RenderizadorFactory.fabricar()
                .renderizarHtml(diretorioDosMD);
        Ebook ebook = new Ebook();
        ebook.setFormato(formato);
        ebook.setArquivoSaida(arquivoDeSaida);
        ebook.setCapitulos(capitulos);

        GeradorEbookFactory
                .fabricar(formato)
                .gerarEbook(ebook);

        System.out.println("Arquivo gerado com sucesso: " + arquivoDeSaida);

    }
}
