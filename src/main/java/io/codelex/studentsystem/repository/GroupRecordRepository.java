package io.codelex.studentsystem.repository;

import io.codelex.studentsystem.repository.model.GroupRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GroupRecordRepository extends JpaRepository<GroupRecord, Long> {

    @Query("select count(groups) > 0 from Groups groups"
            + " where groups.name = :name")
    boolean isGroupPresent(@Param("name") String name);
}
