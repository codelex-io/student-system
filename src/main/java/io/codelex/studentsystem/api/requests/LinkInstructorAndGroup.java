package io.codelex.studentsystem.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class LinkInstructorAndGroup {

    @NotEmpty
    private long instructorId;
    @NotEmpty
    private long groupId;

    public LinkInstructorAndGroup(@JsonProperty("instructorId") long instructorId,
                                  @JsonProperty("instructorId") long groupId) {
        this.instructorId = instructorId;
        this.groupId = groupId;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(long instructorId) {
        this.instructorId = instructorId;
    }
}
