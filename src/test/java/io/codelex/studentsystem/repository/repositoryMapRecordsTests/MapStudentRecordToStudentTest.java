package io.codelex.studentsystem.repository.repositoryMapRecordsTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import io.codelex.studentsystem.api.Student;
import io.codelex.studentsystem.repository.model.maprecord.MapStudentRecordToStudent;
import io.codelex.studentsystem.repository.model.StudentRecord;

public class MapStudentRecordToStudentTest {
    private MapStudentRecordToStudent mapStudentRecordToStudent = new MapStudentRecordToStudent();

    @Test
    void apply() {
        //given
        StudentRecord record = new StudentRecord();
        record.setLinkedIn("linkedin");
        record.setDescription("very active");
        record.setTelephone("+2345555223");
        record.setStatus("Sold");
        record.setGitHub("github");
        record.setEmail("fefej@gmail.com");
        record.setImage("wqdjIMAGE");
        record.setStudentId(1L);

        //when
        Student student = mapStudentRecordToStudent.apply(record);
        //then
        Assertions.assertEquals(student.getId(), 1L);
        Assertions.assertEquals(student.getStatus(), "Sold");
        Assertions.assertEquals(student.getTelephone(), "+2345555223");
        Assertions.assertEquals(student.getLinkedIn(), "linkedin");
        Assertions.assertEquals(student.getEmail(), "fefej@gmail.com");
        Assertions.assertEquals(student.getGitHub(), "github");
        Assertions.assertEquals(student.getImage(), "wqdjIMAGE");
        Assertions.assertEquals(student.getDescription(), "very active");
    }
}
