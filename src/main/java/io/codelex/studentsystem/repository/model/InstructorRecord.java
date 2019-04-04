package io.codelex.studentsystem.repository.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Instructors")
@Table(name = "instructors")
public class InstructorRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instructorId;
    
    @ManyToMany
    private Set<GroupRecord> groups;
    
    private String name;
    private String linkedinLink;
    private String githubLink;
    private String phone;
    private String email;
    private boolean status;

    public Set<GroupRecord> getGroups() {
        return groups;
    }

    public void setGroups(Set<GroupRecord> groups) {
        this.groups = groups;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinkedinLink() {
        return linkedinLink;
    }

    public void setLinkedinLink(String linkedinLink) {
        this.linkedinLink = linkedinLink;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
