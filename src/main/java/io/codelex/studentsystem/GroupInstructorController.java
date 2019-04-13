package io.codelex.studentsystem;

import io.codelex.studentsystem.api.requests.LinkInstructorAndGroup;
import io.codelex.studentsystem.service.GroupInstructorService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupInstructorController {
    private final GroupInstructorService groupInstructorService;

    public GroupInstructorController(GroupInstructorService groupInstructorService) {
        this.groupInstructorService = groupInstructorService;
    }

    @PutMapping("internal-api/groups-instructors")
    public void linkInstructorsAndGroups(@RequestBody LinkInstructorAndGroup request) {
        groupInstructorService.linkGroupWithInstructors(request);
    }
}
