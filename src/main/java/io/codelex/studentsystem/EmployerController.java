package io.codelex.studentsystem;

import io.codelex.studentsystem.api.requests.AddEmployer;
import io.codelex.studentsystem.service.EmployerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class EmployerController {
    private final EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PutMapping("/internal-api/employers")
    public ResponseEntity<?> addEmployer(@Valid @RequestBody AddEmployer request) {
        try {
            return new ResponseEntity<>(employerService.addEmployer(request), HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>("Employer with this email already exists!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/internal-api/employers/{employerId}")
    public ResponseEntity<?> findEmployerById(@PathVariable long employerId) {
        if (employerService.findEmployerById(employerId) != null) {
            return new ResponseEntity<>(employerService.findEmployerById(employerId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Such id does not exist", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/internal-api/employers/{employerId}")
    public ResponseEntity<String> deleteById(@PathVariable long employerId) {
        if (employerService.findEmployerById(employerId) != null) {
            employerService.deleteById(employerId);
            return new ResponseEntity<>(employerId + " Id was deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Such id does not exist", HttpStatus.BAD_REQUEST);
        }
    }
}
