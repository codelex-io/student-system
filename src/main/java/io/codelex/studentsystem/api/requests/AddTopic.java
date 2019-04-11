package io.codelex.studentsystem.api.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class AddTopic {
    private final String name;
    private final String state;
    private final LocalDate creationDate;

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

    public String getState() {
        return state;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}
