package io.codelex.studentsystem.repository.repositoryMapRecordsTests;

import io.codelex.studentsystem.api.Group;
import io.codelex.studentsystem.repository.mapRecord.MapGroupRecordToGroup;
import io.codelex.studentsystem.repository.model.GroupRecord;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MapGroupRecordToGroupTest {
    private MapGroupRecordToGroup toGroup = new MapGroupRecordToGroup();

    @Test
    void apply() {
        //given
        GroupRecord groupRecord = new GroupRecord();
        groupRecord.setGroupId(5L);
        groupRecord.setName("The Group");
        groupRecord.setStartDate(LocalDate.now());
        groupRecord.setEndDate(LocalDate.now().plusMonths(4));
        groupRecord.setPlannedEndDate(LocalDate.now().plusMonths(3));
        groupRecord.setProgress(0.0);
        //when
        Group test = toGroup.apply(groupRecord);
        //then
        assertEquals(test.getProgress(), 0.0);
        assertEquals(test.getPlannedEndDate(), LocalDate.now().plusMonths(3));
        assertEquals(test.getEndDate(), LocalDate.now().plusMonths(4));
        assertEquals(test.getStartDate(), LocalDate.now());
        assertEquals(test.getName(), "The Group");
    }
}