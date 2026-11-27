package pages;

import base.BasePage;
import org.openqa.selenium.*;

public class CadastroPage extends BasePage {

    public CadastroPage(WebDriver driver) {
        super(driver);
    }

    private final By btnEntrarOuCadastrar =
            By.cssSelector("span.user-info");

    private final By btnQueroMeCadastrar =
            By.xpath("//button[normalize-space()='QUERO ME CADASTRAR']");

    private final By campoEmail =
            By.cssSelector("input[name='login'][aria-label='E-mail']");

    private final By campoCpf =
            By.xpath("(//form[@class='modal-register__form']//input[@inputmode='numeric'])[1]");

    private final By campoNome =
            By.cssSelector("form.modal-register__form input[name='firstName']");

    private final By campoSobrenome =
            By.cssSelector("form.modal-register__form input[name='lastName']");

    private final By campoSenha =
            By.cssSelector("form.modal-register__form input[name='password']");

    private final By checkboxTermos =
            By.cssSelector("form.modal-register__form input[name='legalTermsAcceptance']");

    private final By iframeRecaptcha =
            By.cssSelector("iframe[title='reCAPTCHA']");

    private final By checkboxRecaptcha =
            By.id("recaptcha-anchor");

    private final By btnFinalizarCadastro =
            By.xpath("//div[contains(@class,'modal-login__form-action')]//button[normalize-space()='Cadastrar']");

    public void abrirTelaCadastro() {
        clicar(btnEntrarOuCadastrar);

        esperarVisivel(btnQueroMeCadastrar);
        clicar(btnQueroMeCadastrar);

        esperarVisivel(campoEmail);
    }

    public void informarEmail(String email) {
        digitar(campoEmail, email);
    }

    public void informarCpf(String cpf) {
        digitar(campoCpf, cpf);
    }

    public void informarNome(String nome) {
        digitar(campoNome, nome);
    }

    public void informarSobrenome(String sobrenome) {
        digitar(campoSobrenome, sobrenome);
    }

    public void informarSenha(String senha) {
        digitar(campoSenha, senha);
    }

    public void aceitarTermos() {
        var checkbox = driver.findElement(checkboxTermos);

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block: 'center'}); arguments[0].click();",
                        checkbox
                );
    }

    public void clicarRecaptcha() {

        try {

            var wait =
                    new org.openqa.selenium.support.ui.WebDriverWait(
                            driver,
                            java.time.Duration.ofSeconds(10)
                    );

            wait.until(
                    org.openqa.selenium.support.ui
                            .ExpectedConditions
                            .frameToBeAvailableAndSwitchToIt(
                                    iframeRecaptcha
                            )
            );

            clicar(checkboxRecaptcha);

            wait.until(
                    org.openqa.selenium.support.ui
                            .ExpectedConditions
                            .attributeToBe(
                                    checkboxRecaptcha,
                                    "aria-checked",
                                    "true"
                            )
            );

            driver.switchTo().defaultContent();

        } catch (Exception e) {

            driver.switchTo().defaultContent();

            System.out.println(
                    "reCAPTCHA não validado automaticamente."
            );
        }
    }

    public void clicarCadastrar() {

        try {
            driver.switchTo().defaultContent();
        } catch (Exception ignored) {
        }

        rolarAte(btnFinalizarCadastro);
        clicarComJS(btnFinalizarCadastro);
    }

    public boolean contemTexto(String texto) {
        return driver.getPageSource()
                .toLowerCase()
                .contains(texto.toLowerCase());
    }
}