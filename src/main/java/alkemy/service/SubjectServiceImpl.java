package alkemy.service;

import java.util.List;
import alkemy.dao.SubjectDao;
import alkemy.domain.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Subject> subjectList() {
        return (List<Subject>) subjectDao.findAll();
    }

    @Override
    @Transactional
    public void save(Subject subject) {
        subjectDao.save(subject);
    }

    @Override
    @Transactional
    public void deleteSubject(Subject subject) {
        subjectDao.delete(subject);
    }

    @Override
    @Transactional(readOnly = true)
    public Subject findSubject(Subject subject) {
        return subjectDao.findById(subject.getIdSubject()).orElse(null);
    }
}
