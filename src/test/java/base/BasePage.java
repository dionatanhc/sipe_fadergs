package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );
    }

    protected WebElement esperarVisivel(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    protected WebElement esperarPresenca(By locator) {
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );
    }

    protected void clicar(By locator) {
        wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        ).click();
    }

    protected void clicarComJS(By locator) {
        WebElement elemento = esperarPresenca(locator);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", elemento);
    }

    protected void rolarAte(By locator) {
        WebElement elemento = esperarPresenca(locator);

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block: 'center'});",
                        elemento
                );
    }

    protected void digitar(By locator, String texto) {
        WebElement elemento = esperarVisivel(locator);

        elemento.clear();
        elemento.sendKeys(texto);
    }
}
