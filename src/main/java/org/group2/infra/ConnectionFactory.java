package org.group2.infra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static Connection connection;

    public static void startConnection() {
        try {
            if (connection == null) {

                // com a finalidade de não deixar público a senha do BD, salvo a mesma no
                // arquivo .env, incluso no gitignore
                String[] env = new String[] {
                        "host",
                        "port",
                        "database",
                        "userName",
                        "password",
                };
                try (BufferedReader br = new BufferedReader(new FileReader(".env"))) {
                    for (int i = 0; i < env.length; i++)
                        env[i] = br.readLine().split(" = ")[1];
                } catch (Exception e) {
                    e.printStackTrace();
                }

                connection = DriverManager.getConnection(
                        "jdbc:postgresql://" + env[0] + ":" + env[1] + "/" + env[2],
                        env[3],
                        env[4]);
                System.out.println("CONEXAO REALIZADA COM SUCESSO");
            }
        } catch (Exception ex) {
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Erro ao tentar realizar uma conexão");
        }
    }

    public static Connection getConnection() {

    public static Connection getConnection() {

        return connection;
    }
}

