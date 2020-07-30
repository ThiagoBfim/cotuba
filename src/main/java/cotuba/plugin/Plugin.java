package cotuba.plugin;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public interface Plugin {

    String cssDoTema();

    static List<String> listaDeTemas() {
        ServiceLoader<Plugin> loader = ServiceLoader.load(Plugin.class);
        return StreamSupport.stream(loader.spliterator(), false)
                .map(Plugin::cssDoTema)
                .collect(Collectors.toList());
    }

}
