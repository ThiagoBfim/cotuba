package cotuba.plugin;

import cotuba.domain.Ebook;

public interface AoFinalizarGeracao {

    void aposGeracao(Ebook ebook);

    static void gerou(Ebook ebook) {
        for (AoFinalizarGeracao plugin : AoFinalizarGeracaoLoaderInstance.getInstance()) {
            System.out.println(plugin.getClass());
            plugin.aposGeracao(ebook);
        }
    }
}
