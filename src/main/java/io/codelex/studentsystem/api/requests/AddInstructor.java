package io.codelex.studentsystem.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AddInstructor {
    @NotEmpty
    private String name;
    @NotEmpty
    private String linkedinLink;
    @NotEmpty
    private String githubLink;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String email;
    @NotNull
    private boolean status;

    public AddInstructor(@JsonProperty("name") String name,
                         @JsonProperty("linkedinLink") String linkedinLink,
                         @JsonProperty("githubLink") String githubLink,
                         @JsonProperty("phone") String phone,
                         @JsonProperty("email") String email,
                         @JsonProperty("status") boolean status) {
        this.name = name;
        this.githubLink = githubLink;
        this.linkedinLink = linkedinLink;
        this.phone = phone;
        this.email = email;
        this.status = status;
    }

    public String getLinkedinLink() {
        return linkedinLink;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public boolean isStatus() {
        return status;
    }
}
