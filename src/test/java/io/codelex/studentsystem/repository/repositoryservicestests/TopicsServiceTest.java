package io.codelex.studentsystem.repository.repositoryservicestests;

import io.codelex.studentsystem.api.Topic;
import io.codelex.studentsystem.api.requests.AddTopic;
import io.codelex.studentsystem.repository.model.TopicRecord;
import io.codelex.studentsystem.repository.GroupRecordRepository;
import io.codelex.studentsystem.repository.TopicRecordRepository;
import io.codelex.studentsystem.service.TopicsService;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

class TopicsServiceTest {
    private TopicRecordRepository repository = Mockito.mock(TopicRecordRepository.class);
    private GroupRecordRepository recordRepository = Mockito.mock(GroupRecordRepository.class);
    private TopicsService service = new TopicsService(repository, recordRepository);

    @Test
    void should_add_topic() {
        //given
        AddTopic request = addNewTopic();
        //when
        Mockito.when(repository.save(any())).thenAnswer((Answer) invocation -> invocation.getArguments()[0]);
        Topic result = service.addTopic(request);
        //then
        Assertions.assertEquals(request.getName(), result.getName());
        Assertions.assertEquals(request.getState(), result.getState());
    }

    @Test
    void should_find_topic_by_id() {
        //given
        TopicRecord topic = new TopicRecord();
        topic.setName("Java");
        topic.setState("Completed");
        Optional<TopicRecord> topicRecord = Optional.of(topic);
        Mockito.when(repository.findById(1L)).thenReturn(topicRecord);
        //when
        Topic result = service.findTopicById(1L);
        //then
        Assertions.assertNotNull(result);
        Assertions.assertEquals(topic.getName(), result.getName());
        Assertions.assertEquals(topic.getState(), result.getState());
    }

    @NotNull
    private AddTopic addNewTopic() {
        return new AddTopic(
                "Java",
                "Completed"
        );
    }
}