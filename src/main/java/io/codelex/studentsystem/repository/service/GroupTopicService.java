package io.codelex.studentsystem.repository.service;

import io.codelex.studentsystem.repository.model.GroupRecord;
import io.codelex.studentsystem.repository.model.InstructorRecord;
import io.codelex.studentsystem.repository.model.TopicRecord;
import io.codelex.studentsystem.repository.recordrepository.GroupRecordRepository;
import io.codelex.studentsystem.repository.recordrepository.TopicRecordRepository;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class GroupTopicService {
    private final GroupRecordRepository groupRecordRepository;
    private final TopicRecordRepository topicRecordRepository;

    public GroupTopicService(GroupRecordRepository groupRecordRepository, TopicRecordRepository topicRecordRepository) {
        this.groupRecordRepository = groupRecordRepository;
        this.topicRecordRepository = topicRecordRepository;
    }

    public void linkGroupWithTopics(long topicId, long groupId) {
        GroupRecord groupRecord = groupRecordRepository.findById(groupId).orElse(null);
        TopicRecord topicRecord= topicRecordRepository.findById(topicId).orElse(null);
        Set<TopicRecord> topicRecordSet = groupRecord.getTopics();
        topicRecordSet.add(topicRecord);
    }
}
