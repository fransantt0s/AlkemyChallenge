package alkemy.dao;

import alkemy.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectDao extends JpaRepository<Subject, Long>{
    
}
