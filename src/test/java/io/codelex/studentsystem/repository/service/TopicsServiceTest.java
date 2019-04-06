package io.codelex.studentsystem.repository.service;

import io.codelex.studentsystem.api.Topic;
import io.codelex.studentsystem.api.requests.AddTopic;
import io.codelex.studentsystem.repository.recordRepository.TopicRecordRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class TopicsServiceTest {
    private TopicRecordRepository repository = Mockito.mock(TopicRecordRepository.class);
    private TopicsService service = new TopicsService(repository);
    private LocalDate defaultDate = LocalDate.of(2019,1,1);
    @Test
    void should_add_topic() {
        //given
        AddTopic request = new AddTopic(
                "Java",
                "Completed",
                defaultDate
        );
        //when
        Mockito.when(repository.save(any())).thenAnswer((Answer) invocation -> invocation.getArguments()[0]);
        Topic result = service.addTopic(request);
        //then
        Assertions.assertEquals(request.getCreationDate(), result.getCreationDate());
        Assertions.assertEquals(request.getName(), result.getName());
        Assertions.assertEquals(request.getState(), result.getState());
    }

    @Test
    void should_not_add_topic_if_contains_null() {
        
    }

    @Test
    void should_find_all_topics() {
        //given
        AddTopic request = new AddTopic(
                "Java",
                "Completed",
                defaultDate
        );
        //when
        Mockito.when(repository.save(any())).thenAnswer((Answer) invocation -> invocation.getArguments()[0]);
        Topic result = service.addTopic(request);
        List<Topic> searchAll = service.findAllTopics();
        //then
        
    }

    @Test
    void should_find_topic_by_id() {
        
    }

    @Test
    void should_delete_by_id() {
        
    }
}