package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarrinhoPage extends BasePage {

    public CarrinhoPage(WebDriver driver) {
        super(driver);
    }

    private final By tamanhoG =
            By.xpath("//span[normalize-space()='G']");

    private final By btnAdicionarSacola =
            By.cssSelector("button[aria-label='Buy Button']");

    private final By btnAceitarCookies =
            By.xpath("//button[contains(.,'OK')]");

    private final By iconeSacola =
            By.cssSelector("a[title='Sacola']");

    private final By btnAumentarQuantidade =
            By.cssSelector("button.add");

    private final By btnRemoverProduto =
            By.cssSelector("a.delete.icon-closed");

    private final By mensagemCarrinhoVazio =
            By.cssSelector("p.cart__title--empty");

    private final By campoCupom =
            By.cssSelector("input.couponTextBox");

    private final By btnAplicarCupom =
            By.cssSelector("a.addCouponButton");

    private final By mensagemCupomInvalido =
            By.xpath("//span[contains(text(),'Cupom de desconto inválido')]");

    public void selecionarTamanhoG() {

        rolarAte(tamanhoG);

        clicarComJS(tamanhoG);
    }

    public void aceitarCookiesSeExistir() {

        try {

            if (!driver.findElements(btnAceitarCookies).isEmpty()) {

                clicarComJS(btnAceitarCookies);
            }

        } catch (Exception ignored) {
        }
    }

    public void adicionarProduto() {

        aceitarCookiesSeExistir();

        rolarAte(btnAdicionarSacola);

        clicarComJS(btnAdicionarSacola);
    }

    public void abrirSacola() {

        clicarComJS(iconeSacola);
    }

    public void aumentarQuantidade() {

        clicarComJS(btnAumentarQuantidade);
    }

    public void removerProduto() {

        clicarComJS(btnRemoverProduto);
    }

    public void informarCupom(String cupom) {

        digitar(campoCupom, cupom);
    }

    public void aplicarCupom() {

        clicarComJS(btnAplicarCupom);
    }

    public boolean carrinhoEstaVazio() {

        return esperarVisivel(mensagemCarrinhoVazio)
                .getText()
                .contains("Sua sacola está vazia");
    }

    public boolean cupomInvalidoExibido() {

        return esperarVisivel(mensagemCupomInvalido)
                .getText()
                .contains("Cupom de desconto inválido");
    }

    public boolean contemTexto(String texto) {

        return driver.getPageSource()
                .toLowerCase()
                .contains(texto.toLowerCase());
    }
}