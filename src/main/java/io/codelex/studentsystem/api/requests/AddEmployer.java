package io.codelex.studentsystem.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class AddEmployer {
    @NotEmpty
    private final String name;
    @NotEmpty
    private final String personName;
    @NotEmpty
    private final String personPhone;
    @NotEmpty
    @Email
    private final String personEmail;
    @NotEmpty
    private final String password;
    @NotEmpty
    private final String login;

    public AddEmployer(@JsonProperty("name") String name,
                       @JsonProperty("personName") String personName, //todo split in person
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
