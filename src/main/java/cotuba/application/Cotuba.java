package cotuba.application;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.domain.EbookBuilder;
import cotuba.domain.Formato;
import cotuba.plugin.AoFinalizarGeracao;

import java.nio.file.Path;
import java.util.List;

public class Cotuba {

    public void executa(ParametrosExternos parametrosExternos) {
        final Path diretorioDosMD = parametrosExternos.getDiretorioDosMD();
        final Formato formato = parametrosExternos.getFormatoEbook();
        final Path arquivoDeSaida = parametrosExternos.getArquivoDeSaida();

        List<Capitulo> capitulos = RenderizadorFactory.fabricar()
                .renderizarHtml(diretorioDosMD);
        Ebook ebook = new EbookBuilder()
                .setFormato(formato)
                .setArquivoSaida(arquivoDeSaida)
                .setCapitulos(capitulos)
                .build();

        GeradorEbookFactory
                .fabricar(formato)
                .gerarEbook(ebook);
        AoFinalizarGeracao.gerou(ebook);

        System.out.println("Arquivo gerado com sucesso: " + arquivoDeSaida);

    }
}
