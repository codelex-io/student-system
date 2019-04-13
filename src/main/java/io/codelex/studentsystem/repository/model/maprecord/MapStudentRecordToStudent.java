package io.codelex.studentsystem.repository.model.maprecord;

import io.codelex.studentsystem.api.Student;
import io.codelex.studentsystem.repository.model.StudentRecord;

import java.util.function.Function;

public class MapStudentRecordToStudent implements Function<StudentRecord, Student> {
    @Override
    public Student apply(StudentRecord studentRecord) {
        return new Student(studentRecord.getStudentId(),
                studentRecord.getName(),
                studentRecord.getImage(),
                studentRecord.getLinkedin(),
                studentRecord.getGithub(),
                studentRecord.getTelephone(),
                studentRecord.getEmail(),
                studentRecord.getDescription(),
                studentRecord.getStatus(),
                studentRecord.getGroupId()
        );
    }
}
