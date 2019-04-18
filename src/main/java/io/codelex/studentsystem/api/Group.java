package io.codelex.studentsystem.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public class Group {
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate plannedEndDate;
    private List<Instructor> instructors;

    @JsonCreator
    public Group(@JsonProperty("id") Long id,
                 @JsonProperty("name") String name,
                 @JsonProperty("startDate") LocalDate startDate,
                 @JsonProperty("endDate") LocalDate endDate,
                 @JsonProperty("plannedEndDate") LocalDate plannedEndDate,
                 @JsonProperty("instructors") List<Instructor> instructors
    ) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.plannedEndDate = plannedEndDate;
        this.instructors = instructors;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public LocalDate getPlannedEndDate() {
        return plannedEndDate;
    }

    public List<Instructor> getInstructor() {
        return instructors;
    }

    public void setInstructor(List<Instructor> instructors) {
        this.instructors = instructors;
    }
}
