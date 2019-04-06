package io.codelex.studentsystem;

import io.codelex.studentsystem.api.Employer;
import io.codelex.studentsystem.api.requests.AddEmployer;
import io.codelex.studentsystem.repository.service.EmployerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class EmployerController {
    private final EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PutMapping("/internal-api/employers")
    public Employer addEmployer(@RequestBody AddEmployer request) {
        return employerService.addEmployer(request);
    }

    @GetMapping("/internal-api/employers/{employerId}")
    public Employer findEmployerById(@PathVariable long employerId) {
        return employerService.findEmployerById(employerId);
    }

    @DeleteMapping("/internal-api/employers/{employeId}")
    public void deleteById(@PathVariable long employerId) {
        employerService.deleteById(employerId);
    }
}
