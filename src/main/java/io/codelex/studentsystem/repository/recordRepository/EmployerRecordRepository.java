package io.codelex.studentsystem.repository.recordRepository;

import io.codelex.studentsystem.repository.model.EmployerRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployerRecordRepository extends JpaRepository<EmployerRecord, Long> {
    
    @Query("select count(employer) > 0 from EmployerRecord employer "
            + "where employer.id = :id")
    boolean isEmployerIdPresent(@Param("id") Long id);
}
