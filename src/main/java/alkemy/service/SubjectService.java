package alkemy.service;

import java.util.List;

import alkemy.domain.Subject;

public interface SubjectService {


    
    public List<Subject> subjectList();
    
    public void save(Subject subject);
    
    public void deleteSubject(Subject subject);
    
    public Subject findSubject(Subject subject);
}
