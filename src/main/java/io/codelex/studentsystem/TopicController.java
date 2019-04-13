package io.codelex.studentsystem;

import io.codelex.studentsystem.api.Topic;
import io.codelex.studentsystem.api.requests.AddTopic;
import io.codelex.studentsystem.service.TopicsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
public class TopicController {
    private final TopicsService service;

    public TopicController(TopicsService service) {
        this.service = service;
    }

    @PutMapping("/internal-api/topics")
    public Topic addNewTopic(@Valid @RequestBody AddTopic request) {
        return service.addTopic(request);
    }

    @GetMapping("/internal-api/topics/{id}")
    public ResponseEntity<Topic> findTopicById(@PathVariable("id") Long id) {
        if (service.findTopicById(id) != null) {
            return new ResponseEntity<>(service.findTopicById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/internal-api/topics/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        if (service.findTopicById(id) != null) {
            service.deleteById(id);
            return new ResponseEntity<>("Topic deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(id + " id already does not exist!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/topics")
    public List<Topic> findAllTopic() {
        return service.findAllTopics();
    }
}
