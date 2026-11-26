package tests;

import base.BaseTest;
import org.junit.jupiter.api.*;
import pages.RecuperacaoSenhaPage;

import static org.junit.jupiter.api.Assertions.*;

public class RecuperacaoSenhaTests extends BaseTest {

    @Test
    @DisplayName("CT019 - Recuperação de senha com CPF inválido")
    void ct019RecuperacaoSenhaCpfInvalido() {
        RecuperacaoSenhaPage recuperacao =
                new RecuperacaoSenhaPage(driver);

        recuperacao.abrirRecuperacaoSenha();
        recuperacao.informarCpf("000.000.000-00");
        recuperacao.enviar();

        assertTrue(
                recuperacao.cpfInvalidoExibido()
        );

        aguardarVisualizacao();
    }

    @Test
    @DisplayName("CT020 - Solicitar recuperação de senha com CPF aceito pelo formulário")
    void ct020SolicitarRecuperacaoSenha() {
        RecuperacaoSenhaPage recuperacao =
                new RecuperacaoSenhaPage(driver);

        recuperacao.abrirRecuperacaoSenha();
        recuperacao.informarCpf("012.345.678-90");
        recuperacao.enviar();

        assertTrue(
                recuperacao.confirmacaoExibida()
        );

        aguardarVisualizacao();
    }
}