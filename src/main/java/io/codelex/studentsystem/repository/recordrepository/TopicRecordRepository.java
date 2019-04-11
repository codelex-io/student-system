package io.codelex.studentsystem.repository.recordrepository;

import io.codelex.studentsystem.repository.model.TopicRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRecordRepository extends JpaRepository<TopicRecord, Long> {
}
