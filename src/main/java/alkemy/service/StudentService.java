package alkemy.service;

import alkemy.domain.Student;


import java.util.List;

public interface StudentService {

    public List<Student> studentList();

    public void save(Student student);

    public void deleteStudent(Student student);

    public Student findStudent(Student student);
}
