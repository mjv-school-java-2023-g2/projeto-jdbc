package org.group2;

import org.group2.core.model.Professor;
import org.group2.core.repository.ProfessorRepository;
import org.group2.infra.ConnectionFactory;
import org.group2.infra.ExecuteSQLfile;
import org.group2.infra.PostgresCrud;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        ConnectionFactory.startConnection();

        ExecuteSQLfile.executeSqlFile("src/main/resources/SQL/tabela.sql");

        ProfessorRepository professorRepository = new PostgresCrud();

        Professor professor = new Professor(
                1,
                "Maria",
                LocalDate.of(1990, 1,1),
                LocalTime.of(8, 40),
                BigDecimal.valueOf(55.00),
                false,
                5,
                "Prof de Geografia",
                LocalDateTime.now()
        );

        professorRepository.save(professor);

        System.out.println(professorRepository.getById(1));

        professorRepository.getAll().forEach(System.out::println);

        professor.setNome("Maria Maria");

        professorRepository.update(professor);

        System.out.println(professorRepository.getById(1));

        professorRepository.delete(1);

        System.out.println(professorRepository.getById(1));
    }
}