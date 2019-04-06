package io.codelex.studentsystem.repository.service;

import io.codelex.studentsystem.api.Topic;
import io.codelex.studentsystem.api.requests.AddTopic;
import io.codelex.studentsystem.repository.mapRecord.MapTopicRecordToTopic;
import io.codelex.studentsystem.repository.model.TopicRecord;
import io.codelex.studentsystem.repository.recordRepository.TopicRecordRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TopicsService {
    private final TopicRecordRepository topicRecordRepository;
    private MapTopicRecordToTopic map = new MapTopicRecordToTopic();

    public TopicsService(TopicRecordRepository topicRecordRepository) {
        this.topicRecordRepository = topicRecordRepository;
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
}
