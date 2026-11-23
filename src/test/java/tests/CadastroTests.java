package tests;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CadastroPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CadastroTests extends BaseTest {

    @Test
    @DisplayName("CT005 - Tentativa de cadastro com campos obrigatórios vazios")
    void ct005CamposObrigatoriosVazios() {
        CadastroPage cadastro = new CadastroPage(driver);
        cadastro.abrirTelaCadastro();
        cadastro.clicarCadastrar();

        aguardarVisualizacao();
        assertTrue(cadastro.contemTexto("este campo é obrigatório"));
    }

    @Test
    @DisplayName("CT006 - Cadastro com CPF inválido")
    void ct006CpfInvalido() {
        CadastroPage cadastro = new CadastroPage(driver);
        cadastro.abrirTelaCadastro();
        cadastro.informarEmail("teste.qa@exemplo.com");
        cadastro.informarCpf("11111111111");
        cadastro.informarNome("Usuario");
        cadastro.informarSobrenome("Teste");
        cadastro.aceitarTermos();
        cadastro.clicarRecaptcha();
        cadastro.clicarCadastrar();

        aguardarVisualizacao();
        assertTrue(cadastro.contemTexto("cpf inválido") || cadastro.contemTexto("inválido"));
    }

    @Test
    @DisplayName("CT007 - Cadastro com e-mail em formato inválido")
    void ct007EmailFormatoInvalido() {
        CadastroPage cadastro = new CadastroPage(driver);
        cadastro.abrirTelaCadastro();
        cadastro.informarEmail("emailsemarroba.com");
        cadastro.informarNome("Usuario");
        cadastro.aceitarTermos();
        cadastro.clicarRecaptcha();
        cadastro.clicarCadastrar();

        aguardarVisualizacao();
        assertTrue(cadastro.contemTexto("e-mail inválido") || cadastro.contemTexto("inválido"));
    }

    @Test
    @DisplayName("CT008 - Cadastro com senha fora do padrão mínimo de segurança")
    void ct008SenhaFraca() {
        CadastroPage cadastro = new CadastroPage(driver);
        cadastro.abrirTelaCadastro();
        cadastro.informarEmail("teste.qa@exemplo.com");
        cadastro.informarNome("Usuario");
        cadastro.informarSenha("123");
        cadastro.aceitarTermos();
        cadastro.clicarRecaptcha();
        cadastro.clicarCadastrar();

        aguardarVisualizacao();
        assertTrue(cadastro.contemTexto("Ao menos 6 caracteres com letras e números"));
    }
}
