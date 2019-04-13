package io.codelex.studentsystem.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;

public class Person {
    private String name;
    @Email
    private String email;
    private String phone;

    @JsonCreator
    public Person(@JsonProperty("name") String name,
                  @JsonProperty("email") String email,
                  @JsonProperty("phone") String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
