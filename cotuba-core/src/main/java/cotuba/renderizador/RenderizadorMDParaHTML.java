package cotuba.renderizador;

import cotuba.application.Renderizador;
import cotuba.application.RepositorioDeMDs;
import cotuba.domain.Capitulo;
import cotuba.domain.CapituloBuilder;
import cotuba.tema.AplicadorTema;
import org.commonmark.node.AbstractVisitor;
import org.commonmark.node.Heading;
import org.commonmark.node.Node;
import org.commonmark.node.Text;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.List;
import java.util.stream.Collectors;

public class RenderizadorMDParaHTML implements Renderizador {

    @Override
    public List<Capitulo> renderizarHtml(RepositorioDeMDs repositorioDeMDs) {
        return repositorioDeMDs
                .obtemMDsDosCapitulos()
                .stream()
                .sorted()
                .map(this::criarCapitulo)
                .collect(Collectors.toList());
    }

    private Capitulo criarCapitulo(String md) {
        Parser parser = Parser.builder().build();
        Node document;
        try {
            document = parser.parse(md);
            VisitorHeadingHtml visitorHeadingHtml = new VisitorHeadingHtml();
            document.accept(visitorHeadingHtml);
            try {
                HtmlRenderer renderer = HtmlRenderer.builder().build();
                String render = renderer.render(document);
                CapituloBuilder capituloBuilder = new CapituloBuilder()
                        .setTitulo(visitorHeadingHtml.getTitulo());
                AplicadorTema tema = new AplicadorTema();
                String html = tema.aplica(render);
                return capituloBuilder.setConteudoHtml(html)
                        .build();
            } catch (Exception ex) {
                throw new RuntimeException("Erro	ao	fazer	parse	de	markdown	", ex);
            }

        } catch (Exception ex) {
            throw new RuntimeException("Erro	ao	renderizar	MD	para	HTML", ex);
        }
    }


    private static class VisitorHeadingHtml extends AbstractVisitor {
        private String titulo;

        public VisitorHeadingHtml() {
        }

        @Override
        public void visit(Heading heading) {
            if (heading.getLevel() == 1) {
                titulo = ((Text) heading.getFirstChild()).getLiteral();
            } else if (heading.getLevel() == 2) {
                // seção
            } else if (heading.getLevel() == 3) {
                // título
            }
        }

        public String getTitulo() {
            return titulo;
        }
    }
}
