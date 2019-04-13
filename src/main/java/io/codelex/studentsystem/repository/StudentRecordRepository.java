package io.codelex.studentsystem.repository;

import io.codelex.studentsystem.repository.model.StudentRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRecordRepository extends JpaRepository<StudentRecord, Long> {

    @Query("select s from StudentRecord s where s.groupId = :groupsId")
    List<StudentRecord> findStudentsByGroupId(@Param("groupsId") long groupsId);

    @Query("select count (students) > 0 from StudentRecord students"
            + " where students.email = :email")
    boolean isStudentPresent(@Param("email") String email);
}
