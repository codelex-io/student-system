package io.codelex.studentsystem.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Instructor {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private boolean status;

    public Instructor(@JsonProperty("id") Long id,
                      @JsonProperty("name") String name,
                      @JsonProperty("phone") String phone,
                      @JsonProperty("email") String email,
                      @JsonProperty("status") boolean status) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.status = status;
    }

    public Long getId() {
        return id;
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
