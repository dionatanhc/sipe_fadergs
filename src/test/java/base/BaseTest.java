package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    void abrirNavegador() {
        driver = DriverFactory.criarDriver();
        driver.get("https://www.lojasrenner.com.br");
    }

    @AfterEach
    void fecharNavegador() {
        if (driver != null) {
            driver.quit();
        }
    }
}