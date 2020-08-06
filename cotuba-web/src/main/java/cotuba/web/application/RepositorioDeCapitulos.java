package cotuba.web.application;

import cotuba.web.domain.Capitulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDeCapitulos extends JpaRepository<Capitulo, Long> {

}
