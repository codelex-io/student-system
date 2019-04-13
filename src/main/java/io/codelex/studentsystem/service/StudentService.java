package io.codelex.studentsystem.service;

import io.codelex.studentsystem.api.Student;
import io.codelex.studentsystem.api.requests.AddStudent;
import io.codelex.studentsystem.repository.model.maprecord.MapStudentRecordToStudent;
import io.codelex.studentsystem.repository.StudentRecordRepository;
import io.codelex.studentsystem.repository.model.StudentRecord;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentService {
    private final StudentRecordRepository studentRecordRepository;
    private MapStudentRecordToStudent map = new MapStudentRecordToStudent();

    public StudentService(StudentRecordRepository studentRecordRepository) {
        this.studentRecordRepository = studentRecordRepository;
    }

    public Student addStudent(AddStudent request) {
        if (isStudentPresent(request)) {
            throw new IllegalStateException();
        }
        StudentRecord studentRecord = new StudentRecord();
        studentRecord.setDescription(request.getDescription());
        studentRecord.setEmail(request.getEmail());
        studentRecord.setGitHub(request.getGitHub());
        studentRecord.setImage(request.getImage());
        studentRecord.setLinkedIn(request.getLinkedIn());
        studentRecord.setName(request.getName());
        studentRecord.setStatus(request.getStatus());
        studentRecord.setTelephone(request.getTelephone());
        studentRecord.setGroupId(request.getGroupId());
        studentRecord = studentRecordRepository.save(studentRecord);
        return map.apply(studentRecord);
    }

    public List<Student> findAllStudents() {
        return studentRecordRepository.findAll()
                .stream()
                .map(map)
                .collect(Collectors.toList());
    }

    public Student findStudentById(Long id) {
        return studentRecordRepository
                .findById(id)
                .map(map)
                .orElse(null);
    }

    public void deleteById(long id) {

        studentRecordRepository.deleteById(id);
    }

    public List<Student> findStudentsInGroup(long groupsId) {
        return studentRecordRepository.findStudentsByGroupId(groupsId).stream().map(map).collect(Collectors.toList());
    }

    private boolean isStudentPresent(AddStudent request) {
        return studentRecordRepository.isStudentPresent(request.getEmail());
    }
}
