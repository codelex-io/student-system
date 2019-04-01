package io.codelex.studentsystem;

import io.codelex.studentsystem.api.Group;
import io.codelex.studentsystem.api.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class GroupController {

    @PutMapping("/internal-api/groups/{id}")
    public Group addNewGroup() {
        return null;
    }

    @GetMapping("/api/groups")
    public List<Group> findAllGroups() {
        return null;
    }

    @GetMapping("/api/groups/{id}")
    public Group findGroup() {
        return null;
    }

    @GetMapping("api/groups/{id}/students")
    public List<Student> findAllStudents() {
        return null;
    }
}
