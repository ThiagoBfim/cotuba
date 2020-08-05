package cotuba.plugin;

import java.util.ServiceLoader;

public class TemaLoaderInstance {

    private static ServiceLoader<Tema> pluginLoader;

    private TemaLoaderInstance() {
        throw new UnsupportedOperationException("Método privado");
    }

    public synchronized static ServiceLoader<Tema> getInstance() {
        if (pluginLoader == null) {
            pluginLoader = ServiceLoader.load(Tema.class);
        }
        return pluginLoader;
    }
}
