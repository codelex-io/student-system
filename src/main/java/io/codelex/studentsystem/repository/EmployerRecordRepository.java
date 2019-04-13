package io.codelex.studentsystem.repository;

import io.codelex.studentsystem.repository.model.EmployerRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployerRecordRepository extends JpaRepository<EmployerRecord, Long> {

    @Query("select count(employer) > 0 from EmployerRecord employer"
            + " where employer.personEmail = :personEmail")
    boolean isEmployerPresent(@Param("personEmail") String personEmail);

    @Query("select count(employer) > 0 from EmployerRecord employer"
            + " where employer.login = :login")
    boolean isLoginPresent(@Param("login") String login);

    @Query("select employer.password from EmployerRecord employer"
            + " where employer.login = :login")
    String getPassword(@Param("login") String login);
}