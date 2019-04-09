package io.codelex.studentsystem.repository.service;

import io.codelex.studentsystem.repository.model.GroupRecord;
import io.codelex.studentsystem.repository.model.InstructorRecord;
import io.codelex.studentsystem.repository.recordRepository.GroupRecordRepository;
import io.codelex.studentsystem.repository.recordRepository.InstructorRecordRepository;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class GroupInstructorService {
    private final GroupRecordRepository groupRecordRepository;
    private final InstructorRecordRepository instructorRecordRepository;

    public GroupInstructorService(GroupRecordRepository groupRecordRepository, InstructorRecordRepository instructorRecordRepository) {
        this.groupRecordRepository = groupRecordRepository;
        this.instructorRecordRepository = instructorRecordRepository;
    }

    public void linkGroupWithInstructors(long instructorId, long groupId) {
        GroupRecord groupRecord = groupRecordRepository.findById(groupId).orElse(null);
        InstructorRecord instructorRecord = instructorRecordRepository.findById(instructorId).orElse(null);
        Set<GroupRecord> groupRecordSet = instructorRecord.getGroups();
        groupRecordSet.add(groupRecord);
    }
}
