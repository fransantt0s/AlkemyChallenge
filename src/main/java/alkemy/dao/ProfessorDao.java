package alkemy.dao;

import alkemy.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorDao extends JpaRepository<Professor,Long> {
}
