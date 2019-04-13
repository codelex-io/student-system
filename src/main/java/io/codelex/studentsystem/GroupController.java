package io.codelex.studentsystem;

import io.codelex.studentsystem.api.Group;
import io.codelex.studentsystem.api.Instructor;
import io.codelex.studentsystem.api.Student;
import io.codelex.studentsystem.api.Topic;
import io.codelex.studentsystem.api.requests.AddGroup;
import io.codelex.studentsystem.service.GroupService;
import io.codelex.studentsystem.service.InstructorService;
import io.codelex.studentsystem.service.StudentService;
import io.codelex.studentsystem.service.TopicsService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/internal-api/groups")
public class GroupController {
    private final GroupService service;
    private final InstructorService instructorService;
    private final TopicsService topicsService;
    private final StudentService studentService;

    public GroupController(GroupService service, InstructorService instructorService, TopicsService topicsService, StudentService studentService) {
        this.service = service;
        this.instructorService = instructorService;
        this.topicsService = topicsService;
        this.studentService = studentService;
    }

    @PutMapping
    public ResponseEntity<?> addGroup(@Valid @RequestBody AddGroup request) {
        try {
            return new ResponseEntity<>(service.addGroup(request), HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>("Group with this name already exists!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{groupsId}")
    public ResponseEntity<?> findGroupById(@PathVariable long groupsId) {
        if (service.findGroupById(groupsId) != null) {
            return new ResponseEntity<>(service.findGroupById(groupsId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Such id does not exist", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{groupsId}")
    public ResponseEntity<String> deleteById(@PathVariable long groupsId) {
        if (service.findGroupById(groupsId) != null) {
            service.deleteById(groupsId);
            return new ResponseEntity<>("Group deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(groupsId + " id already does not exist!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public List<Group> showAllGroups() {
        return service.findAllGroups();
    }

    @GetMapping("/{groupsId}/instructors")
    public List<Instructor> showInstructorsInGroup(@PathVariable long groupsId) {
        return instructorService.findInstructorsByGroupId(groupsId);
    }

    @GetMapping("/{groupsId}/students")
    public List<Student> showStudentsInGroup(@PathVariable long groupsId) {
        return studentService.findStudentsInGroup(groupsId);
    }

    @GetMapping("/{groupsId}/topics")
    public List<Topic> showTopicsInGroup(@PathVariable long groupsId) {
        return topicsService.showTopicInGroup(groupsId);
    }
}
