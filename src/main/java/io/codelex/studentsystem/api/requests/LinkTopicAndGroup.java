package io.codelex.studentsystem.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class LinkTopicAndGroup {

    @NotEmpty
    private long topicId;
    @NotEmpty
    private long groupId;

    public LinkTopicAndGroup(@JsonProperty long topicId,
                             @JsonProperty long groupId) {
        this.topicId = topicId;
        this.groupId = groupId;
    }

    public long getTopicId() {
        return topicId;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }
}
