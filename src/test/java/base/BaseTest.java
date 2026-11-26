package base;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import utils.DriverFactory;

public abstract class BaseTest {

    protected WebDriver driver;

    private final By btnAceitarPrivacidade =
            By.xpath("//button[contains(normalize-space(.), 'Li, aceito os Termos de Uso')]");

    @BeforeEach
    public void abrirNavegador() {
        driver = DriverFactory.criarDriver();
        driver.get("https://www.lojasrenner.com.br");

        aceitarPrivacidadeSeExistir();
    }

    private void aceitarPrivacidadeSeExistir() {
        try {
            var botoes = driver.findElements(btnAceitarPrivacidade);

            if (!botoes.isEmpty()) {
                WebElement botao = botoes.get(0);

                ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].click();", botao);
            }
        } catch (Exception ignored) {
        }
    }

    protected void aguardarVisualizacao() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @AfterEach
    public void fecharNavegador() {
        if (driver != null) {
            driver.quit();
        }
    }
}