package org.group2.infra;


import org.group2.core.model.Professor;
import org.group2.core.repository.ProfessorRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgresCrud implements ProfessorRepository {
    private Connection connection;
    public PostgresCrud(){
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void save(Professor professor) {
        try {
            String sql =
                    """ 
                    INSERT INTO tab_professor 
                        (nome, data_nascimento, 
                        carga_horaria, 
                        valor_hora, estrangeiro, 
                        horas_disponiveis, 
                        biografia, 
                        dh_cadastro) 
                    VALUES 
                        (?,?,?,?,?,?,?,?)
                    """;

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, professor.getNome());
            statement.setDate(2, Date.valueOf(professor.getDataNascimento()));
            statement.setTime(3, Time.valueOf(professor.getCargaHoraria()));
            statement.setDouble(4, professor.getValorHora().doubleValue());
            statement.setBoolean(5, professor.isEstrangeiro());
            statement.setInt(6, professor.getHorasDisponiveis());
            statement.setString(7, professor.getBiografia());
            statement.setTimestamp(8, Timestamp.valueOf(professor.getDataHoraCadastro()));

            statement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id){
        try {
            String sql =
                """
                DELETE FROM 
                    tab_professor 
                WHERE name LIKE ?;
                """;
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, Math.toIntExact(id));
        statement.execute(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Professor professor, Long id){
        try {
            String sql =
                    """
                UPDATE 
                    tab_professor 
                SET 
                    nome = ?,
                    data_nascimento = ?,
                    carga_horaria = ?,
                    valor_hora = ?,
                    estrangeiro = ?,
                    horas_disponiveis = ?,
                    biografia = ?
                 WHERE  name = 'GustavoF';
                """;

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, professor.getNome());
        statement.setDate(2, Date.valueOf(professor.getDataNascimento()));
        statement.setTime(3, Time.valueOf(professor.getCargaHoraria()));
        statement.setDouble(4, professor.getValorHora().doubleValue());
        statement.setBoolean(5, professor.isEstrangeiro());
        statement.setInt(6, professor.getHorasDisponiveis());
        statement.setString(7, professor.getBiografia());

        statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Professor getById(Long id) {
        Professor professor = null;
        try {
            String sql = "SELECT * FROM tab_professor WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Math.toIntExact(id));

            ResultSet result = statement.executeQuery();

            while (result.next()){
                professor = new Professor(
                        result.getLong("id"),
                        result.getString("name"),
                        result.getDate("data_nascimento").toLocalDate(),
                        result.getTime("carga_horaria").toLocalTime(),
                        result.getBigDecimal("valor_hora"),
                        result.getBoolean("estrangeiro"),
                        result.getInt("horas_disponiveis"),
                        result.getString("biografia"),
                        result.getTimestamp("dh_cadastro").toLocalDateTime());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return professor;
    }

    @Override
    public List<Professor> getAll() {
        List<Professor> professores = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tab_professor";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()){
                professores.add(
                        new Professor(
                        result.getLong("id"),
                        result.getString("name"),
                        result.getDate("data_nascimento").toLocalDate(),
                        result.getTime("carga_horaria").toLocalTime(),
                        result.getBigDecimal("valor_hora"),
                        result.getBoolean("estrangeiro"),
                        result.getInt("horas_disponiveis"),
                        result.getString("biografia"),
                        result.getTimestamp("dh_cadastro").toLocalDateTime()
                        )
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return professores;
    }
}
