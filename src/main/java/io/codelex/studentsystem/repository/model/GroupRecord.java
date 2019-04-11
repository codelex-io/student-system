package io.codelex.studentsystem.repository.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "Groups")
@Table(name = "groups")
public class GroupRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;
    @OneToMany
    private Set<StudentRecord> students;
    @ManyToMany
    private Set<TopicRecord> topics;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate plannedEndDate;
    private double progress;

    public Set<TopicRecord> getTopics() {
        return topics;
    }

    public void setTopics(Set<TopicRecord> topics) {
        this.topics = topics;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Set<StudentRecord> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentRecord> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getPlannedEndDate() {
        return plannedEndDate;
    }

    public void setPlannedEndDate(LocalDate plannedEndDate) {
        this.plannedEndDate = plannedEndDate;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }
}
