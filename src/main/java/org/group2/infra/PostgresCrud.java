package org.group2.infra;


import org.group2.core.model.Professor;
import org.group2.core.repository.ProfessorRepository;

import java.sql.*;
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
                        (nome, dataNascimento, 
                        cargaHoraria, 
                        valorHora, estrangeiro, 
                        horasDisponiveis, 
                        biografia, 
                        dataHoraCadastro) 
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

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Professor professor, Long id) {
        
    }

    @Override
    public Professor getById (int id) {
        Professor professor = null;
        try {
            String sql = "SELECT * FROM tab_professor WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);

            ResultSet result = statement.executeQuery();

            while (result.next()){
                professor = new Professor(
                    result.getInt("id"),
                    result.getString("nome"),
                    (result.getDate("dataNascimento")).toLocalDate(),
                    (result.getTime("cargaHoraria")).toLocalTime(),
                    result.getBigDecimal("valorHora"),
                    result.getBoolean("estrangeiro"),
                    result.getInt("horasDisponiveis"),
                    result.getString("biografia"),
                    (result.getTimestamp("dataHoraCadastro")).toLocalDateTime()
                    );
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return professor;
    }
    

    @Override
    public List<Professor> getAll() {
        return null;
    }
}
