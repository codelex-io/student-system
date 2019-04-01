package io.codelex.studentsystem.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.codelex.studentsystem.api.Group;

public class AddStudent {
    private String name;
    private String image;
    private String linkedIn;
    private String gitHub;
    private String telephone;
    private String email;
    private String description;
    private String status;
    private Group groupId;

    public AddStudent(@JsonProperty("name") String name,
                      @JsonProperty("image") String image,
                      @JsonProperty("linkedIn") String linkedIn,
                      @JsonProperty("gitHub") String gitHub,
                      @JsonProperty("telephone") String telephone,
                      @JsonProperty("email") String email,
                      @JsonProperty("description") String description,
                      @JsonProperty("status") String status,
                      @JsonProperty("groupId") Group groupId) {
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

    public String getStatus() {
        return status;
    }

    public Group getGroupId() {
        return groupId;
    }
}
