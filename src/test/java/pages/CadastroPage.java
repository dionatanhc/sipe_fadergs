package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroPage extends BasePage {

    public CadastroPage(WebDriver driver) {
        super(driver);
    }

    // Navegação até o formulário de cadastro
    private final By btnEntrarOuCadastrar =
            By.xpath("//span[@class='user-info']//span[contains(normalize-space(), 'Entre ou cadastre-se')]");
    private final By btnQueroMeCadastrar =
            By.cssSelector("div.modal-login__register-container button");

    // Campos reais do formulário de cadastro
    private final By campoEmail = By.cssSelector("form.modal-register__form input[name='login']");
    private final By campoCpf = By.xpath("(//form[@class='modal-register__form']//input[@inputmode='numeric'])[1]");
    private final By campoNome = By.cssSelector("form.modal-register__form input[name='firstName']");
    private final By campoSobrenome = By.cssSelector("form.modal-register__form input[name='lastName']");
    private final By campoSenha = By.cssSelector("form.modal-register__form input[name='password']");

    // Termos de Uso, reCAPTCHA e Botão Final
    private final By checkboxTermos =
            By.cssSelector("form.modal-register__form input[name='legalTermsAcceptance']");
    private final By iframeRecaptcha = By.cssSelector("iframe[title='reCAPTCHA']");
    private final By checkboxRecaptcha = By.id("recaptcha-anchor");
    private final By btnFinalizarCadastro =
            By.xpath("//div[contains(@class,'modal-login__form-action')]//button[normalize-space()='Cadastrar']");

    public void abrirTelaCadastro() {
        clicar(btnEntrarOuCadastrar);
        try {
            clicar(btnQueroMeCadastrar);
        } catch (Exception e) {
            // Caso algum banner/overlay tenha absorvido o primeiro clique, clica novamente
            clicar(btnEntrarOuCadastrar);
            clicar(btnQueroMeCadastrar);
        }
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
                .executeScript("arguments[0].scrollIntoView({block: 'center'}); arguments[0].click();", checkbox);
    }

    public void clicarRecaptcha() {
        var wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(15));

        // Aguarda o iframe existir no DOM e já entra nele automaticamente
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeRecaptcha));

        clicar(checkboxRecaptcha);

        // Aguarda o check verde (aria-checked="true") antes de sair
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.attributeToBe(
                checkboxRecaptcha, "aria-checked", "true"
        ));

        driver.switchTo().defaultContent();
    }

    public void clicarCadastrar() {
        clicar(btnFinalizarCadastro);
    }

    public boolean contemTexto(String texto) {
        return driver.getPageSource()
                .toLowerCase()
                .contains(texto.toLowerCase());
    }
}
