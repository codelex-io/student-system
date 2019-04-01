package io.codelex.studentsystem.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class AddGroup {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate plannedEndDate;
    private double progress;

    public AddGroup(@JsonProperty("name") String name,
                    @JsonProperty("startDate") LocalDate startDate,
                    @JsonProperty("endDate") LocalDate endDate,
                    @JsonProperty("plannedEndDate") LocalDate plannedEndDate,
                    @JsonProperty("progress") double progress) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.plannedEndDate = plannedEndDate;
        this.progress = progress;
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
