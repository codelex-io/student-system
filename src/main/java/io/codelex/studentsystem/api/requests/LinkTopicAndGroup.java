package io.codelex.studentsystem.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class LinkTopicAndGroup {

    @NotEmpty
    private long topicId;
    @NotEmpty
    private long groupId;

    public LinkTopicAndGroup(@JsonProperty("topicId") long topicId,
                             @JsonProperty("groupId") long groupId) {
        this.topicId = topicId;
        this.groupId = groupId;
    }

    public long getTopicId() {
        return topicId;
    }

    public long getGroupId() {
        return groupId;
    }

}
