package io.codelex.studentsystem;

import io.codelex.studentsystem.api.Group;
import io.codelex.studentsystem.api.Student;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/internal-api/groups")
public class InternalController {
    
    @PutMapping("/{id}")
    public Group addNewGroup(){
        return null;
    }
    
    @PutMapping("/students/{id}")
    public Student addNewStudent(){
        return null;
    }
}
