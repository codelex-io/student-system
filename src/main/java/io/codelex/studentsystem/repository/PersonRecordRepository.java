package io.codelex.studentsystem.repository;

import io.codelex.studentsystem.repository.model.employer.PersonRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRecordRepository extends JpaRepository<PersonRecord, String> {
}
