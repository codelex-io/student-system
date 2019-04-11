package io.codelex.studentsystem.repository.recordrepository;

import io.codelex.studentsystem.repository.model.StudentRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRecordRepository extends JpaRepository<StudentRecord, Long> {
    
}
