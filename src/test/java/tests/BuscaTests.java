package tests;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BuscaPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuscaTests extends BaseTest {

    @Test
    @DisplayName("Deve abrir o site da Renner")
    void abrirSiteRenner() {
        assertTrue(driver.getTitle().toLowerCase().contains("renner"));
    }

    @Test
    @DisplayName("Deve buscar um produto existente")
    void buscarProdutoExistente() {
        BuscaPage busca = new BuscaPage(driver);
        busca.buscarProduto("camiseta");
        assertTrue(busca.getUrlAtual().contains("camiseta"));
    }
}