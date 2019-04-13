package io.codelex.studentsystem;

import io.codelex.studentsystem.api.requests.LinkTopicAndGroup;
import io.codelex.studentsystem.service.GroupTopicService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupTopicController {
    private final GroupTopicService groupTopicService;

    public GroupTopicController(GroupTopicService groupTopicService) {
        this.groupTopicService = groupTopicService;
    }

    @PutMapping("internal-api/groups-topics")
    public void linkTopicsAndGroups(@RequestBody LinkTopicAndGroup request) {
        groupTopicService.linkGroupWithTopics(request);
    }
}
