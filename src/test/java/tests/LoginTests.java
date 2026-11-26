package tests;

import base.BaseTest;
import org.junit.jupiter.api.*;
import pages.LoginPage;
import utils.ConfigReader;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends BaseTest {

    @Test
    @DisplayName("CT001 - E-mail ou Login inválido")
    void ct001EmailOuLoginInvalido() {
        LoginPage login = new LoginPage(driver);
        login.abrirTelaLogin();
        login.informarEmail("emailinvalido");
        login.informarSenha("Senha123");
        login.clicarLogin();

        aguardarVisualizacao();
        assertTrue(
                login.contemTexto("tente novamente")
        );
    }

    @Test
    @DisplayName("CT002 - Senha vazia")
    void ct002SenhaVazia() {
        LoginPage login = new LoginPage(driver);
        login.abrirTelaLogin();
        login.informarEmail("teste@email.com");
        login.informarSenha("");
        login.clicarLogin();

        aguardarVisualizacao();
        assertTrue(
                login.contemTexto("obrigatório")
        );
    }

    @Test
    @DisplayName("CT003 - Credenciais inválidas ou fictícias")
    void ct003CredenciaisInvalidasOuFicticias() {
        LoginPage login = new LoginPage(driver);
        login.abrirTelaLogin();
        login.informarEmail("usuario.ficticio@teste.com");
        login.informarSenha("SenhaFicticia123");
        login.clicarLogin();

        aguardarVisualizacao();
        assertTrue(
                login.contemTexto("inválida")
        );
    }

    // CT004 depende de credenciais válidas para validação completa.
    @Test
    @DisplayName("CT004 - Login válido")
    void ct004LoginValido() {
        LoginPage login = new LoginPage(driver);
        login.abrirTelaLogin();
        login.informarEmail(ConfigReader.get("APP_USER"));
        login.informarSenha(ConfigReader.get("APP_PASS"));
        login.clicarLogin();

        aguardarVisualizacao();
        assertTrue(
                login.obterUrlAtual().contains("lojasrenner")
        );
    }
}