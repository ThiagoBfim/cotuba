package cotuba.application;

import cotuba.domain.Capitulo;

import java.nio.file.Path;
import java.util.List;

public interface Renderizador {

    List<Capitulo> renderizarHtml(Path diretorioDosMD);

}
