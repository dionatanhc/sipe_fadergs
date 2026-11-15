package tests;

import br.com.renner.utils.DriverFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class BuscaTests {
    @Test
    public void abrirSiteRenner() {

        WebDriver driver = DriverFactory.getDriver();

        driver.get("https://www.lojasrenner.com.br");

        System.out.println(driver.getTitle());

        driver.quit();
    }
}
