package io.codelex.studentsystem.inMemory;

import io.codelex.studentsystem.StudentSystemService;
import io.codelex.studentsystem.api.Instructor;
import io.codelex.studentsystem.api.requests.AddInstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Component
@ConditionalOnProperty(prefix = "student_system", name = "store-type", havingValue = "in-memory")
public class InMemoryStudentSystemService implements StudentSystemService {
    private final List<Instructor> instructors = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(0L);

    @Override
    public synchronized Instructor addInstructor(AddInstructor request) {

        Instructor instructor = new Instructor(
                sequence.incrementAndGet(),
                request.getName(),
                request.getLinkedinLink(),
                request.getGithubLink(),
                request.getPhone(),
                request.getEmail(),
                true);
        instructors.add(instructor);
        return instructor;
    }

    @Override
    public synchronized void clear() {
        instructors.clear();
    }
}
