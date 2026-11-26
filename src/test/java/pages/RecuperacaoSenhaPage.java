package pages;

import org.openqa.selenium.*;

public class RecuperacaoSenhaPage extends BasePage {

    public RecuperacaoSenhaPage(WebDriver driver) {
        super(driver);
    }

    private final By btnEntrar =
            By.xpath("//span[@class='user-info']//span[contains(normalize-space(), 'Entre ou cadastre-se')]");

    private final By btnEsqueciSenha =
            By.cssSelector("div.modal-login__forgot-password button");

    private final By campoCpf =
            By.cssSelector("#forgotPassForm input[type='tel'][inputmode='numeric']");

    private final By btnEnviar =
            By.xpath("//form[@id='forgotPassForm']/following-sibling::button[normalize-space()='ENVIAR']");

    private final By mensagemCpfInvalido =
            By.xpath("//form[@id='forgotPassForm']//p[normalize-space()='CPF inválido!']");

    private final By mensagemConfirmacao =
            By.xpath("//p[contains(normalize-space(), 'Se você tem uma conta na Renner')]");

    public void abrirRecuperacaoSenha() {
        clicar(btnEntrar);
        clicarComJS(btnEsqueciSenha);
        esperarVisivel(campoCpf);
    }

    public void informarCpf(String cpf) {
        digitar(campoCpf, cpf);
    }

    public void enviar() {
        clicarComJS(btnEnviar);
    }

    public boolean cpfInvalidoExibido() {
        return esperarVisivel(mensagemCpfInvalido)
                .getText()
                .contains("CPF inválido!");
    }

    public boolean confirmacaoExibida() {
        return esperarVisivel(mensagemConfirmacao)
                .getText()
                .contains("Se você tem uma conta na Renner");
    }
}