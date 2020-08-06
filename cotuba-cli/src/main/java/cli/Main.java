package cli;

import cotuba.application.Cotuba;
import cotuba.application.RepositorioDeMDs;

public class Main {

    public static void main(String[] args) {
        LeitorOpcoesCLI leitorOpcoesCLI = new LeitorOpcoesCLI(args);
        try {
            Cotuba cotuba = new Cotuba();
            RepositorioDeMDs repositorio = new MDsDoDiretorio(leitorOpcoesCLI.getArquivoDeSaida());
            cotuba.executa(leitorOpcoesCLI, new ImprimeNoConsole(), repositorio);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            if (leitorOpcoesCLI.isVerboso()) {
                ex.printStackTrace();
            }
            System.exit(1);
        }
    }

}
