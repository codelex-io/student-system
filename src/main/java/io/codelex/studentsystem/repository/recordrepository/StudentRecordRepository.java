package io.codelex.studentsystem.repository.recordrepository;

import io.codelex.studentsystem.repository.model.StudentRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRecordRepository extends JpaRepository<StudentRecord, Long> {

    @Query("SELECT s FROM StudentRecord s WHERE s.groupId = :groupsId")
    List<StudentRecord> findStudentsByGroupId(@Param("groupsId") long groupsId);
}
