package io.codelex.studentsystem;

import io.codelex.studentsystem.api.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

public class StudentController {

    @PutMapping("/students/{id}")
    public Student addNewStudent() {
        return null;
    }

    @GetMapping("/students/{id}")
    public Student findStudent() {
        return null;
    }
}
