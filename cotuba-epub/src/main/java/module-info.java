import cotuba.epub.GeradorEPUB;

module cotuba.epub {
    exports cotuba.epub;
    
    requires cotuba.core;
    requires epublib.core;

    provides cotuba.application.GeradorEbook with GeradorEPUB;
}
