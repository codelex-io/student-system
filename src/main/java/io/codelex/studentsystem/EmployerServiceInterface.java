package io.codelex.studentsystem;

import io.codelex.studentsystem.api.Employer;
import io.codelex.studentsystem.api.requests.AddEmployer;

public interface EmployerServiceInterface {
    Employer addEmployer(AddEmployer request);

    boolean isEmployerPresent(AddEmployer request);

    Employer findEmployerById(long id);

    void deleteById(long id);
}
