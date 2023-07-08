package org.group2.infra;

import org.example.core.model.Professor;
import org.example.core.repository.ProfessorRepository;

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

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Professor professor, Long id) {
        return null;
    }

    @Override
    public Professor getById(Long id) {
        return null;
    }

    @Override
    public List<Professor> getAll() {
        return null;
    }
}
