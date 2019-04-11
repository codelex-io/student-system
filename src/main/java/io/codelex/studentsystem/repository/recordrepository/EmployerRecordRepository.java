package io.codelex.studentsystem.repository.recordrepository;

import io.codelex.studentsystem.repository.model.EmployerRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployerRecordRepository extends JpaRepository<EmployerRecord, Long> {

    @Query("select count(employer) > 0 from EmployerRecord employer"
            + " where employer.login = :login"
            + " and employer.name = :name"
            + " and employer.password = :password"
            + " and employer.personEmail = :personEmail"
            + " and employer.personName = :personName"
            + " and employer.personPhone = :personPhone")
    boolean isEmployerPresent(@Param("personEmail") String personEmail,
                              @Param("login") String login,
                              @Param("name") String name,
                              @Param("personName") String personName,
                              @Param("password") String password,
                              @Param("personPhone") String personPhone);

    @Query("select count(employer) > 0 from EmployerRecord employer"
            + " where employer.login = :login")
    boolean isLoginPresent(@Param("login") String login);

    @Query("select count(employer) > 0 from EmployerRecord employer"
            + " where employer.login = :login"
            + " and employer.password = :password")
    boolean isSignInIsValid(@Param("login") String login,
                            @Param("password") String password);
}