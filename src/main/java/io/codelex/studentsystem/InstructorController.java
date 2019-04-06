package io.codelex.studentsystem;

import io.codelex.studentsystem.api.Instructor;
import io.codelex.studentsystem.api.requests.AddInstructor;
import io.codelex.studentsystem.repository.service.InstructorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class InstructorController {
    private final InstructorService service;

    public InstructorController(InstructorService service) {
        this.service = service;
    }

    @PutMapping("/internal-api/instructors")
    public Instructor addInstructor(@RequestBody AddInstructor request) {

        return service.addInstructor(request);
    }

    @GetMapping("/api/instructors/{id}")
    public Instructor findInstructorByID(@PathVariable long id) {

        return service.findInstructorById(id);
    }
}
