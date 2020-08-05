package cli;

import cotuba.application.AcaoPosGeracao;

public class ImprimeNoConsole implements AcaoPosGeracao {

    @Override
    public void imprimir(String mensagem) {
        System.out.println(mensagem);
    }
}
