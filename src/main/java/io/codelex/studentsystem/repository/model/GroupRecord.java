package io.codelex.studentsystem.repository.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "groups")
public class GroupRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;
    @ManyToMany(mappedBy = "groupsInstructorIsIn")
    private Set<InstructorRecord> groupsIsIn;
}
