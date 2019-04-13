package io.codelex.studentsystem.repository.service;

import io.codelex.studentsystem.api.Topic;
import io.codelex.studentsystem.api.requests.AddTopic;
import io.codelex.studentsystem.repository.model.GroupRecord;
import io.codelex.studentsystem.repository.model.maprecord.MapTopicRecordToTopic;
import io.codelex.studentsystem.repository.model.TopicRecord;
import io.codelex.studentsystem.repository.GroupRecordRepository;
import io.codelex.studentsystem.repository.TopicRecordRepository;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class TopicsService {
    private final TopicRecordRepository topicRecordRepository;
    private final GroupRecordRepository groupRecordRepository;
    private MapTopicRecordToTopic map = new MapTopicRecordToTopic();

    public TopicsService(TopicRecordRepository topicRecordRepository, GroupRecordRepository groupRecordRepository) {
        this.topicRecordRepository = topicRecordRepository;
        this.groupRecordRepository = groupRecordRepository;
    }

    public Topic addTopic(AddTopic request) {
        TopicRecord topicRecord = new TopicRecord();
        topicRecord.setName(request.getName());
        topicRecord.setState(request.getState());
        topicRecord.setCreationDate(request.getCreationDate());
        topicRecord = topicRecordRepository.save(topicRecord);
        return map.apply(topicRecord);
    }

    public List<Topic> findAllTopics() {
        return topicRecordRepository.findAll()
                .stream()
                .map(map)
                .collect(Collectors.toList());
    }

    public Topic findTopicById(Long id) {

        return topicRecordRepository
                .findById(id)
                .map(map)
                .orElse(null);
    }

    public void deleteById(long id) {
        topicRecordRepository.deleteById(id);
    }

    public List<Topic> showTopicInGroup(long groupsId) {
        //todo scrolling horizontal is bad
        Set<TopicRecord> topicRecord = groupRecordRepository.findById(groupsId).map(GroupRecord::getTopics).orElse(Collections.emptySet());
        return topicRecord.stream().map(map).collect(Collectors.toList());
    }
}
