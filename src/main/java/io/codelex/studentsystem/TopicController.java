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
@RequestMapping("/internal-api/topics")
public class TopicController {
    private final TopicsService service;

    public TopicController(TopicsService service) {
        this.service = service;
    }

    @PutMapping
    public ResponseEntity<?> addNewTopic(@Valid @RequestBody AddTopic request) {
        try {
            return new ResponseEntity<>(service.addTopic(request), HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>("This topic already exists!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findTopicById(@PathVariable("id") Long id) {
        if (service.findTopicById(id) != null) {
            return new ResponseEntity<>(service.findTopicById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Such id does not exist", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        if (service.findTopicById(id) != null) {
            service.deleteById(id);
            return new ResponseEntity<>("Topic deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(id + " id already does not exist!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public List<Topic> findAllTopic() {
        return service.findAllTopics();
    }
}
