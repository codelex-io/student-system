package io.codelex.studentsystem;

import io.codelex.studentsystem.api.Student;
import io.codelex.studentsystem.api.requests.AddStudent;
import io.codelex.studentsystem.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PutMapping("/internal-api/students")
    public Student addNewStudent(@Valid @RequestBody AddStudent request) {
        return service.addStudent(request);
    }

    @GetMapping("/internal-api/students/{id}")
    public ResponseEntity<Student> findStudent(@PathVariable("id") Long id) {
        if (service.findStudentById(id) != null) {
            return new ResponseEntity<>(service.findStudentById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/internal-api/students/{studentsId}")
    public ResponseEntity<String> deleteById(@PathVariable long studentsId) {
        if (service.findStudentById(studentsId) != null) {
            service.deleteById(studentsId);
            return new ResponseEntity<>("Student deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(studentsId + " id already does not exist!", HttpStatus.BAD_REQUEST);
        }
    }

}
    