package io.codelex.studentsystem.repository.model.maprecord;

import io.codelex.studentsystem.api.Topic;
import io.codelex.studentsystem.repository.model.TopicRecord;

import java.util.function.Function;

public class MapTopicRecordToTopic implements Function<TopicRecord, Topic> {
    @Override
    public Topic apply(TopicRecord topicRecord) {
        return new Topic(topicRecord.getTopicId(),
                topicRecord.getName(),
                topicRecord.getState(),
                topicRecord.getCreationDate()
        );
    }
}
