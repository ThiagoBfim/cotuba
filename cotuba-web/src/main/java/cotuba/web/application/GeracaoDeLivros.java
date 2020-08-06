package cotuba.web.application;

import cotuba.application.Cotuba;
import cotuba.application.ParametrosExternos;
import cotuba.application.RepositorioDeMDs;
import cotuba.domain.Formato;
import cotuba.web.domain.Livro;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class GeracaoDeLivros {

    private final CadastroDeLivros livros;

    public GeracaoDeLivros(CadastroDeLivros livros) {
        this.livros = livros;
    }

    public Path geraLivro(Long id, Formato formato) {
        Livro livro = livros.detalha(id);
        ParametrosExternos parametros = new ParametrosWeb(formato, livro);
        new Cotuba().executa(parametros, System.out::println);
        return parametros.getArquivoDeSaida();
    }

    private static class ParametrosWeb implements ParametrosExternos {
        private final Livro livro;
        private final Formato formato;
        private Path arquivoDeSaida;
        private Path diretorio;

        private ParametrosWeb(Formato formato, Livro livro) {
            this.formato = formato;
            this.livro = livro;
        }

        @Override
        public Formato getFormatoEbook() {
            return formato;
        }

        @Override
        public Path getArquivoDeSaida() {
            if (arquivoDeSaida != null) {
                return arquivoDeSaida;
            }
            try {
                diretorio = Files.createTempDirectory("ebooks");
                String nomeDoArquivoDeSaida = "book." + formato.name().toLowerCase();
                this.arquivoDeSaida = diretorio.resolve(nomeDoArquivoDeSaida);
                return arquivoDeSaida;
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        @Override
        public RepositorioDeMDs repositorioDeMD() {
            return new MDsDoBancoDeDados(livro);
        }

        public Path getDiretorio() {
            return diretorio;
        }
    }
}
