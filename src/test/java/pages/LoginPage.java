package pages;

import base.BasePage;
import org.openqa.selenium.*;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By btnEntrar =
            By.cssSelector("span.user-info");

    private final By campoEmail =
            By.cssSelector("input[name='login'][aria-label='E-mail ou CPF']");

    private final By campoSenha =
            By.cssSelector("input[name='password']");

    private final By btnLogin =
            By.xpath("//div[contains(@class,'modal-login__form-action')]//button[normalize-space()='ENTRAR']");

    public void abrirTelaLogin() {
        clicar(btnEntrar);
        esperarVisivel(campoEmail);
    }

    public void informarEmail(String email) {
        digitar(campoEmail, email);
    }

    public void informarSenha(String senha) {
        digitar(campoSenha, senha);
    }

    public void clicarLogin() {
        clicarComJS(btnLogin);
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