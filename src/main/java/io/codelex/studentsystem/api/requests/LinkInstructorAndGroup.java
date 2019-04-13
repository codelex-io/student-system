package io.codelex.studentsystem.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class LinkInstructorAndGroup {

    @NotEmpty
    private long instructorId;
    @NotEmpty
    private long groupId;

    public LinkInstructorAndGroup(@JsonProperty("instructorId") long instructorId,
                                  @JsonProperty("groupId") long groupId) {
        this.instructorId = instructorId;
        this.groupId = groupId;
    }

    public long getGroupId() {
        return groupId;
    }

    public long getInstructorId() {
        return instructorId;
    }

}
