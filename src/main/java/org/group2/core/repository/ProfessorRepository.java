package org.group2.core.repository;


import org.group2.core.model.Professor;

import java.util.List;

public interface ProfessorRepository {
    void save(Professor professor);
    void delete(Long id);
    void update(Professor professor, Long id);
    Professor getById(int id);
    List<Professor> getAll();
}
