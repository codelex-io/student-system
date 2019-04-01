package io.codelex.studentsystem.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddInstructor {
    private String name;
    private String phone;
    private String email;
    private boolean status;

    public AddInstructor(@JsonProperty("name") String name,
                         @JsonProperty("phone") String phone,
                         @JsonProperty("email") String email,
                         @JsonProperty("status") boolean status) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.status = status;
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
