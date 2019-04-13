package io.codelex.studentsystem.repository.recordrepository;

import io.codelex.studentsystem.repository.EmployerRecordRepository;
import io.codelex.studentsystem.repository.model.EmployerRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployerRecordRepositoryTests {
    @Autowired
    EmployerRecordRepository employerRecordRepository;

    @BeforeEach
    void setUp() {
        employerRecordRepository.deleteAll();
    }

    @Test
    void should_not_be_able_to_register_same_employer() {
        //given
        EmployerRecord repo = employerRecordRepository.save(createEmployer());
        //when
        boolean result = employerRecordRepository.isEmployerPresent(repo.getPersonEmail());
        //then
        assertTrue(result);
    }

    EmployerRecord createEmployer() {
        EmployerRecord employerRecord = new EmployerRecord();
        employerRecord.setPassword("password222");
        employerRecord.setPersonPhone("1224112741282");
        employerRecord.setLogin("login123");
        employerRecord.setPersonEmail("fwef@gmail.com");
        employerRecord.setPersonName("Bob");
        employerRecord.setName("Microsoft");
        return employerRecord;
    }

}
