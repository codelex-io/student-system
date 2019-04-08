package io.codelex.studentsystem.repository.repositoryMapRecordsTests;

import io.codelex.studentsystem.api.Topic;
import io.codelex.studentsystem.repository.mapRecord.MapTopicRecordToTopic;
import io.codelex.studentsystem.repository.model.QuizRecord;
import io.codelex.studentsystem.repository.model.TopicRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class MapTopicRecordToTopicTest {
    private MapTopicRecordToTopic mapTopicRecordToTopic = new MapTopicRecordToTopic();

    @Test
    void apply() {
        //given
        TopicRecord record = new TopicRecord();
        record.setCreationDate(LocalDate.now());
        record.setName("newgroup");
        record.setState("active");
        record.setTopicId(2L);
        //when
        Topic topic = mapTopicRecordToTopic.apply(record);
        //then
        Assertions.assertEquals(topic.getId(), 2L);
        Assertions.assertEquals(topic.getCreationDate(), LocalDate.now());
        Assertions.assertEquals(topic.getName(), "newgroup");
        Assertions.assertEquals(topic.getState(), "active");
    }
}
