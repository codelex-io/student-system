package io.codelex.studentsystem.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AddEmployer {
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String personName;
    @NotNull
    @NotEmpty
    private String personPhone;
    @NotNull
    @NotEmpty
    private String personEmail;
    @NotNull
    @NotEmpty
    private String password;
    @NotNull
    @NotEmpty
    private String login;

    public AddEmployer(@JsonProperty("name") String name,
                       @JsonProperty("personName") String personName,
                       @JsonProperty("personPhone") String personPhone,
                       @JsonProperty("personEmail") String personEmail,
                       @JsonProperty("password") String password,
                       @JsonProperty("login") String login) {
        this.name = name;
        this.personName = personName;
        this.personPhone = personPhone;
        this.personEmail = personEmail;
        this.password = password;
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getPersonName() {
        return personName;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public String getLogin() {
        return login;
    }
}
