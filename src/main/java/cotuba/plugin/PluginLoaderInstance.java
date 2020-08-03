package cotuba.plugin;

import java.util.ServiceLoader;

public class PluginLoaderInstance {

    private static ServiceLoader<Plugin> pluginLoader;

    private PluginLoaderInstance() {
        throw new UnsupportedOperationException("Método privado");
    }

    public synchronized static ServiceLoader<Plugin> getInstance() {
        if (pluginLoader == null) {
            pluginLoader = ServiceLoader.load(Plugin.class);
        }
        return pluginLoader;
    }
}
