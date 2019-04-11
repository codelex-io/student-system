package io.codelex.studentsystem;

import io.codelex.studentsystem.api.Group;
import io.codelex.studentsystem.api.Instructor;
import io.codelex.studentsystem.api.Student;
import io.codelex.studentsystem.api.Topic;
import io.codelex.studentsystem.api.requests.AddGroup;
import io.codelex.studentsystem.repository.service.GroupService;
import io.codelex.studentsystem.repository.service.InstructorService;
import io.codelex.studentsystem.repository.service.StudentService;
import io.codelex.studentsystem.repository.service.TopicsService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
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

    @PutMapping("/internal-api/groups")
    public Group addGroup(@Valid @RequestBody AddGroup request) {
        return service.addGroup(request);
    }

    @GetMapping("/internal-api/groups/{groupsId}")
    public Group findGroupById(@PathVariable long groupsId) {
        return service.findGroupById(groupsId);
    }

    @DeleteMapping("/internal-api/groups/{groupsId}")
    public void deleteById(@PathVariable long groupsId) {
        service.deleteById(groupsId);
    }

    @GetMapping("/internal-api/groups")
    public List<Group> showAllGroups() {
        return service.findAllGroups();
    }

    @GetMapping("/internal-api/groups/{groupsId}/instructors")
    public List<Instructor> showInstructorsInGroup(@PathVariable long groupsId) {
        return instructorService.findInstructorsByGroupId(groupsId);
    }

    @GetMapping("/internal-api/groups/{groupsId}/students")
    public List<Student> showStudentsInGroup(@PathVariable long groupsId) {
        return studentService.findStudentsInGroup(groupsId);
    }

    @GetMapping("/internal-api/groups/{groupsId}/topics")
    public List<Topic> showTopicsInGroup(@PathVariable long groupsId) {
        return topicsService.showTopicInGroup(groupsId);
    }
}
