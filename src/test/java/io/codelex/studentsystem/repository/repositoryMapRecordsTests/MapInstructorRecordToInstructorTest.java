package io.codelex.studentsystem.repository.repositoryMapRecordsTests;

import io.codelex.studentsystem.api.Instructor;
import io.codelex.studentsystem.repository.model.maprecord.MapInstructorRecordToInstructor;
import io.codelex.studentsystem.repository.model.InstructorRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MapInstructorRecordToInstructorTest {
    private MapInstructorRecordToInstructor toInstructor = new MapInstructorRecordToInstructor();

    @Test
    void apply() {
        //given
        InstructorRecord record = new InstructorRecord();
        record.setInstructorId(1L);
        record.setName("Janis");
        record.setPhone("123");
        record.setLinkedinLink("link");
        record.setGithubLink("git");
        record.setEmail("e-mail");
        //when
        Instructor testInstructor = toInstructor.apply(record);
        //then
        Assertions.assertEquals(testInstructor.getId(), 1L);
        Assertions.assertEquals(testInstructor.getName(), "Janis");
        Assertions.assertEquals(testInstructor.getPhone(), "123");
        Assertions.assertEquals(testInstructor.getLinkedinLink(), "link");
        Assertions.assertEquals(testInstructor.getGithubLink(), "git");
        Assertions.assertEquals(testInstructor.getEmail(), "e-mail");
    }
}