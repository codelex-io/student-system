package io.codelex.studentsystem.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddEmployer {
    private final String name;
    private final String personName;
    private final String personPhone;
    private final String personEmail;
    private final String password;
    private final String login;

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
