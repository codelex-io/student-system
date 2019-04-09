package io.codelex.studentsystem.repository.service;

import io.codelex.studentsystem.api.Instructor;
import io.codelex.studentsystem.api.requests.AddInstructor;
import io.codelex.studentsystem.repository.recordRepository.InstructorRecordRepository;
import io.codelex.studentsystem.repository.mapRecord.MapInstructorRecordToInstructor;
import io.codelex.studentsystem.repository.model.InstructorRecord;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InstructorService {
    private final InstructorRecordRepository recordRepository;
    private final MapInstructorRecordToInstructor toInstructor = new MapInstructorRecordToInstructor();

    public InstructorService(InstructorRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

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

    public Instructor findInstructorById(long id) {
        return recordRepository
                .findById(id)
                .map(toInstructor)
                .orElse(null);
    }

    public List<Instructor> findInstructorsByGroupId(long groupId) {
        return recordRepository.findAllInstructorsInThisGroup(groupId)
                .stream()
                .map(toInstructor)
                .collect(Collectors.toList());
    }

    public void deleteById(long id) {
        recordRepository.deleteById(id);
    }
}
