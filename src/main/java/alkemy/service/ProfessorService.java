package alkemy.service;

import alkemy.domain.Professor;

import java.util.List;

public interface ProfessorService {
    public List<Professor> professorList();

    public void save(Professor professor);

    public void deleteProfessor(Professor professor);

    public Professor findProfessor(Professor professor);
}
