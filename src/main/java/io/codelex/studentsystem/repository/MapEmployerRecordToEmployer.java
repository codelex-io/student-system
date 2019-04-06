package io.codelex.studentsystem.repository;

import io.codelex.studentsystem.api.Employer;
import io.codelex.studentsystem.repository.model.EmployerRecord;

import java.util.function.Function;

public class MapEmployerRecordToEmployer implements Function<EmployerRecord, Employer> {
    @Override
    public Employer apply(EmployerRecord employerRecord) {
        return new Employer(
                employerRecord.getId(),
                employerRecord.getName(),
                employerRecord.getPersonName(),
                employerRecord.getPersonPhone(),
                employerRecord.getPersonEmail(),
                employerRecord.getPassword(),
                employerRecord.getLogin()
        );
    }
}
