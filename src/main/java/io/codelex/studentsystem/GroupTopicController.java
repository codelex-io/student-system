package io.codelex.studentsystem;

import io.codelex.studentsystem.repository.service.GroupTopicService;
import org.springframework.web.bind.annotation.PutMapping;
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
    public void linkTopicsAndGroups(long topicId, long groupId) {
        groupTopicService.linkGroupWithTopics(topicId, groupId);
    }
}
