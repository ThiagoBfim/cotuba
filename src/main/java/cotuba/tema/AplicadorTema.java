package cotuba.tema;

import com.itextpdf.html2pdf.jsoup.Jsoup;
import com.itextpdf.html2pdf.jsoup.nodes.Document;
import cotuba.domain.Capitulo;

public class AplicadorTema {

    public void aplica(Capitulo capitulo) {
        String	html	=	capitulo.getConteudoHtml();
        Document document	=	Jsoup.parse(html);
        String	css	=	"h1	{	border-bottom:	1px	dashed	black;	}";
        document.select("head").append("<style>	"	+	css	+	"	</style>");
        capitulo.setConteudoHtml(document.html());
    }
}
