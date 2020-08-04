package cotuba.renderizador;

import cotuba.application.Renderizador;
import cotuba.domain.Capitulo;
import cotuba.tema.AplicadorTema;
import org.commonmark.node.AbstractVisitor;
import org.commonmark.node.Heading;
import org.commonmark.node.Node;
import org.commonmark.node.Text;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RenderizadorMDParaHTML implements Renderizador {

    @Override
    public List<Capitulo> renderizarHtml(Path diretorioDosMD) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.md");
        try (Stream<Path> arquivosMD = Files.list(diretorioDosMD)) {
            return arquivosMD
                    .filter(matcher::matches)
                    .sorted()
                    .map(this::criarCapitulo)
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            throw new RuntimeException(
                    "Erro tentando encontrar arquivos .md em " + diretorioDosMD.toAbsolutePath(), ex);
        }
    }

    private Capitulo criarCapitulo(Path arquivoMD) {
        Parser parser = Parser.builder().build();
        Node document;
        try {
            document = parser.parseReader(Files.newBufferedReader(arquivoMD));
            VisitorHeadingHtml visitorHeadingHtml = new VisitorHeadingHtml();
            document.accept(visitorHeadingHtml);
            try {
                HtmlRenderer renderer = HtmlRenderer.builder().build();
                String render = renderer.render(document);
                final Capitulo capitulo = new Capitulo(render, visitorHeadingHtml.getTitulo());
                AplicadorTema tema = new AplicadorTema();
                tema.aplica(capitulo);
                return capitulo;
            } catch (Exception ex) {
                throw new RuntimeException("Erro ao renderizar para HTML o arquivo " + arquivoMD, ex);
            }

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fazer parse do arquivo " + arquivoMD, ex);
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
