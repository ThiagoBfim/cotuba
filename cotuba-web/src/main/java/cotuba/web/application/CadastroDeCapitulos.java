package cotuba.web.application;

import cotuba.web.domain.Capitulo;
import org.springframework.stereotype.Service;

@Service
public class CadastroDeCapitulos {

    private final RepositorioDeCapitulos repositorio;

    public CadastroDeCapitulos(RepositorioDeCapitulos repositorio) {
        this.repositorio = repositorio;
    }

    public Capitulo detalha(Long id) {
        return repositorio.getOne(id);
    }

    public void atualiza(Capitulo capitulo) {
        Capitulo capituloBD = repositorio.getOne(capitulo.getId());
        capituloBD.setNome(capitulo.getNome());
        capituloBD.setMarkdown(capitulo.getMarkdown());
        repositorio.save(capituloBD);
    }
}
