package io.codelex.studentsystem.api.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class AddTopic {
    @NotEmpty
    private String name;
    @NotEmpty
    private String state;
    @NotNull
    private LocalDate creationDate;

    @JsonCreator
    public AddTopic(@JsonProperty("name") String name,
                    @JsonProperty("state") String state,
                    @JsonProperty("creationDate") LocalDate creationDate) {
        this.name = name;
        this.state = state;
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
