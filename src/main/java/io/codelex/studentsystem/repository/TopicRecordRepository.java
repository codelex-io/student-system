package io.codelex.studentsystem.repository;

import io.codelex.studentsystem.repository.model.TopicRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TopicRecordRepository extends JpaRepository<TopicRecord, Long> {

    @Query("select count (topics) > 0 from TopicRecord topics"
            + " where topics.name = :name")
    boolean isTopicPresent(@Param("name") String name);

}
