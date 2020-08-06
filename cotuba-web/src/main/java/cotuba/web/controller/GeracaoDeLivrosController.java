package cotuba.web.controller;

import cotuba.domain.Formato;
import cotuba.web.application.GeracaoDeLivros;
import cotuba.web.utils.SpringFileUtils;
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
        ResponseEntity<ByteArrayResource> pdfResource = SpringFileUtils.montaResponseOArquivo(pdf, "application/pdf");
        geracao.clearTempFiles();
        return pdfResource;
    }

    @GetMapping("/livros/{id}/epub")
    public ResponseEntity<ByteArrayResource> geraEPUB(@PathVariable("id") Long id) {
        Path epub = geracao.geraLivro(id, Formato.EPUB);
        ResponseEntity<ByteArrayResource> epubResource = SpringFileUtils.montaResponseOArquivo(epub, "application/epub+zip");
        geracao.clearTempFiles();
        return epubResource;
    }

}
