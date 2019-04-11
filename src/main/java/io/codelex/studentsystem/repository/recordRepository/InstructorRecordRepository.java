package io.codelex.studentsystem.repository.recordRepository;

import io.codelex.studentsystem.repository.model.InstructorRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InstructorRecordRepository extends JpaRepository<InstructorRecord, Long> {

    @Query("select i from Instructors i Join i.groups g Where g.groupId = :givenGroupId ")
    List<InstructorRecord> findAllInstructorsInThisGroup(@Param("givenGroupId") long givenGroupId);

}