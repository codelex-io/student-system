package io.codelex.studentsystem.repository.recordRepository;

import io.codelex.studentsystem.repository.model.EmployerRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRecordRepository extends JpaRepository<EmployerRecord, Long> {
}
