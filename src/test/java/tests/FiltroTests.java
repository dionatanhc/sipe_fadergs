package tests;

import base.BaseTest;
import org.junit.jupiter.api.*;
import pages.BuscaPage;
import pages.FiltroPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FiltroTests extends BaseTest {

    @Test
    @DisplayName("CT012 - Aplicar filtro de gênero masculino")
    void ct012AplicarFiltroGeneroMasculino() {
        BuscaPage busca = new BuscaPage(driver);
        FiltroPage filtro = new FiltroPage(driver);

        busca.buscarProduto("camiseta");

        filtro.abrirFiltros();
        filtro.abrirFiltroGenero();
        filtro.selecionarGeneroMasculino();
        filtro.aplicarFiltros();

        assertTrue(
                busca.possuiProdutos()
        );
    }

    @Test
    @DisplayName("CT013 - Aplicar filtros de gênero e tamanho")
    void ct013AplicarFiltrosGeneroETamanho() {
        BuscaPage busca = new BuscaPage(driver);
        FiltroPage filtro = new FiltroPage(driver);

        busca.buscarProduto("camiseta");

        filtro.abrirFiltros();

        filtro.abrirFiltroGenero();
        filtro.selecionarGeneroMasculino();

        filtro.abrirFiltroTamanho();
        filtro.selecionarTamanhoG();

        filtro.aplicarFiltros();

        assertTrue(
                busca.possuiProdutos()
        );
    }

    @Test
    @DisplayName("CT014 - Limpar filtros aplicados")
    void ct014LimparFiltrosAplicados() {
        BuscaPage busca = new BuscaPage(driver);
        FiltroPage filtro = new FiltroPage(driver);

        busca.buscarProduto("camiseta");

        filtro.abrirFiltros();

        filtro.abrirFiltroGenero();
        filtro.selecionarGeneroMasculino();

        filtro.abrirFiltroTamanho();
        filtro.selecionarTamanhoG();

        filtro.aplicarFiltros();

        assertTrue(
                busca.possuiProdutos()
        );

        filtro.reabrirFiltros();
        filtro.limparFiltros();

        assertTrue(
                busca.possuiProdutos()
        );
    }
}