package cotuba.domain;

import java.nio.file.Path;
import java.util.List;

public class EbookBuilder {

    private Formato formato;
    private Path arquivoSaida;
    private List<Capitulo> capitulos;

    public Formato getFormato() {
        return formato;
    }

    public EbookBuilder setFormato(Formato formato) {
        this.formato = formato;
        return this;
    }

    public Path getArquivoSaida() {
        return arquivoSaida;
    }

    public EbookBuilder setArquivoSaida(Path arquivoSaida) {
        this.arquivoSaida = arquivoSaida;
        return this;
    }

    public List<Capitulo> getCapitulos() {
        return capitulos;
    }

    public EbookBuilder setCapitulos(List<Capitulo> capitulos) {
        this.capitulos = capitulos;
        return this;
    }

    public Ebook build() {
        return new Ebook(formato, arquivoSaida, capitulos);
    }
}
