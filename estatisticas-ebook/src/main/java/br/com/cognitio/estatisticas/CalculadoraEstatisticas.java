package br.com.cognitio.estatisticas;

import com.itextpdf.html2pdf.jsoup.Jsoup;
import com.itextpdf.html2pdf.jsoup.nodes.Document;
import cotuba.application.AcaoPosGeracao;
import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.plugin.AoFinalizarGeracao;

import java.text.Normalizer;

public class CalculadoraEstatisticas implements AoFinalizarGeracao {

    private ContagemPalavras contagemPalavras = new ContagemPalavras();

    @Override
    public void aposGeracao(Ebook ebook, AcaoPosGeracao acaoPosGeracao) {
        for (Capitulo capitulo : ebook.getCapitulos()) {
            String html = capitulo.getConteudoHtml();
            Document doc = Jsoup.parse(html);

            String textoDoCapitulo = doc.body().text();
            String textoDoCapituloSemPontuacao = textoDoCapitulo.replaceAll("\\p{Punct}", "	");
            String textoDoCapituloSemAcentos = Normalizer.normalize(textoDoCapituloSemPontuacao, Normalizer.Form.NFD).
                    replaceAll("[^\\p{ASCII}]", "");
            String[] palavras = textoDoCapituloSemAcentos.split("\\s+");
            for (String palavra : palavras) {
                String emMaiusculas = palavra.toUpperCase();
                contagemPalavras.adicionaPalavra(emMaiusculas);
            }

        }

        contagemPalavras.getContagemPalavras()
                .forEach(p -> acaoPosGeracao.imprimir(p.getPalavra() + ":   " + p.getQuantidade()));

    }
}

