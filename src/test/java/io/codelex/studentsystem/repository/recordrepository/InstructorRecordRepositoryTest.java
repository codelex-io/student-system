package io.codelex.studentsystem.repository.recordrepository;

import io.codelex.studentsystem.repository.GroupRecordRepository;
import io.codelex.studentsystem.repository.InstructorRecordRepository;
import io.codelex.studentsystem.repository.model.GroupRecord;
import io.codelex.studentsystem.repository.model.InstructorRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class InstructorRecordRepositoryTest {
    @Autowired
    InstructorRecordRepository instructorRecordRepository;
    @Autowired
    GroupRecordRepository groupRecordRepository;

    @BeforeEach
    void setUp() {
        instructorRecordRepository.deleteAll();
        groupRecordRepository.deleteAll();
    }

    @Test
    void should_find_instructors_when_group_id_is_given() {
        //given
        GroupRecord groupRecord = new GroupRecord();
        groupRecord.setName("The Group");
        groupRecord.setStartDate(LocalDate.now());
        groupRecord.setEndDate(LocalDate.now().plusMonths(4));
        groupRecord.setPlannedEndDate(LocalDate.now().plusMonths(3));
        groupRecordRepository.save(groupRecord);

        InstructorRecord record = new InstructorRecord();
        record.setGroups(new HashSet<>());
        record.setName("Janis");
        record.setPhone("123");
        record.setLinkedinLink("link");
        record.setGithubLink("git");
        record.setEmail("e-mail");
        instructorRecordRepository.save(record);

        GroupRecord resultGroupRecord = groupRecordRepository.findById(1L).orElse(null);
        InstructorRecord resultInstructorRecord = instructorRecordRepository.findById(1L).orElse(null);
        Set<GroupRecord> groupRecordSet = resultInstructorRecord.getGroups();
        groupRecordSet.add(resultGroupRecord);

        GroupRecord groupRecord2 = new GroupRecord();
        groupRecord2.setName("The Group2");
        groupRecord2.setStartDate(LocalDate.now());
        groupRecord2.setEndDate(LocalDate.now().plusMonths(5));
        groupRecord2.setPlannedEndDate(LocalDate.now().plusMonths(4));
        groupRecordRepository.save(groupRecord2);

        InstructorRecord record2 = new InstructorRecord();
        record2.setGroups(new HashSet<>());
        record2.setName("Janis2");
        record2.setPhone("1232");
        record2.setLinkedinLink("link2");
        record2.setGithubLink("git2");
        record2.setEmail("e-mail2");
        instructorRecordRepository.save(record2);

        GroupRecord resultGroupRecord2 = groupRecordRepository.findById(2L).orElse(null);
        InstructorRecord resultInstructorRecord2 = instructorRecordRepository.findById(2L).orElse(null);
        Set<GroupRecord> groupRecordSet2 = resultInstructorRecord2.getGroups();
        groupRecordSet2.add(resultGroupRecord2);

        //when
        List<InstructorRecord> testList = new ArrayList<>();
        testList.add(record);
        List<InstructorRecord> resultList = instructorRecordRepository.findAllInstructorsInThisGroup(1L);

        //then
        assertEquals(testList, resultList);

    }
}