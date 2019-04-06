package io.codelex.studentsystem.repository.service;

import io.codelex.studentsystem.api.Employer;
import io.codelex.studentsystem.api.requests.AddEmployer;
import io.codelex.studentsystem.repository.recordRepository.EmployerRecordRepository;
import io.codelex.studentsystem.repository.mapRecord.MapEmployerRecordToEmployer;
import io.codelex.studentsystem.repository.model.EmployerRecord;
import org.springframework.stereotype.Component;

@Component
public class EmployerService {
    private final EmployerRecordRepository employerRepository;
    private MapEmployerRecordToEmployer mapEmployerRecordToEmployer = new MapEmployerRecordToEmployer();

    public EmployerService(EmployerRecordRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    public Employer addEmployer(AddEmployer request) {
        EmployerRecord employerRecord = new EmployerRecord();
        employerRecord.setName(request.getName());
        employerRecord.setPersonName(request.getPersonName());
        employerRecord.setPersonEmail(request.getPersonEmail());
        employerRecord.setPersonPhone(request.getPersonPhone());
        employerRecord.setLogin(request.getLogin());
        employerRecord.setPassword(request.getPassword());
        return mapEmployerRecordToEmployer.apply(employerRecord);
    }

    public void clear() {
        employerRepository.deleteAll();
    }

    public Employer findEmployerById(long id) {
        return employerRepository
                .findById(id)
                .map(mapEmployerRecordToEmployer)
                .orElse(null);
    }
}
