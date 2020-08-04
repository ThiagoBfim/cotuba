package cotuba.plugin;

import cotuba.application.AcaoPosGeracao;
import cotuba.domain.Ebook;

public interface AoFinalizarGeracao {

    void aposGeracao(Ebook ebook, AcaoPosGeracao acaoPosGeracao);

    static void gerou(Ebook ebook, AcaoPosGeracao acaoPosGeracao) {
        for (AoFinalizarGeracao plugin : AoFinalizarGeracaoLoaderInstance.getInstance()) {
            plugin.aposGeracao(ebook, acaoPosGeracao);
        }
    }
}
