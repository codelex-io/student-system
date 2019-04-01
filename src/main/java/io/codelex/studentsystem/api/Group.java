package io.codelex.studentsystem.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Group {
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate plannedEndDate;
    private double progress;

    @JsonCreator
    public Group(@JsonProperty("id") Long id,
                 @JsonProperty("name") String name,
                 @JsonProperty("startDate") LocalDate startDate,
                 @JsonProperty("endDate") LocalDate endDate,
                 @JsonProperty("plannedEndDate") LocalDate plannedEndDate,
                 @JsonProperty("progress") double progress) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.plannedEndDate = plannedEndDate;
        this.progress = progress;
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

    public double getProgress() {
        return progress;
    }
}
