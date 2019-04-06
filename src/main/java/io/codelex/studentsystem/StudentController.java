package io.codelex.studentsystem;

import io.codelex.studentsystem.api.Student;
import io.codelex.studentsystem.api.requests.AddStudent;
import io.codelex.studentsystem.repository.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PutMapping("/internal-api/students")
    public Student addNewStudent(@RequestBody AddStudent request) {
        return service.addStudent(request);
    }

    @GetMapping("/internal-api/students/{id}")
    public Student findStudent(@PathVariable("id") Long id) {
        return service.findStudentById(id);
    }

    @DeleteMapping("/internal-api/students/{studentsId}")
    public void deleteById(@PathVariable long studentsId) {
        service.deleteById(studentsId);
    }

    @GetMapping("/internal-api/students")
    public List<Student> showAllGroups() {
        return service.findAllStudents();
    }
}
    