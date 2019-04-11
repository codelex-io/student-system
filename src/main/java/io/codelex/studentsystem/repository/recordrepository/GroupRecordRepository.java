package io.codelex.studentsystem.repository.recordrepository;

import io.codelex.studentsystem.repository.model.GroupRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface GroupRecordRepository extends JpaRepository<GroupRecord, Long> {
    
    @Query("select count(groups) > 0 from Groups groups"
            + " where groups.name = :name"
            + " and groups.startDate = :startDate"
            + " and groups.endDate = :endDate"
            + " and groups.plannedEndDate = :plannedEndDate"
            + " and groups.progress = :progress")
    boolean isGroupPresent(@Param("name") String name,
                           @Param("startDate") LocalDate startDate,
                           @Param("endDate") LocalDate endDate,
                           @Param("plannedEndDate") LocalDate plannedEndDate,
                           @Param("progress") double progress);
}
