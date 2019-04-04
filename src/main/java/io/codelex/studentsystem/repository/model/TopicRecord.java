package io.codelex.studentsystem.repository.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "Topics")
@Table(name = "topics")
public class TopicRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topicId;
    private String name;
    private String state;
    private LocalDate creationDate;
    
    @OneToMany
    private Set<QuizRecord> quizes;

    public Long getTopicId() {
        return topicId;
    }

    public Set<QuizRecord> getQuizes() {
        return quizes;
    }

    public void setQuizes(Set<QuizRecord> quizes) {
        this.quizes = quizes;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
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
