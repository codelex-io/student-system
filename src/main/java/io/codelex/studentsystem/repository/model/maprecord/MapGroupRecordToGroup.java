package io.codelex.studentsystem.repository.model.maprecord;

import io.codelex.studentsystem.api.Group;
import io.codelex.studentsystem.api.Instructor;
import io.codelex.studentsystem.repository.InstructorRecordRepository;
import io.codelex.studentsystem.repository.model.GroupRecord;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class MapGroupRecordToGroup implements Function<GroupRecord, Group> {
    private MapInstructorRecordToInstructor toInstructor;
    private InstructorRecordRepository instructorRecordRepository;

    public MapGroupRecordToGroup(MapInstructorRecordToInstructor toInstructor, InstructorRecordRepository instructorRecordRepository) {
        this.toInstructor = toInstructor;
        this.instructorRecordRepository = instructorRecordRepository;
    }

    @Override
    public Group apply(GroupRecord groupRecord) {

        List<Instructor> record = instructorRecordRepository.findAllInstructorsInThisGroup(groupRecord.getGroupId()).stream().map(toInstructor).collect(Collectors.toList());

        return new Group(
                groupRecord.getGroupId(),
                groupRecord.getName(),
                groupRecord.getStartDate(),
                groupRecord.getEndDate(),
                groupRecord.getPlannedEndDate(),
                record
        );
    }
}
