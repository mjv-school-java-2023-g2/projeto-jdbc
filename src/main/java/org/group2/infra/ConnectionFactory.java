package org.group2.infra;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static Connection connection;
    public static void startConnection(){
        try{
            if(connection==null) {
                connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/live-spring-data-jpa",
                        "postgres",
                        "1234567"
                );
                System.out.println("CONEXAO REALIZADA COM SUCESSO");
            }
        }catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException("Erro ao tentar realizar uma conexão");
        }
    }
    public static Connection getConnection(){

        return connection;
    }
}
