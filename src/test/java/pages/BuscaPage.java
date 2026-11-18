package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BuscaPage extends BasePage {

    // ATENÇÃO: confirme os seletores reais inspecionando o site (F12)
    private final By campoBusca = By.cssSelector("input[type='search']");

    public BuscaPage(WebDriver driver) {
        super(driver);
    }

    public void buscarProduto(String termo) {
        digitar(campoBusca, termo);
        driver.findElement(campoBusca).sendKeys(Keys.ENTER);
    }

    public String getUrlAtual() {
        return driver.getCurrentUrl();
    }
}