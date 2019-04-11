package io.codelex.studentsystem.repository.service;

import io.codelex.studentsystem.EmployerServiceInterface;
import io.codelex.studentsystem.api.Employer;
import io.codelex.studentsystem.api.requests.AddEmployer;
import io.codelex.studentsystem.repository.recordrepository.EmployerRecordRepository;
import io.codelex.studentsystem.repository.model.maprecord.MapEmployerRecordToEmployer;
import io.codelex.studentsystem.repository.model.EmployerRecord;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "student-system", name = "store-type", havingValue = "database")
public class EmployerService implements EmployerServiceInterface {
    private final EmployerRecordRepository employerRepository;
    private MapEmployerRecordToEmployer mapEmployerRecordToEmployer = new MapEmployerRecordToEmployer();

    public EmployerService(EmployerRecordRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    public Employer addEmployer(AddEmployer request) {
        if (isEmployerPresent(request)) {
            throw new IllegalStateException();
        }
        EmployerRecord employerRecord = new EmployerRecord();
        employerRecord.setName(request.getName());
        employerRecord.setPersonName(request.getPersonName());
        employerRecord.setPersonEmail(request.getPersonEmail());
        employerRecord.setPersonPhone(request.getPersonPhone());
        employerRecord.setLogin(request.getLogin());
        employerRecord.setPassword(request.getPassword());
        employerRecord = employerRepository.save(employerRecord);
        return mapEmployerRecordToEmployer.apply(employerRecord);
    }
    @Override
    public boolean isEmployerPresent(AddEmployer request) {
        return employerRepository.isEmployerPresent(
                request.getPersonEmail(),
                request.getLogin(),
                request.getName(),
                request.getPersonName(),
                request.getPassword(),
                request.getPersonPhone());
    }

    @Override
    public Employer findEmployerById(long id) {
        return employerRepository
                .findById(id)
                .map(mapEmployerRecordToEmployer)
                .orElse(null);
    }

    @Override
    public void deleteById(long id) {
        employerRepository.deleteById(id);
    }
}
