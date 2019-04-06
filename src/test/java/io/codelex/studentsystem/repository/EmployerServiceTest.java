package io.codelex.studentsystem.repository;

import io.codelex.studentsystem.api.Employer;
import io.codelex.studentsystem.api.requests.AddEmployer;
import io.codelex.studentsystem.repository.model.EmployerRecord;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

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
        //when
        Mockito.when(employerRecordRepository.save(any())).thenAnswer((Answer) invocation -> invocation.getArguments()[0]);
        Employer result = employerService.addEmployer(request);
        //then
        assertEquals(result.getName(), request.getName());
        assertEquals(result.getPersonName(), request.getPersonName());
        assertEquals(result.getPersonEmail(), request.getPersonEmail());
        assertEquals(result.getPersonPhone(), request.getPersonPhone());
        assertEquals(result.getPassword(), request.getPassword());
        assertEquals(result.getLogin(), request.getLogin());
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
        assertEquals(setEmployer().getPassword(), employer.getPassword());
        assertEquals(setEmployer().getPersonEmail(), employer.getPersonEmail());
        assertEquals(setEmployer().getPersonName(), employer.getPersonName());
        assertEquals(setEmployer().getPersonPhone(), employer.getPersonPhone());
    }

    @Test
    void should_find_employer_by_id() {
        EmployerRecord record = new EmployerRecord();
        record.setPassword("22231fggg");
        record.setPersonPhone("+37127837233");
        record.setLogin("JanisMicrosoft");
        record.setPersonEmail("janis8522@gmail.com");
        record.setPersonName("Janis");
        record.setName("Microsoft");
        Optional<EmployerRecord> employerRecord = Optional.of(record);
        Mockito.when(employerRecordRepository.findById(1L)).thenReturn(employerRecord);
        Employer result = employerService.findEmployerById(1L);
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
