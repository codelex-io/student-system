package io.codelex.studentsystem.repository.repositorymaprecordstests;

import io.codelex.studentsystem.api.Group;
import io.codelex.studentsystem.repository.InstructorRecordRepository;
import io.codelex.studentsystem.repository.model.maprecord.MapGroupRecordToGroup;
import io.codelex.studentsystem.repository.model.GroupRecord;
import io.codelex.studentsystem.repository.model.maprecord.MapInstructorRecordToInstructor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MapGroupRecordToGroupTest {

    private MapInstructorRecordToInstructor toInstructor = new MapInstructorRecordToInstructor();
    private InstructorRecordRepository recordRepository = Mockito.mock(InstructorRecordRepository.class);
    private MapGroupRecordToGroup toGroup = new MapGroupRecordToGroup(toInstructor, recordRepository);

    @Test
    void apply() {
        //given
        GroupRecord groupRecord = new GroupRecord();
        groupRecord.setGroupId(5L);
        groupRecord.setName("The Group");
        groupRecord.setStartDate(LocalDate.now());
        groupRecord.setEndDate(LocalDate.now().plusMonths(4));
        groupRecord.setPlannedEndDate(LocalDate.now().plusMonths(3));
        //when
        Group test = toGroup.apply(groupRecord);
        //then
        assertEquals(test.getPlannedEndDate(), LocalDate.now().plusMonths(3));
        assertEquals(test.getEndDate(), LocalDate.now().plusMonths(4));
        assertEquals(test.getStartDate(), LocalDate.now());
        assertEquals(test.getName(), "The Group");
    }
}