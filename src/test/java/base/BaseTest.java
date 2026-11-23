package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void abrirNavegador() {

        driver = DriverFactory.criarDriver();

        driver.get("https://www.lojasrenner.com.br");
    }

    protected void aguardarVisualizacao() {

        try {
            Thread.sleep(10000);
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