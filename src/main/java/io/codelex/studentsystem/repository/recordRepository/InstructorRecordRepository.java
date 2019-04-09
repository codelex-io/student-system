package io.codelex.studentsystem.repository.recordRepository;

import io.codelex.studentsystem.repository.model.InstructorRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InstructorRecordRepository extends JpaRepository<InstructorRecord, Long> {

    @Query("select instructor from Instructors instructor")
    List<InstructorRecord> findAllInstructorsInThisGroup(@Param("group_id") long givenGroupId);

}
