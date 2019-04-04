package io.codelex.studentsystem.repository;

import io.codelex.studentsystem.repository.model.GroupRecord;
import io.codelex.studentsystem.repository.model.InstructorRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class InstructorRecordRepositoryTest {
    
    @Autowired
    InstructorRecordRepository instructorRecordRepository;
    
    @BeforeEach
    void setUp(){
        instructorRecordRepository.deleteAll();
    }
    
    @Test
    void should_return_list_of_instructors(){
        //given
        List<InstructorRecord> testList = new ArrayList<>();
        InstructorRecord record = new InstructorRecord();
        record.setEmail("sandris@codelex.io");
        record.setName("Sandris");
        record.setGithubLink("/github/sandris");
        record.setLinkedinLink("/linkedin/sandris");
        record.setPhone("12345678");
        record.setStatus(true);

        GroupRecord record1 = new GroupRecord();
        
        
        instructorRecordRepository.save(record);
        
        //when
        testList = instructorRecordRepository.findAllInstructorsByGroupId2(1);
        //then
        Assertions.assertFalse(testList.isEmpty());
        
    }

}