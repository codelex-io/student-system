package io.codelex.studentsystem.repository.service;

import io.codelex.studentsystem.api.requests.LinkInstructorAndGroup;
import io.codelex.studentsystem.repository.model.GroupRecord;
import io.codelex.studentsystem.repository.model.InstructorRecord;
import io.codelex.studentsystem.repository.GroupRecordRepository;
import io.codelex.studentsystem.repository.InstructorRecordRepository;
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

    public void linkGroupWithInstructors(LinkInstructorAndGroup request) {
        GroupRecord groupRecord = groupRecordRepository.findById(request.getGroupId()).orElse(null);
        InstructorRecord instructorRecord = instructorRecordRepository.findById(request.getInstructorId()).orElse(null);
        Set<GroupRecord> groupRecordSet = instructorRecord.getGroups();
        groupRecordSet.add(groupRecord);
    }
}
