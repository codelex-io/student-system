package io.codelex.studentsystem;

import io.codelex.studentsystem.api.Topic;
import io.codelex.studentsystem.api.requests.AddTopic;
import io.codelex.studentsystem.repository.service.TopicsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class TopicController {
    private final TopicsService service;

    public TopicController(TopicsService service) {
        this.service = service;
    }

    @PutMapping("/internal-api/topics")
    public Topic addNewTopic(@RequestBody AddTopic request) {
        return service.addTopic(request);
    }

    @GetMapping("/api/topics/{id}")
    public Topic findTopicById(@PathVariable("id") Long id) {
        return service.findTopicById(id);
    }

    @DeleteMapping("/internal-api/topics/{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }

    @GetMapping("/api/topics")
    public List<Topic> findAllTopic() {
        return service.findAllTopics();
    }
}
