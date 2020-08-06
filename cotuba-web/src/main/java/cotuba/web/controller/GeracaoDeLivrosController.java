package cotuba.web.controller;

import cotuba.domain.Formato;
import cotuba.web.application.GeracaoDeLivros;
import cotuba.web.utils.CotubaFileUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.nio.file.Path;

@Controller
public class GeracaoDeLivrosController {

    private final GeracaoDeLivros geracao;

    public GeracaoDeLivrosController(GeracaoDeLivros geracao) {
        this.geracao = geracao;
    }

    @GetMapping("/livros/{id}/pdf")
    public ResponseEntity<ByteArrayResource> geraPDF(@PathVariable("id") Long id) {
        Path pdf = geracao.geraLivro(id, Formato.PDF);
        ResponseEntity<ByteArrayResource> pdfResource = CotubaFileUtils.montaResponseOArquivo(pdf, "application/pdf");
        CotubaFileUtils.clearTempFiles(pdf);
        return pdfResource;
    }

    @GetMapping("/livros/{id}/epub")
    public ResponseEntity<ByteArrayResource> geraEPUB(@PathVariable("id") Long id) {
        Path epub = geracao.geraLivro(id, Formato.EPUB);
        ResponseEntity<ByteArrayResource> epubResource = CotubaFileUtils.montaResponseOArquivo(epub, "application/epub+zip");
        CotubaFileUtils.clearTempFiles(epub);
        return epubResource;
    }

}
