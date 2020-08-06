package cotuba.application;


import cli.ImprimeNoConsole;
import cli.LeitorOpcoesCLI;
import cli.MDsDoDiretorio;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class MainTest {

    private MDsDoDiretorio mDsDoDiretorio;

    @Before
    public void setUp() {
        String projectPath = System.getProperty("user.dir");
        String pathWithMdFiles = projectPath.replaceAll("cotuba-cli", "") + "exemplo";
        mDsDoDiretorio = new MDsDoDiretorio(Paths.get(pathWithMdFiles));
    }

    @Test
    public void testGeracaoEpub() {
        LeitorOpcoesCLI leitorOpcoesCLI = new LeitorOpcoesCLI("-f", "epub");
        new Cotuba().executa(leitorOpcoesCLI, new ImprimeNoConsole(), mDsDoDiretorio);
    }

    @Test
    public void testGeracaoPDF() throws IOException {
        LeitorOpcoesCLI leitorOpcoesCLI = new LeitorOpcoesCLI();
        new Cotuba().executa(leitorOpcoesCLI, new ImprimeNoConsole(), mDsDoDiretorio);

        String projectPath = System.getProperty("user.dir");
        File file = new File(projectPath + "\\book.pdf");
        String st = readPdf(file);
        Assert.assertFalse(st.isEmpty());
    }

    private String readPdf(File file) throws IOException {
        PDDocument document = null;
        document = PDDocument.load(file);
        PDFTextStripperByArea stripper = new PDFTextStripperByArea();
        stripper.setSortByPosition(true);
        PDFTextStripper Tstripper = new PDFTextStripper();
        return Tstripper.getText(document);
    }


}
