package io.codelex.studentsystem;

import io.codelex.studentsystem.repository.service.GroupInstructorService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class GroupInstructorController {
    private final GroupInstructorService groupInstructorService;

    public GroupInstructorController(GroupInstructorService groupInstructorService) {
        this.groupInstructorService = groupInstructorService;
    }

    @PutMapping("internal-api/groups-instructors")
    public void linkInstructorsAndGroups(long instructorId, long groupId) {
        groupInstructorService.linkGroupWithInstructors(instructorId, groupId);
    }

}
