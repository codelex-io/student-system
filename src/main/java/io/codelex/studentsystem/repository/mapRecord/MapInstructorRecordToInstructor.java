package io.codelex.studentsystem.repository.mapRecord;

import io.codelex.studentsystem.api.Instructor;
import io.codelex.studentsystem.repository.model.InstructorRecord;

import java.util.function.Function;

public class MapInstructorRecordToInstructor implements Function<InstructorRecord, Instructor> {

    @Override
    public Instructor apply(InstructorRecord instructorRecord) {
        return new Instructor(
                instructorRecord.getInstructorId(),
                instructorRecord.getName(),
                instructorRecord.getLinkedinLink(),
                instructorRecord.getGithubLink(),
                instructorRecord.getPhone(),
                instructorRecord.getEmail(),
                instructorRecord.isStatus()
        );
    }
}
