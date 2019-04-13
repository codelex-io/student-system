package io.codelex.studentsystem.service;

import io.codelex.studentsystem.api.Employer;
import io.codelex.studentsystem.api.Person;
import io.codelex.studentsystem.api.requests.AddEmployer;
import io.codelex.studentsystem.api.requests.SignIn;
import io.codelex.studentsystem.repository.EmployerRecordRepository;
import io.codelex.studentsystem.repository.PersonRecordRepository;
import io.codelex.studentsystem.repository.model.employer.PersonRecord;
import io.codelex.studentsystem.repository.model.maprecord.MapEmployerRecordToEmployer;
import io.codelex.studentsystem.repository.model.employer.EmployerRecord;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class EmployerService {
    private final EmployerRecordRepository employerRepository;
    private final PersonRecordRepository personRecordRepository;
    private MapEmployerRecordToEmployer mapEmployerRecordToEmployer = new MapEmployerRecordToEmployer();

    public EmployerService(EmployerRecordRepository employerRepository,
                           PersonRecordRepository personRecordRepository) {
        this.employerRepository = employerRepository;
        this.personRecordRepository = personRecordRepository;
    }

    public Employer addEmployer(AddEmployer request) {
        if (isEmployerPresent(request) || isLoginPresent(request)) {
            throw new IllegalStateException();
        }
        EmployerRecord employerRecord = new EmployerRecord();
        employerRecord.setCompany(request.getCompany());
        employerRecord.setName(request.getPerson().getName());
        employerRecord.setEmail(request.getPerson().getEmail());
        employerRecord.setPhone(request.getPerson().getPhone());
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
                request.getPerson().getEmail());
    }

    private PersonRecord createOrGetPerson(Person person) {
        return personRecordRepository.findById(person.getEmail())
                .orElseGet(() -> {
                    PersonRecord created = new PersonRecord(
                            person.getEmail(),
                            person.getName(),
                            person.getPhone()
                    );

                    return personRecordRepository.save(created);
                });
    }
}
