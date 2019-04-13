package io.codelex.studentsystem.service;

import io.codelex.studentsystem.api.Employer;
import io.codelex.studentsystem.api.requests.AddEmployer;
import io.codelex.studentsystem.api.requests.SignIn;
import io.codelex.studentsystem.repository.EmployerRecordRepository;
import io.codelex.studentsystem.repository.model.maprecord.MapEmployerRecordToEmployer;
import io.codelex.studentsystem.repository.model.EmployerRecord;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class EmployerService {
    private final EmployerRecordRepository employerRepository;
    private MapEmployerRecordToEmployer mapEmployerRecordToEmployer = new MapEmployerRecordToEmployer();

    public EmployerService(EmployerRecordRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    public Employer addEmployer(AddEmployer request) {
        if (isEmployerPresent(request) || isLoginPresent(request)) {
            throw new IllegalStateException();
        }
        EmployerRecord employerRecord = new EmployerRecord();
        employerRecord.setName(request.getName());
        employerRecord.setPersonName(request.getPersonName());
        employerRecord.setPersonEmail(request.getPersonEmail());
        employerRecord.setPersonPhone(request.getPersonPhone());
        employerRecord.setLogin(request.getLogin());
        employerRecord.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        //todo BCryptPasswordEncoder
        employerRecord = employerRepository.save(employerRecord);
        return mapEmployerRecordToEmployer.apply(employerRecord);
    }

    private boolean isLoginPresent(AddEmployer request) {
        return employerRepository.isLoginPresent(
                request.getLogin());
    }

    public Employer findEmployerById(long id) {
        return employerRepository
                .findById(id)
                .map(mapEmployerRecordToEmployer)
                .orElse(null);
    }

    public void deleteById(long id) {
        employerRepository.deleteById(id);
    }

    public boolean isSignInIsValid(SignIn request) {
        if (getPassword(request) != null) {
            return BCrypt.checkpw(request.getPassword(), getPassword(request));
        }
        return false;
    }

    private String getPassword(SignIn request) {
        return employerRepository.getPassword(
                request.getLogin()
        );
    }

    private boolean isEmployerPresent(AddEmployer request) {
        return employerRepository.isEmployerPresent(
                request.getPersonEmail());
    }
}
