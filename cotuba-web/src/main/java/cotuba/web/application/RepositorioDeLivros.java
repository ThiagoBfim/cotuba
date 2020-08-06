package cotuba.web.application;

import cotuba.web.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDeLivros  extends JpaRepository<Livro, Long> {

}
