package io.codelex.studentsystem.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Topic {
    private Long id;
    private String name;
    private String state;
    private LocalDate creationDate;

    @JsonCreator
    public Topic(@JsonProperty("id") Long id,
                 @JsonProperty("name") String name,
                 @JsonProperty("state") String state,
                 @JsonProperty("creationDate") LocalDate creationDate) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
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
