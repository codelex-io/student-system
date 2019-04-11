package io.codelex.studentsystem.repository.model.maprecord;

import io.codelex.studentsystem.api.Group;
import io.codelex.studentsystem.repository.model.GroupRecord;

import java.util.function.Function;

public class MapGroupRecordToGroup implements Function<GroupRecord, Group> {
    @Override
    public Group apply(GroupRecord groupRecord) {
        return new Group(
                groupRecord.getGroupId(),
                groupRecord.getName(),
                groupRecord.getStartDate(),
                groupRecord.getEndDate(),
                groupRecord.getPlannedEndDate(),
                groupRecord.getProgress()
        );
    }
}
