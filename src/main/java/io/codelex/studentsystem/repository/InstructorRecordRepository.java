package io.codelex.studentsystem.repository;

import io.codelex.studentsystem.repository.model.InstructorRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRecordRepository extends JpaRepository<InstructorRecord, Long> {

}
