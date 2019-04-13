package io.codelex.studentsystem.api.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class SignIn {
    @NotEmpty
    private final String login;
    @NotEmpty
    private final String password;

    @JsonCreator
    public SignIn(@JsonProperty("login") String login,
                  @JsonProperty("password") String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
