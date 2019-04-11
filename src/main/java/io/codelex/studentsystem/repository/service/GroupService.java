package io.codelex.studentsystem.repository.service;

import io.codelex.studentsystem.api.Group;
import io.codelex.studentsystem.api.requests.AddGroup;
import io.codelex.studentsystem.repository.recordrepository.GroupRecordRepository;
import io.codelex.studentsystem.repository.model.maprecord.MapGroupRecordToGroup;
import io.codelex.studentsystem.repository.model.GroupRecord;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupService {
    private final GroupRecordRepository recordRepository;
    private MapGroupRecordToGroup mapGroupRecordToGroup = new MapGroupRecordToGroup();

    public GroupService(GroupRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public Group addGroup(AddGroup request) {
        GroupRecord groupRecord = new GroupRecord();
        groupRecord.setProgress(request.getProgress());
        groupRecord.setName(request.getName());
        groupRecord.setStartDate(request.getStartDate());
        groupRecord.setEndDate(request.getEndDate());
        groupRecord.setPlannedEndDate(request.getPlannedEndDate());
        groupRecord = recordRepository.save(groupRecord);
        return mapGroupRecordToGroup.apply(groupRecord);
    }

    public List<Group> findAllGroups() {
        return recordRepository.findAll()
                .stream()
                .map(mapGroupRecordToGroup)
                .collect(Collectors.toList());
    }

    public Group findGroupById(long groupsId) {
        return recordRepository.findById(groupsId).map(mapGroupRecordToGroup).orElse(null);
    }

    public void deleteById(long groupsId) {
        recordRepository.deleteById(groupsId);
    }
}
