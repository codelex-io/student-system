package io.codelex.studentsystem.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Employer {
    private Long id;
    private String name;
    private String personName;
    private String personPhone;
    private String personEmail;

    @JsonCreator
    public Employer(@JsonProperty("id") Long id,
                    @JsonProperty("name") String name,
                    @JsonProperty("personName") String personName,
                    @JsonProperty("personPhone") String personPhone,
                    @JsonProperty("personEmail") String personEmail) {
        this.id = id;
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

    public Long getId() {
        return id;
    }
}
