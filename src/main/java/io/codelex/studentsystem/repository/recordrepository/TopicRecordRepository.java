package io.codelex.studentsystem.repository.recordrepository;

import io.codelex.studentsystem.repository.model.TopicRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Arrays;
import java.util.List;

public interface TopicRecordRepository extends JpaRepository<TopicRecord, Long> {
    
}
