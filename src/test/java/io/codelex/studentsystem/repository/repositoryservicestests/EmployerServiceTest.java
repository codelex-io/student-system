package io.codelex.studentsystem.repository.repositoryservicestests;

import io.codelex.studentsystem.api.Employer;
import io.codelex.studentsystem.api.Person;
import io.codelex.studentsystem.api.requests.AddEmployer;
import io.codelex.studentsystem.repository.model.employer.EmployerRecord;
import io.codelex.studentsystem.repository.EmployerRecordRepository;
import io.codelex.studentsystem.service.EmployerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class EmployerServiceTest {
    private EmployerRecordRepository employerRecordRepository = Mockito.mock(EmployerRecordRepository.class);
    private EmployerService employerService = new EmployerService(employerRecordRepository);

    @Test
    void should_be_able_to_add_employer() {
        //given
        AddEmployer request = setEmployer();
        Mockito.when(employerRecordRepository.save(any())).thenAnswer((Answer) invocation -> invocation.getArguments()[0]);
        //when
        Employer actual = employerService.addEmployer(request);
        //then
        assertEquals(request.getCompany(), actual.getCompany());
        assertEquals(request.getPerson().getName(), actual.getPerson().getName());
        assertEquals(request.getPerson().getEmail(), actual.getPerson().getEmail());
        assertEquals(request.getPerson().getPhone(), actual.getPerson().getPhone());
        assertTrue(BCrypt.checkpw(request.getPassword(), actual.getPassword()));
        assertEquals(request.getLogin(), actual.getLogin());
    }

    @Test
    void should_be_able_to_save_employer_and_find_by_id() {
        //given
        Mockito.when(employerRecordRepository.findById(any())).thenReturn(Optional.empty());
        Mockito.when(employerRecordRepository.save(any())).thenAnswer((Answer) invocation -> invocation.getArguments()[0]);
        //when
        Employer employer = employerService.addEmployer(setEmployer());
        //then
        assertEquals(setEmployer().getLogin(), employer.getLogin());
        assertEquals(setEmployer().getCompany(), employer.getCompany());
        assertTrue(BCrypt.checkpw(setEmployer().getPassword(), employer.getPassword()));
        assertEquals(setEmployer().getPerson().getEmail(), employer.getPerson().getEmail());
        assertEquals(setEmployer().getPerson().getName(), employer.getPerson().getName());
        assertEquals(setEmployer().getPerson().getPhone(), employer.getPerson().getPhone());
    }

    @Test
    void should_find_employer_by_id() {
        //given
        EmployerRecord record = new EmployerRecord();
        record.setPassword("22231fggg");
        record.setPhone("+37127837233");
        record.setLogin("JanisMicrosoft");
        record.setEmail("janis8522@gmail.com");
        record.setName("Janis");
        record.setName("Microsoft");
        Optional<EmployerRecord> employerRecord = Optional.of(record);
        Mockito.when(employerRecordRepository.findById(1L)).thenReturn(employerRecord);
        //when
        Employer result = employerService.findEmployerById(1L);
        //then
        assertNotNull(result);
        assertEquals(result.getPerson().getEmail(), record.getEmail());
    }

    AddEmployer setEmployer() {
        return new AddEmployer("Big Company",
                new Person("Bobs",
                        "bob@gmail.com",
                        "+35122424"),
                "parole23",
                "login22"
        );
    }
}
