package io.codelex.studentsystem.repository;

import io.codelex.studentsystem.api.Instructor;
import io.codelex.studentsystem.api.requests.AddInstructor;
import io.codelex.studentsystem.repository.recordRepository.InstructorRecordRepository;
import io.codelex.studentsystem.repository.service.InstructorService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class InstructorServiceTest {
    private InstructorRecordRepository recordRepository = Mockito.mock(InstructorRecordRepository.class);
    private InstructorService service = new InstructorService(recordRepository);

    @Test
    void should_add_instructor() {
        //given
        AddInstructor request = new AddInstructor(
                "Sandris",
                "https://www.linkedin.com/in/sandr1s/",
                "https://github.com/sandris-",
                "12345678",
                "sandris.artemjevs@codelex.io",
                true);

        Mockito.when(recordRepository.save(any())).thenAnswer((Answer) invocation -> invocation.getArguments()[0]);

        //when
        Instructor result = service.addInstructor(request);

        //then
        assertEquals(result.getName(), (request.getName()));
        assertEquals(result.getEmail(), (request.getEmail()));
        assertEquals(result.getGithubLink(), (request.getGithubLink()));
        assertEquals(result.getLinkedinLink(), (request.getLinkedinLink()));
        assertEquals(result.getPhone(), (request.getPhone()));
        assertTrue(result.isStatus());
    }
}