package cotuba.plugin;

import cotuba.application.ImpressaoPosGeracao;
import cotuba.domain.Ebook;

public interface AoFinalizarGeracao {

    void aposGeracao(Ebook ebook, ImpressaoPosGeracao impressaoPosGeracao);

    static void gerou(Ebook ebook, ImpressaoPosGeracao impressaoPosGeracao) {
        for (AoFinalizarGeracao plugin : AoFinalizarGeracaoLoaderInstance.getInstance()) {
            plugin.aposGeracao(ebook, impressaoPosGeracao);
        }
    }
}
