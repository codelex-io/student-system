package io.codelex.studentsystem;

import io.codelex.studentsystem.api.Group;
import io.codelex.studentsystem.api.Student;
import io.codelex.studentsystem.api.Topic;
import io.codelex.studentsystem.api.requests.AddGroup;
import io.codelex.studentsystem.repository.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class GroupController {
    private final GroupService service;

    public GroupController(GroupService service) {
        this.service = service;
    }

    @GetMapping("/api/groups")
    public List<Group> showAllGroups() {
        return service.findAllGroups();
    }

    @GetMapping("/api/groups/{groupsId}")
    public Group findGroupById(@PathVariable long groupsId) {
        return service.findGroupById(groupsId);
    }

    @GetMapping("/api/groups/{groupsId}/students")
    public List<Student> showStudentsInGroup(@PathVariable long groupsId) {
        return null;
    }

    @GetMapping("/api/groups/{groupsId}/topics")
    public List<Topic> showTopicsInGroup(@PathVariable long groupsId) {
        return null;
    }

    @PutMapping("/internal-api/groups")
    public Group addGroup(@RequestBody AddGroup request) {
        return service.addGroup(request);
    }

    @DeleteMapping("/internal-api/groups/{groupsId}")
    public void deleteById(@PathVariable long groupsId) {
        service.deleteById(groupsId);
    }
}
