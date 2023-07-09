package org.group2.infra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.util.Optional;

public class ExecuteSQLfile {
    public static void executeSqlFile (String file_path) {

        // Abre o arquivo e inicializa um StringBuilder para a leitura dos comandos SQL
        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {

            StringBuilder sb = new StringBuilder();
            String linha;

            // Lê a próxima linha. Repete enquanto linha não for nula
            while ((linha = br.readLine()) != null) {

                // adiciona a linha ao StringBuilder e quebra de linha ao final
                sb.append(linha).append(System.lineSeparator());
            }

            // Converte o StringBuilder em uma String
            String sql = sb.toString();

            // executa as instruções SQL contidas no arquivo
            ConnectionFactory.getConnection().createStatement().execute(sql);

            br.close();

        } catch (Exception ex) {
            System.out.println("QueryLibs.executeSqlFile() -- Erro ao executar query para o arquivo " + file_path);
            ex.printStackTrace();
        }
    }
}
