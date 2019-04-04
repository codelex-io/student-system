package io.codelex.studentsystem.repository;

import io.codelex.studentsystem.repository.model.InstructorRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface InstructorRecordRepository extends JpaRepository<InstructorRecord, Long> {

    /*@Query("SELECT i.name FROM instructors as i" +
            "INNER JOIN instructors_with_groups as ig ON i.instructorId = ig.instructor_id" +
            "INNER JOIN groups as g ON g.groupId = ig.group_id WHERE g.groupId = theGroupsId")
    List<InstructorRecord> findAllInstructorsByGroupId2(@Param("theGroupsId") long theGroupsId);*/
    
}
