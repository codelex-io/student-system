package io.codelex.studentsystem.repository.model.maprecord;

import io.codelex.studentsystem.api.Employer;
import io.codelex.studentsystem.api.Person;
import io.codelex.studentsystem.repository.model.employer.EmployerRecord;

import java.util.function.Function;

public class MapEmployerRecordToEmployer implements Function<EmployerRecord, Employer> {
    @Override
    public Employer apply(EmployerRecord employerRecord) {
        return new Employer(
                employerRecord.getId(),
                employerRecord.getCompany(),
                new Person(employerRecord.getName(),
                        employerRecord.getEmail(),
                        employerRecord.getPhone()),
                employerRecord.getPassword(),
                employerRecord.getLogin());
    }
}
