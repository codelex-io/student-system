package io.codelex.studentsystem;

import io.codelex.studentsystem.api.Group;
import io.codelex.studentsystem.api.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GroupController {

    @GetMapping("/groups")
    public List<Group> findAllGroups() {
        return null;
    }

    @GetMapping("/groups/{id}")
    public Group findGroup() {
        return null;
    }

    @GetMapping("/groups/{id}/students")
    public List<Student> findAllStudents() {
        return null;
    }

    @GetMapping("groups/{id}/students/{id}")
    public Student findStudent() {
        return null;
    }
}
