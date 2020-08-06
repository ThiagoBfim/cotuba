package cotuba.web.application;

import cotuba.application.Cotuba;
import cotuba.application.ParametrosExternos;
import cotuba.domain.Formato;
import cotuba.web.domain.Livro;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class GeracaoDeLivros {

    private final CadastroDeLivros livros;
    private ParametrosCotubaWeb parametros;

    public GeracaoDeLivros(CadastroDeLivros livros) {
        this.livros = livros;
    }

    public Path geraLivro(Long id, Formato formato) {
        Livro livro = livros.detalha(id);
        parametros = new ParametrosCotubaWeb(formato);
        MDsDoBancoDeDados repositorioDeMD = new MDsDoBancoDeDados(livro);
        new Cotuba().executa(parametros, System.out::println, repositorioDeMD);
        return parametros.getArquivoDeSaida();
    }

    public void clearTempFiles() {
        if (parametros != null) {
            try {
                Files.deleteIfExists(parametros.getArquivoDeSaida());
                Files.deleteIfExists(parametros.getDiretorio());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private static class ParametrosCotubaWeb implements ParametrosExternos {
        private Path arquivoDeSaida;
        private Path diretorio;
        private Formato formato;

        private ParametrosCotubaWeb(Formato formato) {
            this.formato = formato;
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
        public boolean isVerboso() {
            return false;
        }

        public Path getDiretorio() {
            return diretorio;
        }
    }
}
