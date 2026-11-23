package utils;

import io.github.cdimascio.dotenv.Dotenv;

public class ConfigReader {

    private static final Dotenv dotenv = Dotenv.configure()
            .ignoreIfMissing()
            .load();

    public static String get(String chave) {
        String valor = dotenv.get(chave);
        if (valor == null || valor.isEmpty()) {
            throw new RuntimeException("A variável '" + chave + "' não foi encontrada no arquivo .env!");
        }
        return valor;
    }
}
