package io.codelex.studentsystem.repository.service;

import io.codelex.studentsystem.api.requests.LinkTopicAndGroup;
import io.codelex.studentsystem.repository.model.GroupRecord;
import io.codelex.studentsystem.repository.model.TopicRecord;
import io.codelex.studentsystem.repository.GroupRecordRepository;
import io.codelex.studentsystem.repository.TopicRecordRepository;
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

    public void linkGroupWithTopics(LinkTopicAndGroup request) {
        GroupRecord groupRecord = groupRecordRepository.findById(request.getGroupId()).orElse(null);
        TopicRecord topicRecord = topicRecordRepository.findById(request.getTopicId()).orElse(null);
        Set<TopicRecord> topicRecordSet = groupRecord.getTopics();
        topicRecordSet.add(topicRecord);
    }
}
