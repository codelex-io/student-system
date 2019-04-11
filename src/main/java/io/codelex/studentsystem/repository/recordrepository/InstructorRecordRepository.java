package io.codelex.studentsystem.repository.recordrepository;

import io.codelex.studentsystem.repository.model.InstructorRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface InstructorRecordRepository extends JpaRepository<InstructorRecord, Long> {

    @Query("select i from Instructors i Join i.groups g Where g.groupId = :givenGroupId ")
    List<InstructorRecord> findAllInstructorsInThisGroup(@Param("givenGroupId") long givenGroupId);

    @Query("select count(instructors) > 0 from Instructors instructors"
            + " where instructors.name = :name"
            + " and instructors.linkedinLink = :linkedinLink"
            + " and instructors.githubLink = :githubLink"
            + " and instructors.phone = :phone"
            + " and instructors.email = :email"
            + " and instructors.status = :status")
    boolean isInstructorPresent(@Param("name") String name,
                                @Param("linkedinLink") String linkedinLink,
                                @Param("githubLink") String githubLink,
                                @Param("phone") String phone,
                                @Param("email") String email,
                                @Param("status") boolean status);
}
