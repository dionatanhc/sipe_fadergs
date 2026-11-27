package pages;

import base.BasePage;
import org.openqa.selenium.*;

public class BuscaPage extends BasePage {

    public BuscaPage(WebDriver driver) {
        super(driver);
    }

    private final By campoBusca =
            By.name("Ntt");

    private final By termoBuscado =
            By.xpath("//h1[.//label[contains(normalize-space(), 'Resultados da busca por:')]]/strong");

    private final By cardsProduto =
            By.cssSelector("[data-product-id][data-sku-id]");

    private final By primeiroProduto =
            By.cssSelector("h3.ProductBox_title__x9UGh");

    public void buscarProduto(String termo) {

        digitar(campoBusca, termo);

        esperarVisivel(campoBusca)
                .sendKeys(Keys.ENTER);
    }

    public void buscarCampoVazio() {

        esperarVisivel(campoBusca)
                .sendKeys(Keys.ENTER);
    }

    public void abrirPrimeiroProduto() {

        rolarAte(primeiroProduto);

        clicarComJS(primeiroProduto);
    }

    public String obterTermoBuscado() {

        return esperarVisivel(termoBuscado)
                .getText();
    }

    public boolean possuiProdutos() {

        return wait.until(
                driver -> !driver.findElements(cardsProduto).isEmpty()
        );
    }

    public String obterUrlAtual() {

        return driver.getCurrentUrl();
    }
}