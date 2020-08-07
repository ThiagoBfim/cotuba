import cotuba.pdf.GeradorPDF;

module cotuba.pdf {
    exports cotuba.pdf;

    requires cotuba.core;
    requires html2pdf;
    requires io;
    requires kernel;
    requires layout;

    provides cotuba.application.GeradorEbook with GeradorPDF;
}
