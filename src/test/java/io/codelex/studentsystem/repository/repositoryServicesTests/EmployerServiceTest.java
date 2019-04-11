package io.codelex.studentsystem.repository.repositoryServicesTests;

import io.codelex.studentsystem.api.Employer;
import io.codelex.studentsystem.api.requests.AddEmployer;
import io.codelex.studentsystem.repository.model.EmployerRecord;
import io.codelex.studentsystem.repository.recordrepository.EmployerRecordRepository;
import io.codelex.studentsystem.repository.service.EmployerService;
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
        assertEquals(request.getName(), actual.getName());
        assertEquals(request.getPersonName(), actual.getPersonName());
        assertEquals(request.getPersonEmail(), actual.getPersonEmail());
        assertEquals(request.getPersonPhone(), actual.getPersonPhone());
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
        assertEquals(setEmployer().getName(), employer.getName());
        assertTrue(BCrypt.checkpw(setEmployer().getPassword(), employer.getPassword()));
        assertEquals(setEmployer().getPersonEmail(), employer.getPersonEmail());
        assertEquals(setEmployer().getPersonName(), employer.getPersonName());
        assertEquals(setEmployer().getPersonPhone(), employer.getPersonPhone());
    }

    @Test
    void should_find_employer_by_id() {
        //given
        EmployerRecord record = new EmployerRecord();
        record.setPassword("22231fggg");
        record.setPersonPhone("+37127837233");
        record.setLogin("JanisMicrosoft");
        record.setPersonEmail("janis8522@gmail.com");
        record.setPersonName("Janis");
        record.setName("Microsoft");
        Optional<EmployerRecord> employerRecord = Optional.of(record);
        Mockito.when(employerRecordRepository.findById(1L)).thenReturn(employerRecord);
        //when
        Employer result = employerService.findEmployerById(1L);
        //then
        assertNotNull(result);
        assertEquals(result.getPersonEmail(), record.getPersonEmail());
    }

    AddEmployer setEmployer() {
        return new AddEmployer(
                "Microsoft",
                "Janis",
                "+37127837233",
                "janis222218522@gmail.com",
                "22231fggg",
                "JanisMicrosoft");
    }
}
