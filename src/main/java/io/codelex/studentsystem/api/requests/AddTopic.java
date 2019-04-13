package io.codelex.studentsystem.api.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class AddTopic {
    @NotEmpty
    private final String name;
    @NotEmpty
    private final String state;
    @NotNull
    private final LocalDate creationDate;

    @JsonCreator
    public AddTopic(@JsonProperty("name") String name,
                    @JsonProperty("state") String state,
                    @JsonProperty("creationDate") LocalDate creationDate) { //todo why?
        this.name = name;
        this.state = state;
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}
