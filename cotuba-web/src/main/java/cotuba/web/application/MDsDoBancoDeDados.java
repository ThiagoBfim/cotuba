package cotuba.web.application;

import cotuba.application.RepositorioDeMDs;
import cotuba.web.domain.Capitulo;
import cotuba.web.domain.Livro;

import java.util.ArrayList;
import java.util.List;

public class MDsDoBancoDeDados implements RepositorioDeMDs {
    private Livro livro;

    public MDsDoBancoDeDados(Livro livro) {
        this.livro = livro;
    }

    @Override
    public List<String> obtemMDsDosCapitulos() {
        List<String> mds = new ArrayList<>();
        for (Capitulo capitulo : livro.getCapitulos()) {
            String md = "#	" + capitulo.getNome() + "\n";
            md += capitulo.getMarkdown();
            mds.add(md);
        }
        return mds;
    }
}
