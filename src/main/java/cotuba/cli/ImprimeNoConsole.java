package cotuba.cli;

import cotuba.application.ImpressaoPosGeracao;

public class ImprimeNoConsole implements ImpressaoPosGeracao {

    @Override
    public void imprimir(String mensagem) {
        System.out.println(mensagem);
    }
}
