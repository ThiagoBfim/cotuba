package cotuba.plugin;

import cotuba.domain.Capitulo;
import cotuba.domain.Formato;

import java.nio.file.Path;
import java.util.List;

public interface Ebook {

    Formato getFormato();

    Path getArquivoSaida();

    List<Capitulo> getCapitulos();

}
