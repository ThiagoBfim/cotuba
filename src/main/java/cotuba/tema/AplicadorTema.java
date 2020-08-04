package cotuba.tema;

import com.itextpdf.html2pdf.jsoup.Jsoup;
import com.itextpdf.html2pdf.jsoup.nodes.Document;
import cotuba.domain.Capitulo;
import cotuba.plugin.Tema;

import java.util.List;

public class AplicadorTema {

    public void aplica(Capitulo capitulo) {
        String html = capitulo.getConteudoHtml();
        Document document = Jsoup.parse(html);
        List<String> listaDeTemas = Tema.listaDeTemas();
        for (String css : listaDeTemas) {
            document.select("head").append("<style>	" + css + "	</style>");
        }
    }
}
