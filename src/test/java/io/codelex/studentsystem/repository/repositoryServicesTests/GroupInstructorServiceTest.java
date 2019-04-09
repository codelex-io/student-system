package io.codelex.studentsystem.repository.repositoryServicesTests;

import io.codelex.studentsystem.repository.model.GroupRecord;
import io.codelex.studentsystem.repository.recordRepository.GroupRecordRepository;
import io.codelex.studentsystem.repository.recordRepository.InstructorRecordRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class GroupInstructorServiceTest {
    private GroupRecordRepository groupRepository = Mockito.mock(GroupRecordRepository.class);
    private InstructorRecordRepository instructorRepository = Mockito.mock(InstructorRecordRepository.class);

    @Test
    void should_be_able_to_save_group_record_in_set() {
        //given
        Mockito.when(groupRepository.findById(any())).thenReturn(Optional.empty());
        Mockito.when(instructorRepository.findById(any())).thenReturn(Optional.empty());
        Mockito.when(groupRepository.save(any())).thenAnswer((Answer) invocation -> invocation.getArguments()[0]);
        //when
        GroupRecord groupRecord = groupRepository.findById(1L).orElse(null);
        Set<GroupRecord> groupRecordSet = new HashSet<>();
        groupRecordSet.add(groupRecord);
        //then
        assertFalse(groupRecordSet.isEmpty());

    }
}