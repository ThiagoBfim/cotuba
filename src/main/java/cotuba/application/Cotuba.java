package cotuba.application;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.gerador.GeradorEPUB;
import cotuba.gerador.GeradorPDF;
import cotuba.gerador.RenderizadorMDParaHTML;

import java.nio.file.Path;
import java.util.List;

public class Cotuba {

    public void executa(ParametrosExternos parametrosExternos) {
        final Path diretorioDosMD = parametrosExternos.getDiretorioDosMD();
        final String formato = parametrosExternos.getNomeFormatEbook();
        final Path arquivoDeSaida = parametrosExternos.getArquivoDeSaida();

        RenderizadorMDParaHTML renderizador = new RenderizadorMDParaHTML();
        List<Capitulo> capitulos = renderizador.renderizarHtml(diretorioDosMD);
        Ebook ebook = new Ebook();
        ebook.setFormato(formato);
        ebook.setArquivoSaida(arquivoDeSaida);
        ebook.setCapitulos(capitulos);

        if ("pdf".equals(formato)) {
            GeradorPDF geradorPDF = new GeradorPDF();
            geradorPDF.gerarEbook(ebook);
        } else if ("epub".equals(formato)) {
            GeradorEPUB geradorEPUB = new GeradorEPUB();
            geradorEPUB.gerarEbook(ebook);
        } else {
            throw new RuntimeException("Formato do ebook inválido: " + formato);
        }

        System.out.println("Arquivo gerado com sucesso: " + arquivoDeSaida);

    }
}
