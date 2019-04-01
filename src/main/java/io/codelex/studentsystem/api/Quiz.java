package io.codelex.studentsystem.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Quiz {
    private Long id;
    private String name;
    private boolean state;
    private LocalDate creationDate;
    private int score;
    private Topic topicName;

    @JsonCreator
    public Quiz(@JsonProperty("id") Long id, 
                @JsonProperty("name") String name, 
                @JsonProperty("state") boolean state, 
                @JsonProperty("creationDate") LocalDate creationDate, 
                @JsonProperty("score") int score, 
                @JsonProperty("topicName") Topic topicName) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.creationDate = creationDate;
        this.score = score;
        this.topicName = topicName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isState() {
        return state;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public int getScore() {
        return score;
    }

    public Topic getTopicName() {
        return topicName;
    }
}
