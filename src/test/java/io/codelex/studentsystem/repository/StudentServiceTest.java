package io.codelex.studentsystem.repository;

import io.codelex.studentsystem.api.Student;
import io.codelex.studentsystem.api.requests.AddStudent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import static org.mockito.ArgumentMatchers.any;

class StudentServiceTest {
    private StudentRecordRepository repository = Mockito.mock(StudentRecordRepository.class);
    private StudentService service = new StudentService(repository);
    
    @Test
    void should_add_student_all_fields_filled(){
        //given
        AddStudent request = new AddStudent(
                "Bob",
                "http://www.img.com",
                "linkedin.com",
                "github.com",
                "213131231",
                "janis@janis.lv",
                "bob is noob",
                "failed");
        //when
        Mockito.when(repository.save(any())).thenAnswer((Answer) invocation -> invocation.getArguments()[0]);
        Student student = service.addStudent(request);
        //then
        Assertions.assertEquals(request.getName(), student.getName());
        Assertions.assertEquals(request.getDescription(),student.getDescription());
        Assertions.assertEquals(request.getEmail(),student.getEmail());
        Assertions.assertEquals(request.getGitHub(),student.getGitHub());
        Assertions.assertEquals(request.getImage(),student.getImage());
        Assertions.assertEquals(request.getLinkedIn(),student.getLinkedIn());
        Assertions.assertEquals(request.getStatus(),student.getStatus());
        Assertions.assertEquals(request.getTelephone(),student.getTelephone());
    }
    
    @Test
    void should_not_add_student_if_all_fields_not_field(){
        //given

        //when

        //then
        
    }
}