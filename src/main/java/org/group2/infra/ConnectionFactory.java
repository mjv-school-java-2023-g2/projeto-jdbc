package org.group2.infra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static Connection connection;

    public static void startConnection() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(
                        "jdbc:postgresql://" +
                                System.getenv("DB_HOST") + ":" +
                                System.getenv("DB_PORT") + "/" +
                                System.getenv("DB_DATABASE"),
                                System.getenv("DB_USERNAME"),
                                System.getenv("DB_PASSWORD")
                );
                System.out.println("CONEXAO REALIZADA COM SUCESSO");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Erro ao tentar realizar uma conexão");
        }
    }

    public static Connection getConnection() {

        return connection;
    }
}
