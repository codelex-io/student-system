package io.codelex.studentsystem;

import io.codelex.studentsystem.api.requests.LinkTopicAndGroup;
import io.codelex.studentsystem.repository.service.GroupTopicService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
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
