package cotuba.plugin;

import cotuba.domain.Ebook;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public interface Plugin {

    String cssDoTema();

    void aposGeracao(Ebook ebook);

    static List<String> listaDeTemas() {
        return StreamSupport.stream(PluginLoaderInstance.getInstance().spliterator(), false)
                .map(Plugin::cssDoTema)
                .collect(Collectors.toList());
    }

    static void gerou(Ebook ebook) {
        for (Plugin plugin : PluginLoaderInstance.getInstance()) {
            System.out.println(plugin.getClass());
            plugin.aposGeracao(ebook);
        }
    }

}
