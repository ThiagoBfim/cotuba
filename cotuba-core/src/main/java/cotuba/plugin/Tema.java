package cotuba.plugin;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public interface Tema {

    String cssDoTema();

    static List<String> listaDeTemas() {
        return StreamSupport.stream(TemaLoaderInstance.getInstance().spliterator(), false)
                .map(Tema::cssDoTema)
                .collect(Collectors.toList());
    }
}
