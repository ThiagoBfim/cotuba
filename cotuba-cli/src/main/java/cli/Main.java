package cli;

import cotuba.application.Cotuba;

public class Main {

    public static void main(String[] args) {
        LeitorOpcoesCLI leitorOpcoesCLI = new LeitorOpcoesCLI(args);
        try {
            Cotuba cotuba = new Cotuba();
            cotuba.executa(leitorOpcoesCLI, new	ImprimeNoConsole());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            if (leitorOpcoesCLI.isVerboso()) {
                ex.printStackTrace();
            }
            System.exit(1);
        }
    }


}
