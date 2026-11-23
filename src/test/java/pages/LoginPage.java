package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By btnEntrar =
            By.xpath("//span[@class='user-info']//span[contains(normalize-space(), 'Entre ou cadastre-se')]");
    private final By campoEmail =
            By.cssSelector("input[name='login']");
    private final By campoSenha =
            By.cssSelector("input[name='password']");
    private final By btnLogin =
            By.xpath("//div[contains(@class,'modal-login__form-action')]//button[normalize-space()='ENTRAR']");

    public void abrirTelaLogin() {
        clicar(btnEntrar);
    }

    public void informarEmail(String email) {
        digitar(campoEmail, email);
    }

    public void informarSenha(String senha) {
        digitar(campoSenha, senha);
    }

    public void clicarLogin() {
        clicar(btnLogin);
    }

    public String obterUrlAtual() {
        return driver.getCurrentUrl();
    }

    public String obterPagina() {
        return driver.getPageSource();
    }

    public boolean contemTexto(String texto) {

        return obterPagina()
                .toLowerCase()
                .contains(texto.toLowerCase());
    }
}