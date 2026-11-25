package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FiltroPage extends BasePage {

    public FiltroPage(WebDriver driver) {
        super(driver);
    }

    private final By btnFiltrarOrdenar =
            By.cssSelector("div[class*='RecordFilter_openFilterButtonWrapper'] button");

    private final By filtroGenero =
            By.xpath("//span[contains(@class,'Filter_categoryName') and normalize-space()='Gênero']");

    private final By generoMasculino =
            By.xpath("//span[normalize-space()='Masculino']");

    private final By filtroTamanho =
            By.xpath("//span[contains(@class,'Filter_categoryName') and normalize-space()='Tamanho']");

    private final By tamanhoG =
            By.xpath("//span[contains(@class,'checkbox-container__label') and normalize-space()='G']");

    private final By btnAplicar =
            By.xpath("//button[normalize-space()='APLICAR']");

    private final By btnLimparFiltros =
            By.xpath("//button[normalize-space()='LIMPAR FILTROS']");

    public void abrirFiltros() {
        clicar(btnFiltrarOrdenar);
        esperarPresenca(filtroGenero);
    }

    public void reabrirFiltros() {
        clicar(btnFiltrarOrdenar);
    }

    public void abrirFiltroGenero() {
        clicarComJS(filtroGenero);
        esperarPresenca(generoMasculino);
    }

    public void selecionarGeneroMasculino() {
        clicarComJS(generoMasculino);
    }

    public void abrirFiltroTamanho() {
        clicarComJS(filtroTamanho);
        esperarPresenca(tamanhoG);
    }

    public void selecionarTamanhoG() {
        clicarComJS(tamanhoG);
    }

    public void aplicarFiltros() {
        clicarComJS(btnAplicar);
    }

    public void limparFiltros() {
        rolarAte(btnLimparFiltros);
        clicarComJS(btnLimparFiltros);
    }
}