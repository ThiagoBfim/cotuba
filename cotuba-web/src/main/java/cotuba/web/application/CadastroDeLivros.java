package cotuba.web.application;

import cotuba.web.domain.Livro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroDeLivros {

	private final RepositorioDeLivros repositorio;

	public CadastroDeLivros(RepositorioDeLivros repositorio) {
		this.repositorio = repositorio;
	}

	public List<Livro> listagem() {
		return repositorio.findAll();
	}

	public Livro detalha(Long id) {
		return repositorio.getOne(id);
	}
}
