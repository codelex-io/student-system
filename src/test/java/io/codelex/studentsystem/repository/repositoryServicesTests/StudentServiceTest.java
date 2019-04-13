package io.codelex.studentsystem.repository.repositoryServicesTests;

import io.codelex.studentsystem.api.Student;
import io.codelex.studentsystem.api.requests.AddStudent;
import io.codelex.studentsystem.repository.model.StudentRecord;
import io.codelex.studentsystem.repository.recordrepository.StudentRecordRepository;
import io.codelex.studentsystem.repository.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class StudentServiceTest {
    private StudentRecordRepository repository = Mockito.mock(StudentRecordRepository.class);
    private StudentService service = new StudentService(repository);

    @Test
    void should_add_student_all_fields_filled() {
        //given
        AddStudent request = setStudent();
        //when
        Mockito.when(repository.save(any())).thenAnswer((Answer) invocation -> invocation.getArguments()[0]);
        Student actual = service.addStudent(request);
        //then
        assertEquals(request.getName(), actual.getName());
        assertEquals(request.getDescription(), actual.getDescription());
        assertEquals(request.getEmail(), actual.getEmail());
        assertEquals(request.getGitHub(), actual.getGitHub());
        assertEquals(request.getImage(), actual.getImage());
        assertEquals(request.getLinkedIn(), actual.getLinkedIn());
        assertEquals(request.getStatus(), actual.getStatus());
        assertEquals(request.getTelephone(), actual.getTelephone());
    }

    @Test
    void should_be_able_to_save_student_and_find_by_id() {
        //given
        Mockito.when(repository.findById(any())).thenReturn(Optional.empty());
        Mockito.when(repository.save(any())).thenAnswer((Answer) invocation -> invocation.getArguments()[0]);
        //when
        Student student = service.addStudent(setStudent());
        //then
        assertEquals(setStudent().getEmail(), student.getEmail());
        assertEquals(setStudent().getName(), student.getName());
        assertEquals(setStudent().getDescription(), student.getDescription());
        assertEquals(setStudent().getGitHub(), student.getGitHub());
        assertEquals(setStudent().getImage(), student.getImage());
        assertEquals(setStudent().getLinkedIn(), student.getLinkedIn());
        assertEquals(setStudent().getStatus(), student.getStatus());
        assertEquals(setStudent().getTelephone(), student.getTelephone());
    }

    @Test
    void should_find_student_by_id() {
        //given
        StudentRecord record = new StudentRecord();
        record.setName("Deniss");
        record.setEmail("deniss@codelex.io");
        record.setDescription("very active");
        record.setGitHub("somegit");
        record.setImage("linktoimage");
        record.setStatus("sold");
        record.setTelephone("+2141124124");
        record.setLinkedIn("linkedlink");
        Optional<StudentRecord> studentRecord = Optional.of(record);
        Mockito.when(repository.findById(1L)).thenReturn(studentRecord);
        //when
        Student result = service.findStudentById(1L);
        //then
        assertNotNull(result);
        assertEquals(result.getEmail(), record.getEmail());
        assertEquals(result.getName(), record.getName());
        assertEquals(result.getDescription(), record.getDescription());
        assertEquals(result.getGitHub(), record.getGitHub());
        assertEquals(result.getImage(), record.getImage());
        assertEquals(result.getLinkedIn(), record.getLinkedIn());
        assertEquals(result.getTelephone(), record.getTelephone());
        assertEquals(result.getStatus(), record.getStatus());
    }

    AddStudent setStudent() {
        return new AddStudent(
                "Bob",
                "http://www.img.com",
                "linkedin.com",
                "github.com",
                "213131231",
                "janis@janis.lv",
                "bob is noob",
                "failed", 1L);
    }
}