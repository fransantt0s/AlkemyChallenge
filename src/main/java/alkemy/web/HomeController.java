package alkemy.web;

import javax.validation.Valid;

import alkemy.domain.Professor;
import alkemy.domain.Student;
import alkemy.domain.Subject;
import alkemy.service.ProfessorService;
import alkemy.service.StudentService;
import alkemy.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class HomeController {
    
    @Autowired
    private SubjectService subjectService;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String home (Model model, @AuthenticationPrincipal User user){
        var subjects = subjectService.subjectList();
        log.info("executing Spring MVC");
        log.info("user Logged : " + user);
        model.addAttribute("subjects", subjects);
        return "index";
    }
    @GetMapping("/professorsPage")
    public String professors (Model model,@AuthenticationPrincipal User user){
        var professors = professorService.professorList();
        model.addAttribute("professors",professors);
        return "professorsPage";
    }

    @GetMapping("/subjectPage")
    public String students (Model model,@AuthenticationPrincipal User user){
        var students = studentService.studentList();
        model.addAttribute("students",students);
        return "subjectPage";
    }

    
    @GetMapping("/add")
    public String addSubject(Subject subject){
        return "edit";
    }

    @GetMapping("/addProfessor")
    public String addProfessor(Subject professor){
        return "editProfessorPage";
    }

    @GetMapping ("/addStudent")
    public String addStudent(Student student){
        return "subjectPage";
    }

    @PostMapping("/save")
    public String saveSubject(@Valid Subject subject, Errors errors){
        if(errors.hasErrors()){
            return "edit";
        }
        subjectService.save(subject);
        return "redirect:/";
    }

    @PostMapping("/saveProfessor")
    public String saveProfessor(@Valid Professor professor, Errors errors){
        if(errors.hasErrors()){
            return "editProfessorPage";
        }
        professorService.save(professor);
        return "redirect:/professorsPage";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@Valid Student student,Errors errors){
        if(errors.hasErrors()){
            return"editStudentPage";
        }
        studentService.save(student);
        return "redirect:/subjectPage";

    }

    
    @GetMapping("/edit/{idSubject}")
    public String editSubject(Subject subject, Model model){
        subject = subjectService.findSubject(subject);
        model.addAttribute("subject", subject);
        return "edit";
    }

    @GetMapping("/editProfessor/{idProfessor}")
    public String editProfessor(Professor professor, Model model){
        professor = professorService.findProfessor(professor);
        model.addAttribute("professor", professor);
        return "editProfessorPage";
    }

    @GetMapping("/editStudent/{idStudent}")
    public String editStudent(Student student, Model model){
        student = studentService.findStudent(student);
        model.addAttribute("student", student);
        return "editStudentPage";
    }

    
    @GetMapping("/delete")
    public String deleteSubject(Subject subject){
        subjectService.deleteSubject(subject);
        return "redirect:/";
    }


    @GetMapping("/deleteProfessor")
    public String deleteProfessor(Professor professor){
        professorService.deleteProfessor(professor);
        return "redirect:/professorsPage";
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(Student student){
        studentService.deleteStudent(student);
        return "redirect:/subjectPage";
    }




}
