package io.codelex.studentsystem.api.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class AddTopic {
    private String name;
    private String state;
    private LocalDate creationDate;

    @JsonCreator
    public AddTopic(@JsonProperty("name") String name,
                    @JsonProperty("state") String state,
                    @JsonProperty("creationDate") LocalDate creationDate) {
        this.name = name;
        this.state = state;
        this.creationDate = creationDate;
    }
}
