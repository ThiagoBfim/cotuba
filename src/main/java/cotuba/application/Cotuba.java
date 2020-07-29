package cotuba.application;

import cotuba.cli.LeitorOpcoesCLI;
import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.gerador.GeradorEPUB;
import cotuba.gerador.GeradorPDF;
import cotuba.gerador.RenderizadorMDParaHTML;

import java.nio.file.Path;
import java.util.List;

public class Cotuba {

    public void executa(LeitorOpcoesCLI leitorOpcoesCLI) {
        final Path diretorioDosMD = leitorOpcoesCLI.getDiretorioDosMD();
        final String formato = leitorOpcoesCLI.getNomeFormatEbook();
        final Path arquivoDeSaida = leitorOpcoesCLI.getArquivoDeSaida();

        RenderizadorMDParaHTML renderizador = new RenderizadorMDParaHTML();
        List<Capitulo> capitulos = renderizador.renderHtml(diretorioDosMD);
        Ebook ebook = new Ebook();
        ebook.setFormato(formato);
        ebook.setArquivoSaida(arquivoDeSaida);
        ebook.setCapitulos(capitulos);

        if ("pdf".equals(formato)) {
            GeradorPDF geradorPDF = new GeradorPDF();
            geradorPDF.generateFile(ebook);
        } else if ("epub".equals(formato)) {
            GeradorEPUB geradorEPUB = new GeradorEPUB();
            geradorEPUB.generateFile(ebook);
        } else {
            throw new RuntimeException("Formato do ebook inválido: " + formato);
        }

        System.out.println("Arquivo gerado com sucesso: " + arquivoDeSaida);

    }
}
