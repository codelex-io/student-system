package io.codelex.studentsystem.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;

public class Employer {
    private Long id;
    private String company;
    private Person person;
    private String password;
    private String login;

    @JsonCreator
    public Employer(@JsonProperty("id") Long id,
                    @JsonProperty("company") String company,
                    @Valid @JsonProperty("person") Person person,
                    @JsonProperty("password") String password,
                    @JsonProperty("login") String login) {
        this.id = id;
        this.company = company;
        this.person = person;
        this.password = password;
        this.login = login;
    }

    public Long getId() {
        return id;
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
