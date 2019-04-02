package io.codelex.studentsystem;

import io.codelex.studentsystem.api.Student;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class StudentController {

    @PutMapping("/internal-api/students")
    public Student addNewStudent() {
        return null;
    }

    @GetMapping("/api/students/{id}")
    public Student findStudent(@PathVariable("id") Long id) {
        return null;
    }
}
