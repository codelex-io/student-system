package io.codelex.studentsystem;

import io.codelex.studentsystem.api.Instructor;
import io.codelex.studentsystem.api.requests.AddInstructor;

public interface StudentSystemService {

    Instructor addInstructor(AddInstructor request);

    void clear();

    Instructor findInstructorById(long id);
}

