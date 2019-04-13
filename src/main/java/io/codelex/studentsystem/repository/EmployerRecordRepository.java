package io.codelex.studentsystem.repository; //todo package

import io.codelex.studentsystem.repository.model.EmployerRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployerRecordRepository extends JpaRepository<EmployerRecord, Long> {

    //todo
    @Query("select count(employer) > 0 from EmployerRecord employer"
            + " where employer.login = :login"
            + " and employer.name = :name"
            + " and employer.personEmail = :personEmail"
            + " and employer.personName = :personName"
            + " and employer.personPhone = :personPhone")
    boolean isEmployerPresent(@Param("personEmail") String personEmail,
                              @Param("login") String login,
                              @Param("name") String name,
                              @Param("personName") String personName,
                              @Param("personPhone") String personPhone);

    @Query("select count(employer) > 0 from EmployerRecord employer"
            + " where employer.login = :login")
    boolean isLoginPresent(@Param("login") String login);

    @Query("select employer.password from EmployerRecord employer"
            + " where employer.login = :login")
    String getPassword(@Param("login") String login);
}