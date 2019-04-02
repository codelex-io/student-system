package io.codelex.studentsystem.api.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.codelex.studentsystem.api.Topic;

import java.time.LocalDate;

public class AddQuiz {
    private String name;
    private boolean state;
    private LocalDate creationDate;
    private int score;
    private Topic topicName;

    @JsonCreator
    public AddQuiz(@JsonProperty("name") String name,
                   @JsonProperty("state") boolean state,
                   @JsonProperty("creationDate") LocalDate creationDate,
                   @JsonProperty("score") int score,
                   @JsonProperty("topicName") Topic topicName) {
        this.name = name;
        this.state = state;
        this.creationDate = creationDate;
        this.score = score;
        this.topicName = topicName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Topic getTopicName() {
        return topicName;
    }

    public void setTopicName(Topic topicName) {
        this.topicName = topicName;
    }
}
