package cotuba.application;

import cotuba.domain.Capitulo;
import cotuba.renderizador.RenderizadorMDParaHTML;

import java.util.List;

public interface Renderizador {

    List<Capitulo> renderizarHtml(RepositorioDeMDs repositorioDeMDs);

    static Renderizador cria() {
        return new RenderizadorMDParaHTML();
    }
}
