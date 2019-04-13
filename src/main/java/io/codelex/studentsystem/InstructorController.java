package io.codelex.studentsystem;

import io.codelex.studentsystem.api.Instructor;
import io.codelex.studentsystem.api.requests.AddInstructor;
import io.codelex.studentsystem.repository.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
public class InstructorController {
    private final InstructorService service;

    public InstructorController(InstructorService service) {
        this.service = service;
    }

    @PutMapping("/internal-api/instructors")
    public ResponseEntity<Instructor> addInstructor(@Valid @RequestBody AddInstructor request) {
        try {
            service.addInstructor(request);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/internal-api/instructors/{id}")
    public ResponseEntity<Instructor> findInstructorByID(@PathVariable long id) {
        if (service.findInstructorById(id) != null) {
            return new ResponseEntity<>(service.findInstructorById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/internal-api/instructors/{instructorsId}")
    public ResponseEntity<String> deleteById(@PathVariable long instructorsId) {
        if (service.findInstructorById(instructorsId) != null) {
            service.deleteById(instructorsId);
            return new ResponseEntity<>("Instructor deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(instructorsId + " id already does not exist!", HttpStatus.BAD_REQUEST);
        }
    }

}
