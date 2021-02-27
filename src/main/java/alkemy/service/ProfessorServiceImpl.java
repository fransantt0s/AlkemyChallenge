package alkemy.service;

import alkemy.dao.ProfessorDao;
import alkemy.domain.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorDao professorDao;

    @Override
    @Transactional(readOnly = true)
    public List<Professor> professorList() {
        return (List<Professor>) professorDao.findAll();
    }

    @Override
    @Transactional
    public void save(Professor professor) {
        professorDao.save(professor);

    }

    @Override
    @Transactional
    public void deleteProfessor(Professor professor) {
        professorDao.delete(professor);

    }

    @Override
    @Transactional(readOnly = true)
    public Professor findProfessor(Professor professor) {
        return professorDao.findById(professor.getIdProfessor()).orElse(null);
    }
}
