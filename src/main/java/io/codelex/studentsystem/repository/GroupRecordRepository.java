package io.codelex.studentsystem.repository;

import io.codelex.studentsystem.repository.model.GroupRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRecordRepository extends JpaRepository<GroupRecord, Long> {
}
