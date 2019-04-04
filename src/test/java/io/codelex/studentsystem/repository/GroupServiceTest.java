package io.codelex.studentsystem.repository;

import io.codelex.studentsystem.api.Group;
import io.codelex.studentsystem.api.requests.AddGroup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;

class GroupServiceTest {
    private GroupRecordRepository repository = Mockito.mock(GroupRecordRepository.class);
    private GroupService service = new GroupService(repository);

    @Test
    void addGroup() {
        //given
        AddGroup request = new AddGroup(
                "Software development",
                LocalDate.of(2019, 1, 21),
                null,
                LocalDate.of(2019, 4, 30),
                0
        );
        //when
        Mockito.when(repository.save(any())).thenAnswer((Answer) invocation -> invocation.getArguments()[0]);
        Group result = service.addGroup(request);
        //then
        Assertions.assertEquals(result.getName(), request.getName());
        Assertions.assertEquals(result.getStartDate(), request.getStartDate());
        Assertions.assertEquals(result.getEndDate(), request.getEndDate());
        Assertions.assertEquals(result.getPlannedEndDate(), request.getPlannedEndDate());
        Assertions.assertEquals(result.getProgress(), request.getProgress());
    }
    
}

