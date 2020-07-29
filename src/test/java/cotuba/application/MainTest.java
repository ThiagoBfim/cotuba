package cotuba.application;


import cotuba.cli.LeitorOpcoesCLI;
import org.junit.Before;
import org.junit.Test;

public class MainTest {

    private String pathWithMdFiles;

    @Before
    public void setUp() {
        String projectPath = System.getProperty("user.dir");
        pathWithMdFiles = projectPath + "\\exemplo";
    }

    @Test
    public void testGeracaoEpub() {
        LeitorOpcoesCLI leitorOpcoesCLI = new LeitorOpcoesCLI("-d", pathWithMdFiles, "-f", "epub");
        new Cotuba().executa(leitorOpcoesCLI);
    }

    @Test
    public void testGeracaoPDF() {
        LeitorOpcoesCLI leitorOpcoesCLI = new LeitorOpcoesCLI("-d", pathWithMdFiles);
        new Cotuba().executa(leitorOpcoesCLI);
    }

}
