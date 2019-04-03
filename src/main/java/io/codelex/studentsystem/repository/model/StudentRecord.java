package io.codelex.studentsystem.repository.model;


import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "students")
public class StudentRecord {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(
            name = "students_with_topics",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "topic_id"))
    private Set<TopicRecord> topicsInStudent;
    private String name;
    private String image;
    private String linkedIn;
    private String gitHub;
    private String telephone;
    private String email;
    private String description;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<TopicRecord> getTopicsInStudent() {
        return topicsInStudent;
    }

    public void setTopicsInStudent(Set<TopicRecord> topicsInStudent) {
        this.topicsInStudent = topicsInStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getGitHub() {
        return gitHub;
    }

    public void setGitHub(String gitHub) {
        this.gitHub = gitHub;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
