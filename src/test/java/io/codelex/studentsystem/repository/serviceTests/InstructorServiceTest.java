package io.codelex.studentsystem.repository.serviceTests;

import io.codelex.studentsystem.api.Instructor;
import io.codelex.studentsystem.api.requests.AddInstructor;
import io.codelex.studentsystem.repository.model.InstructorRecord;
import io.codelex.studentsystem.repository.recordRepository.InstructorRecordRepository;
import io.codelex.studentsystem.repository.service.InstructorService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class InstructorServiceTest {
    private InstructorRecordRepository recordRepository = Mockito.mock(InstructorRecordRepository.class);
    private InstructorService service = new InstructorService(recordRepository);

    @Test
    void should_add_instructor() {
        //given
        AddInstructor request = setInstructor();
        Mockito.when(recordRepository.save(any())).thenAnswer((Answer) invocation -> invocation.getArguments()[0]);
        //when
        Instructor actual = service.addInstructor(request);
        //then
        assertEquals(request.getName(), (actual.getName()));
        assertEquals(request.getEmail(), (actual.getEmail()));
        assertEquals(request.getGithubLink(), (actual.getGithubLink()));
        assertEquals(request.getLinkedinLink(), (actual.getLinkedinLink()));
        assertEquals(request.getPhone(), (actual.getPhone()));
        assertTrue(request.isStatus());
    }

    @Test
    void should_be_able_to_save_instructor_and_find_by_id() {
        //given
        Mockito.when(recordRepository.findById(any())).thenReturn(Optional.empty());
        Mockito.when(recordRepository.save(any())).thenAnswer((Answer) invocation -> invocation.getArguments()[0]);
        //when
        Instructor instructor = service.addInstructor(setInstructor());
        //then
        assertEquals(setInstructor().getEmail(), instructor.getEmail());
        assertEquals(setInstructor().getName(), instructor.getName());
        assertEquals(setInstructor().getGithubLink(), instructor.getGithubLink());
        assertEquals(setInstructor().getLinkedinLink(), instructor.getLinkedinLink());
        assertEquals(setInstructor().getPhone(), instructor.getPhone());

    }

    @Test
    void should_find_instructor_by_id() {
        //given
        InstructorRecord record = new InstructorRecord();
        record.setName("Deniss");
        record.setEmail("deniss@codelex.io");
        record.setPhone("1561564");
        record.setGithubLink("glink");
        record.setLinkedinLink("llink");
        Optional<InstructorRecord> instructorRecord = Optional.of(record);
        Mockito.when(recordRepository.findById(1L)).thenReturn(instructorRecord);
        //when
        Instructor result = service.findInstructorById(1L);
        //then
        assertNotNull(result);
        assertEquals(result.getEmail(), record.getEmail());
        assertEquals(result.getName(), record.getName());
        assertEquals(result.getGithubLink(), record.getGithubLink());
        assertEquals(result.getLinkedinLink(), record.getLinkedinLink());
        assertEquals(result.getPhone(), record.getPhone());
    }

    AddInstructor setInstructor() {
        return new AddInstructor(
                "Sandris",
                "https://www.linkedin.com/in/sandr1s/",
                "https://github.com/sandris-",
                "12345678",
                "sandris.artemjevs@codelex.io",
                true);
    }
}