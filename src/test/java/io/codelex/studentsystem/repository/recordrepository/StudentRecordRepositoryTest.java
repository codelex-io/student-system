package io.codelex.studentsystem.repository.recordrepository;

import io.codelex.studentsystem.repository.GroupRecordRepository;
import io.codelex.studentsystem.repository.StudentRecordRepository;
import io.codelex.studentsystem.repository.model.GroupRecord;
import io.codelex.studentsystem.repository.model.StudentRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentRecordRepositoryTest {
    @Autowired
    GroupRecordRepository groupRecordRepository;
    @Autowired
    StudentRecordRepository studentRecordRepository;

    @BeforeEach
    void setUp() {
        studentRecordRepository.deleteAll();
        groupRecordRepository.deleteAll();
    }

    @Test
    void should_find_students_if_group_id_is_given() {

        //given
        GroupRecord groupRecord = new GroupRecord();
        groupRecord.setName("The Group");
        groupRecord.setStartDate(LocalDate.now());
        groupRecord.setEndDate(LocalDate.now().plusMonths(4));
        groupRecord.setPlannedEndDate(LocalDate.now().plusMonths(3));
        groupRecordRepository.save(groupRecord);

        StudentRecord studentRecord = new StudentRecord();
        studentRecord.setGroupId(1L);
        studentRecord.setName("Peteris");
        studentRecord.setTelephone("123456");
        studentRecord.setDescription("Student");
        studentRecord.setEmail("e@mail.com");
        studentRecord.setGitHub("github");
        studentRecord.setLinkedIn("linkedin");
        studentRecord.setImage("image");
        studentRecord.setStatus("available");
        studentRecordRepository.save(studentRecord);

        StudentRecord studentRecord2 = new StudentRecord();
        studentRecord2.setName("Anna");
        studentRecord2.setTelephone("1234562");
        studentRecord2.setStatus("available");
        studentRecord2.setGroupId(2L);
        studentRecord2.setDescription("Student2");
        studentRecord2.setEmail("e@mail.com2");
        studentRecord2.setGitHub("github2");
        studentRecord2.setLinkedIn("linkedin2");
        studentRecord2.setImage("image2");
        studentRecordRepository.save(studentRecord2);

        //when
        List<StudentRecord> resultList = studentRecordRepository.findStudentsByGroupId(1);
        List<StudentRecord> testList = new ArrayList<>();
        testList.add(studentRecord);

        //then
        Assertions.assertEquals(resultList, testList);
    }

}