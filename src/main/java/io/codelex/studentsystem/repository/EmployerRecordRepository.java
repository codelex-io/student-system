package io.codelex.studentsystem.repository;

import io.codelex.studentsystem.repository.model.employer.EmployerRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployerRecordRepository extends JpaRepository<EmployerRecord, Long> {

    @Query("select count(employer) > 0 from EmployerRecord employer"
            + " where employer.email = :email")
    boolean isEmailPresent(@Param("email") String email);

    @Query("select count(employer) > 0 from EmployerRecord employer"
            + " where employer.login = :login")
    boolean isLoginPresent(@Param("login") String login);

    @Query("select employer.password from EmployerRecord employer"
            + " where employer.login = :login")
    String getPassword(@Param("login") String login);
}