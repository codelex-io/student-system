package io.codelex.studentsystem.repository.model.maprecord;

import io.codelex.studentsystem.api.Instructor;
import io.codelex.studentsystem.repository.model.InstructorRecord;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapInstructorRecordToInstructor implements Function<InstructorRecord, Instructor> {

    @Override
    public Instructor apply(InstructorRecord instructorRecord) {
        return new Instructor(
                instructorRecord.getInstructorId(),
                instructorRecord.getName(),
                instructorRecord.getLinkedinLink(),
                instructorRecord.getGithubLink(),
                instructorRecord.getPhone(),
                instructorRecord.getEmail()
        );
    }
}
