package tests;

import base.BaseTest;
import org.junit.jupiter.api.*;
import pages.BuscaPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuscaTests extends BaseTest {

    @Test
    @DisplayName("CT009 - Busca de produto com termo válido")
    void ct009BuscaProdutoValido() {
        BuscaPage busca = new BuscaPage(driver);
        busca.buscarProduto("camiseta");

        aguardarVisualizacao();

        assertEquals(
                "\"camiseta\"",
                busca.obterTermoBuscado().toLowerCase()
        );

        assertTrue(
                busca.possuiProdutos()
        );
    }

    @Test
    @DisplayName("CT010 - Busca por termo sem correspondência direta")
    void ct010BuscaTermoSemCorrespondenciaDireta() {
        BuscaPage busca = new BuscaPage(driver);
        busca.buscarProduto("produtoautomatizadoinexistente987654");

        aguardarVisualizacao();

        assertEquals(
                "\"produtoautomatizadoinexistente987654\"",
                busca.obterTermoBuscado().toLowerCase()
        );

        assertTrue(
                busca.possuiProdutos()
        );
    }

    @Test
    @DisplayName("CT011 - Busca com campo vazio")
    void ct011BuscaCampoVazio() {
        BuscaPage busca = new BuscaPage(driver);

        busca.buscarCampoVazio();

        aguardarVisualizacao();

        assertTrue(
                busca.obterUrlAtual().contains("/b?Ntt=")
        );

        assertTrue(
                busca.possuiProdutos()
        );
    }
}