package io.codelex.studentsystem.repository.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "groups")
public class GroupRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;
    @ManyToMany
    private Set<InstructorRecord> groupsInstructorIsIn;
    @OneToMany
    @JoinTable(
            name = "groups_with_students",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<StudentRecord> studentsInGroup;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate plannedEndDate;
    private double progress;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Set<InstructorRecord> getGroupsInstructorIsIn() {
        return groupsInstructorIsIn;
    }

    public void setGroupsInstructorIsIn(Set<InstructorRecord> groupsInstructorIsIn) {
        this.groupsInstructorIsIn = groupsInstructorIsIn;
    }

    public Set<StudentRecord> getStudentsInGroup() {
        return studentsInGroup;
    }

    public void setStudentsInGroup(Set<StudentRecord> studentsInGroup) {
        this.studentsInGroup = studentsInGroup;
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
