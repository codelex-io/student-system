package io.codelex.studentsystem.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.codelex.studentsystem.api.Student;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class AddStudent {
    @NotEmpty
    private final String name;
    @NotEmpty
    private final String image;
    @NotEmpty
    private final String linkedIn;
    @NotEmpty
    private final String gitHub;
    @NotEmpty
    private final String telephone;
    @NotEmpty
    @Email
    private final String email;
    @NotEmpty
    private final String description;
    private final Student.StudentStatus status;
    private final long groupId;

    public AddStudent(@JsonProperty("name") String name,
                      @JsonProperty("image") String image,
                      @JsonProperty("linkedIn") String linkedIn,
                      @JsonProperty("gitHub") String gitHub,
                      @JsonProperty("telephone") String telephone,
                      @JsonProperty("email") String email,
                      @JsonProperty("description") String description,
                      @JsonProperty("status") Student.StudentStatus status,
                      @JsonProperty("groupId") long groupId) {
        this.name = name;
        this.image = image;
        this.linkedIn = linkedIn;
        this.gitHub = gitHub;
        this.telephone = telephone;
        this.email = email;
        this.description = description;
        this.status = status;
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public String getGitHub() {
        return gitHub;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public long getGroupId() {
        return groupId;
    }

    public Student.StudentStatus getStatus() {
        return status;
    }
}
