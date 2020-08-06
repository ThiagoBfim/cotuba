package cotuba.tema;

import cotuba.plugin.Tema;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;

public class AplicadorTema {

    public String aplica(String conteudoHtml) {
        Document document = Jsoup.parse(conteudoHtml);
        List<String> listaDeTemas = Tema.listaDeTemas();
        for (String css : listaDeTemas) {
            document.select("head").append("<style>	" + css + "	</style>");
        }
        return document.html();
    }
}
