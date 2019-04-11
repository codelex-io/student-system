package io.codelex.studentsystem.repository.repositoryServicesTests;

import io.codelex.studentsystem.api.Group;
import io.codelex.studentsystem.api.requests.AddGroup;
import io.codelex.studentsystem.repository.model.GroupRecord;
import io.codelex.studentsystem.repository.recordrepository.GroupRecordRepository;
import io.codelex.studentsystem.repository.service.GroupService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class GroupServiceTest {
    private GroupRecordRepository repository = Mockito.mock(GroupRecordRepository.class);
    private GroupService service = new GroupService(repository);

    @Test
    void addGroup() {
        //given
        AddGroup request = setGroup();
        Mockito.when(repository.save(any())).thenAnswer((Answer) invocation -> invocation.getArguments()[0]);
        //when
        Group actual = service.addGroup(request);
        //then
        assertEquals(request.getName(), actual.getName());
        assertEquals(request.getStartDate(), actual.getStartDate());
        assertEquals(request.getEndDate(), actual.getEndDate());
        assertEquals(request.getPlannedEndDate(), actual.getPlannedEndDate());
        assertEquals(request.getProgress(), actual.getProgress());
    }

    @Test
    void should_be_able_to_save_group_and_find_by_id() {
        //given
        Mockito.when(repository.findById(any())).thenReturn(Optional.empty());
        Mockito.when(repository.save(any())).thenAnswer((Answer) invocation -> invocation.getArguments()[0]);
        //when
        Group group = service.addGroup(setGroup());
        //then
        assertEquals(setGroup().getName(), group.getName());
        assertEquals(setGroup().getEndDate(), group.getEndDate());
        assertEquals(setGroup().getProgress(), group.getProgress());
    }

    @Test
    void should_find_group_by_id() {
        //given
        GroupRecord record = new GroupRecord();
        record.setProgress(15);
        record.setName("firstgroup");
        record.setEndDate(LocalDate.of(2019, 12, 21));
        Optional<GroupRecord> groupRecord = Optional.of(record);
        Mockito.when(repository.findById(1L)).thenReturn(groupRecord);
        //when
        Group result = service.findGroupById(1L);
        //then
        assertNotNull(result);
        assertEquals(result.getProgress(), record.getProgress());
    }

    AddGroup setGroup() {
        return new AddGroup(
                "Software development",
                LocalDate.of(2019, 1, 21),
                null,
                LocalDate.of(2019, 4, 30),
                0
        );
    }
}

