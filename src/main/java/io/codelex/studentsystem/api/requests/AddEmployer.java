package io.codelex.studentsystem.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.codelex.studentsystem.api.Person;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class AddEmployer {
    @NotEmpty
    private final String company;
    private final Person person;
    @NotEmpty
    private final String password;
    @NotEmpty
    private final String login;

    public AddEmployer(@JsonProperty("company") String company,
                       @JsonProperty("person") Person person,
                       @JsonProperty("password") String password,
                       @JsonProperty("login") String login) {
        this.company = company;
        this.person = person;
        this.password = password;
        this.login = login;
    }

    public String getCompany() {
        return company;
    }

    public Person getPerson() {
        return person;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }
}
