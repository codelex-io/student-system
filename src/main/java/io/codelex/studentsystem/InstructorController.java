package io.codelex.studentsystem;

import io.codelex.studentsystem.api.requests.AddInstructor;
import io.codelex.studentsystem.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class InstructorController {
    private final InstructorService service;

    public InstructorController(InstructorService service) {
        this.service = service;
    }

    @PutMapping("/internal-api/instructors")
    public ResponseEntity<?> addInstructor(@Valid @RequestBody AddInstructor request) {
        try {
            return new ResponseEntity<>(service.addInstructor(request), HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>("Instructor with this email already exists!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/internal-api/instructors/{id}")
    public ResponseEntity<?> findInstructorByID(@PathVariable long id) {
        if (service.findInstructorById(id) != null) {
            return new ResponseEntity<>(service.findInstructorById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Such id does not exist", HttpStatus.BAD_REQUEST);
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
