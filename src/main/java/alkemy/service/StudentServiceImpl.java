package alkemy.service;

import alkemy.dao.StudentDao;
import alkemy.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentDao studentDao;

    @Override
    @Transactional(readOnly = true)
    public List<Student> studentList() {
        return (List<Student>) studentDao.findAll();
    }

    @Override
    @Transactional
    public void save(Student student) {
        studentDao.save(student);

    }

    @Override
    @Transactional
    public void deleteStudent(Student student) {
        studentDao.delete(student);

    }

    @Override
    @Transactional(readOnly = true)
    public Student findStudent(Student student) {
        return studentDao.findById(student.getIdStudent()).orElse(null);
    }
}
