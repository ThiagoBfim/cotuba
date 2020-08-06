package cotuba.application;

import cotuba.domain.Formato;

import java.nio.file.Path;

public interface ParametrosExternos {
    Formato getFormatoEbook();

    Path getArquivoDeSaida();

    RepositorioDeMDs repositorioDeMD();

}
