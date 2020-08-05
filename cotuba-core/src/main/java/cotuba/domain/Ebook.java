package cotuba.domain;

import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public final class Ebook {

    private final Formato formato;
    private final Path arquivoSaida;
    private final List<Capitulo> capitulos;

    public Ebook(Formato formato, Path arquivoSaida, List<Capitulo> capitulos) {
        this.formato = formato;
        this.arquivoSaida = arquivoSaida;
        this.capitulos = capitulos;
    }

    public Formato getFormato() {
        return formato;
    }

    public Path getArquivoSaida() {
        return arquivoSaida;
    }

    public List<Capitulo> getCapitulos() {
        return Collections.unmodifiableList(capitulos);
    }

    public boolean isLastCapitulo(Capitulo capitulo) {
        return capitulos.get(capitulos.size() - 1).equals(capitulo);
    }

    public boolean isNotLastCapitulo(Capitulo capitulo) {
        return !isLastCapitulo(capitulo);
    }

}
