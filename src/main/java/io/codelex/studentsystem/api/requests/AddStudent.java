package io.codelex.studentsystem.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class AddStudent {
    @NotEmpty
    private String name;
    @NotEmpty
    private String image;
    @NotEmpty
    private String linkedIn;
    @NotEmpty
    private String gitHub;
    @NotEmpty
    private String telephone;
    @NotEmpty
    private String email;
    @NotEmpty
    private String description;
    @NotEmpty
    private String status;

    public AddStudent(@JsonProperty("name") String name,
                      @JsonProperty("image") String image,
                      @JsonProperty("linkedIn") String linkedIn,
                      @JsonProperty("gitHub") String gitHub,
                      @JsonProperty("telephone") String telephone,
                      @JsonProperty("email") String email,
                      @JsonProperty("description") String description,
                      @JsonProperty("status") String status) {
        this.name = name;
        this.image = image;
        this.linkedIn = linkedIn;
        this.gitHub = gitHub;
        this.telephone = telephone;
        this.email = email;
        this.description = description;
        this.status = status;
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

}
