package cotuba.renderizador;

import cotuba.application.Renderizador;
import cotuba.domain.Capitulo;
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
        Capitulo capitulo = new Capitulo();
        Parser parser = Parser.builder().build();
        Node document;
        try {
            document = parser.parseReader(Files.newBufferedReader(arquivoMD));
            document.accept(new VisitorHeadingHtml(capitulo));
            try {
                HtmlRenderer renderer = HtmlRenderer.builder().build();
                String render = renderer.render(document);
                capitulo.setConteudoHtml(render);
                return capitulo;
            } catch (Exception ex) {
                throw new RuntimeException("Erro ao renderizar para HTML o arquivo " + arquivoMD, ex);
            }

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fazer parse do arquivo " + arquivoMD, ex);
        }
    }

    private static class VisitorHeadingHtml extends AbstractVisitor {
        private final Capitulo capitulo;

        public VisitorHeadingHtml(Capitulo capitulo) {
            this.capitulo = capitulo;
        }

        @Override
        public void visit(Heading heading) {
            if (heading.getLevel() == 1) {
                String tituloDoCapitulo = ((Text) heading.getFirstChild()).getLiteral();
                capitulo.setTitulo(tituloDoCapitulo);
            } else if (heading.getLevel() == 2) {
                // seção
            } else if (heading.getLevel() == 3) {
                // título
            }
        }

    }
}
