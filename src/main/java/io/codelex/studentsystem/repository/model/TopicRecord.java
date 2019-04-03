package io.codelex.studentsystem.repository.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "topics")
public class TopicRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String state;
    private LocalDate creationDate;
    @ManyToMany
    @JoinTable(
            name = "topics_in_students",
            joinColumns = @JoinColumn(name = "topic_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<StudentRecord> studentWithTopic;
    @OneToMany
    @JoinTable(
            name = "topic_in_quiz",
            joinColumns = @JoinColumn(name = "topics_id"),
            inverseJoinColumns = @JoinColumn(name = "quiz_id"))
    private Set<QuizRecord> quizId;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public Set<QuizRecord> getQuizId() {
        return quizId;
    }

    public void setQuizId(Set<QuizRecord> quizId) {
        this.quizId = quizId;
    }
}
