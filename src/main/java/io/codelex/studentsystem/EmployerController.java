package io.codelex.studentsystem;


import io.codelex.studentsystem.api.Employer;
import io.codelex.studentsystem.api.requests.AddEmployer;
import io.codelex.studentsystem.repository.recordrepository.EmployerRecordRepository;
import io.codelex.studentsystem.repository.service.EmployerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
public class EmployerController {
    private final EmployerService employerService;
    private EmployerRecordRepository repository;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PutMapping("/internal-api/employers")
    public ResponseEntity<Employer> addEmployer(@Valid @RequestBody AddEmployer request) {
        try {
            employerService.addEmployer(request);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/internal-api/employers/{employerId}")
    public ResponseEntity<Employer> findEmployerById(@PathVariable long employerId) {
        if (employerService.findEmployerById(employerId) != null) {
            return new ResponseEntity<>(employerService.findEmployerById(employerId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
