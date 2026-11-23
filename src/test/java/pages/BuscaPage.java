package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuscaPage extends BasePage {

    private final By campoBusca =
            By.cssSelector("input[type='search']");

    public BuscaPage(WebDriver driver) {
        super(driver);
    }

    public void buscarProduto(String termo) {

        WebElement campo =
                esperarVisivel(campoBusca);

        campo.clear();
        campo.sendKeys(termo);
        campo.sendKeys(Keys.ENTER);
    }

    public String getUrlAtual() {
        return driver.getCurrentUrl();
    }
}