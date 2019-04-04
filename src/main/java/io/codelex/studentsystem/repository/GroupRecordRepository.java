package io.codelex.studentsystem.repository;

import io.codelex.studentsystem.repository.model.GroupRecord;
import io.codelex.studentsystem.repository.model.InstructorRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupRecordRepository extends JpaRepository<GroupRecord, Long> {
                                                  
   

}
