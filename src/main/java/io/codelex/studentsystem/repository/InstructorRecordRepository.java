package io.codelex.studentsystem.repository;

import io.codelex.studentsystem.repository.model.InstructorRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InstructorRecordRepository extends JpaRepository<InstructorRecord, Long> {

    @Query("select i from Instructors i Join i.groups g Where g.groupId = :givenGroupId ")
    List<InstructorRecord> findAllInstructorsInThisGroup(@Param("givenGroupId") long givenGroupId);

    //todo choose one thing for uniqueness
    @Query("select count(instructor) > 0 from Instructors instructor"
            + " where instructor.name = :name"
            + " and instructor.linkedinLink = :linkedinLink"
            + " and instructor.githubLink = :githubLink"
            + " and instructor.phone = :phone"
            + " and instructor.email = :email")
    boolean isInstructorPresent(@Param("name") String name,
                                @Param("linkedinLink") String linkedinLink,
                                @Param("githubLink") String githubLink,
                                @Param("phone") String phone,
                                @Param("email") String email);
}
