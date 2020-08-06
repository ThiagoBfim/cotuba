package cotuba.application;


import cli.ImprimeNoConsole;
import cli.LeitorOpcoesCLI;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class MainTest {

    private String pathWithMdFiles;

    @Before
    public void setUp() {
        String projectPath = System.getProperty("user.dir");
        pathWithMdFiles = projectPath.replaceAll("cotuba-cli", "") + "exemplo";
    }

    @Test
    public void testGeracaoEpub() {
        LeitorOpcoesCLI leitorOpcoesCLI = new LeitorOpcoesCLI("-d", pathWithMdFiles, "-f", "epub");
        new Cotuba().executa(leitorOpcoesCLI, new ImprimeNoConsole());
    }

    @Test
    public void testGeracaoPDF() throws IOException {
        LeitorOpcoesCLI leitorOpcoesCLI = new LeitorOpcoesCLI("-d", pathWithMdFiles);
        new Cotuba().executa(leitorOpcoesCLI, new ImprimeNoConsole());

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
