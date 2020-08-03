package cotuba.plugin;

import java.util.ServiceLoader;

public class AoFinalizarGeracaoLoaderInstance {

    private static ServiceLoader<AoFinalizarGeracao> pluginLoader;

    private AoFinalizarGeracaoLoaderInstance() {
        throw new UnsupportedOperationException("Método privado");
    }

    public synchronized static ServiceLoader<AoFinalizarGeracao> getInstance() {
        if (pluginLoader == null) {
            pluginLoader = ServiceLoader.load(AoFinalizarGeracao.class);
        }
        return pluginLoader;
    }
}
