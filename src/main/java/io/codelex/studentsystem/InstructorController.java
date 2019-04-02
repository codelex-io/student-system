package io.codelex.studentsystem;

import io.codelex.studentsystem.api.Instructor;
import io.codelex.studentsystem.api.requests.AddInstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/internal-api")
public class InstructorController {
    private final StudentSystemService service;

    public InstructorController(StudentSystemService service) {
        this.service = service;
    }

    @PutMapping("/instructors")
    public Instructor addInstructor(@RequestBody AddInstructor request) {

        return service.addInstructor(request);
    }
}
