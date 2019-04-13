package io.codelex.studentsystem.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Topic {
    private Long id;
    private String name;
    private String state;
    
    @JsonCreator
    public Topic(@JsonProperty("id") Long id,
                 @JsonProperty("name") String name,
                 @JsonProperty("state") String state) {
        this.id = id;
        this.name = name;
        this.state = state;
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

}
