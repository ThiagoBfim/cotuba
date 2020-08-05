package cotuba.application;

import cotuba.renderizador.RenderizadorMDParaHTML;

public class RenderizadorFactory {

    public static Renderizador fabricar() {
        return new RenderizadorMDParaHTML();
    }
}
