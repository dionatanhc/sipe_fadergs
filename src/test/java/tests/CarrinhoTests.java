package tests;

import base.BaseTest;
import org.junit.jupiter.api.*;
import pages.BuscaPage;
import pages.CarrinhoPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarrinhoTests extends BaseTest {

    private void adicionarProdutoBase() {

        BuscaPage busca =
                new BuscaPage(driver);

        CarrinhoPage carrinho =
                new CarrinhoPage(driver);

        busca.buscarProduto("camiseta");

        aguardarVisualizacao();

        busca.abrirPrimeiroProduto();

        aguardarVisualizacao();

        carrinho.selecionarTamanhoG();

        aguardarVisualizacao();

        carrinho.adicionarProduto();

        aguardarVisualizacao();

        carrinho.abrirSacola();

        aguardarVisualizacao();
    }

    @Test
    @DisplayName("CT015 - Adicionar produto ao carrinho")
    void ct015AdicionarProdutoAoCarrinho() {

        adicionarProdutoBase();

        assertTrue(
                driver.getTitle()
                        .contains("Minha Sacola")
        );
    }

    @Test
    @DisplayName("CT016 - Alterar quantidade de produto")
    void ct016AlterarQuantidadeProduto() {

        adicionarProdutoBase();

        CarrinhoPage carrinho =
                new CarrinhoPage(driver);

        carrinho.aumentarQuantidade();

        aguardarVisualizacao();

        assertTrue(
                driver.getCurrentUrl()
                        .contains("/sacola")
        );
    }

    @Test
    @DisplayName("CT017 - Remover produto do carrinho")
    void ct017RemoverProdutoCarrinho() {

        adicionarProdutoBase();

        CarrinhoPage carrinho =
                new CarrinhoPage(driver);

        carrinho.removerProduto();

        aguardarVisualizacao();

        assertTrue(
                carrinho.carrinhoEstaVazio()
        );
    }

    @Test
    @DisplayName("CT018 - Aplicar cupom inválido")
    void ct018AplicarCupomInvalido() {

        adicionarProdutoBase();

        CarrinhoPage carrinho =
                new CarrinhoPage(driver);

        carrinho.informarCupom(
                "RENNER2026"
        );

        carrinho.aplicarCupom();

        aguardarVisualizacao();

        assertTrue(
                carrinho.cupomInvalidoExibido()
        );
    }
}