module	cotuba.core	{
    uses cotuba.plugin.Tema;
    uses cotuba.application.GeradorEbook;
    uses cotuba.plugin.AoFinalizarGeracao;
    requires org.commonmark;
    requires org.jsoup;
    exports	cotuba.application;
    exports	cotuba.plugin;
    exports	cotuba.domain;
}
