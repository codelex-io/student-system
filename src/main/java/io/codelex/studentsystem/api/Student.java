package io.codelex.studentsystem.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {

    public enum StudentStatus {
        AVAILABLE,
        SOLD,
        DISMISSED
    }

    private Long id;
    private String name;
    private String image;
    private String linkedIn;
    private String gitHub;
    private String telephone;
    private String email;
    private String description;
    private StudentStatus status;
    private long groupId;

    @JsonCreator
    public Student(@JsonProperty("id") Long id,
                   @JsonProperty("name") String name,
                   @JsonProperty("image") String image,
                   @JsonProperty("linkedIn") String linkedIn,
                   @JsonProperty("gitHub") String gitHub,
                   @JsonProperty("telephone") String telephone,
                   @JsonProperty("email") String email,
                   @JsonProperty("description") String description,
                   @JsonProperty("status") StudentStatus status,
                   @JsonProperty("groupId") long groupId) {
        this.id = id;
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

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }


    public Long getId() {
        return id;
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

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }
}
