package io.codelex.studentsystem;

import io.codelex.studentsystem.api.Student;
import io.codelex.studentsystem.api.requests.AddStudent;
import io.codelex.studentsystem.repository.service.StudentService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/api/students/{id}")
    public Student findStudent(@PathVariable("id") Long id) {
        return null;
    }
}
    