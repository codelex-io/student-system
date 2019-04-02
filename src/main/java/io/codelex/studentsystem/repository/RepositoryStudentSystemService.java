package io.codelex.studentsystem.repository;

import io.codelex.studentsystem.StudentSystemService;
import io.codelex.studentsystem.api.Instructor;
import io.codelex.studentsystem.api.requests.AddInstructor;
import io.codelex.studentsystem.repository.model.InstructorRecord;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "student_system", name = "store-type", havingValue = "database")
public class RepositoryStudentSystemService implements StudentSystemService {
    private final InstructorRecordRepository recordRepository;
    private final MapInstructorRecordToInstructor toInstructor = new MapInstructorRecordToInstructor();

    public RepositoryStudentSystemService(InstructorRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @Override
    public Instructor addInstructor(AddInstructor request) {
        InstructorRecord instructorRecord = new InstructorRecord();
        instructorRecord.setEmail(request.getEmail());
        instructorRecord.setGithubLink(request.getGithubLink());
        instructorRecord.setLinkedinLink(request.getLinkedinLink());
        instructorRecord.setName(request.getName());
        instructorRecord.setPhone(request.getPhone());
        instructorRecord.setStatus(true);
        instructorRecord = recordRepository.save(instructorRecord);
        return toInstructor.apply(instructorRecord);
    }

    @Override
    public void clear() {
        recordRepository.deleteAll();
    }
}
