package io.codelex.studentsystem.inMemory;

import io.codelex.studentsystem.api.Instructor;
import io.codelex.studentsystem.api.requests.AddInstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryStudentSystemServiceTest {
    private InMemoryStudentSystemService service = new InMemoryStudentSystemService();

    @BeforeEach
    void setUp() {
        service.clear();
    }

    @Test
    void should_add_instructor() {
        //given
        AddInstructor request = new AddInstructor("Sandris",
                "https://www.linkedin.com/in/sandr1s/",
                "https://github.com/sandris-",
                "12345678",
                "sandris.artemjevs@codelex.io",
                true);

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

    @Test
    void should_increment_id() {
        //given
        AddInstructor request = new AddInstructor("Sandris",
                "https://www.linkedin.com/in/sandr1s/",
                "https://github.com/sandris-",
                "12345678",
                "sandris.artemjevs@codelex.io",
                true);
        AddInstructor request2 = new AddInstructor("Denis",
                "https://www.linkedin.com/in/denis-viktorov-b1444b57/",
                "https://github.com/denis",
                "87654321",
                "denis@codelex.io",
                true);
        //when
        Instructor result1 = service.addInstructor(request);
        Instructor result2 = service.addInstructor(request2);

        //then
        assertEquals(result1.getId() + 1, result2.getId());
    }
}