package io.codelex.studentsystem.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddEmployer {
    private String name;
    private String personName;
    private String personPhone;
    private String personEmail;

    public AddEmployer(@JsonProperty("name") String name,
                       @JsonProperty("personName")String personName,
                       @JsonProperty("personPhone")String personPhone,
                       @JsonProperty("personEmail")String personEmail) {
        this.name = name;
        this.personName = personName;
        this.personPhone = personPhone;
        this.personEmail = personEmail;
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
}
