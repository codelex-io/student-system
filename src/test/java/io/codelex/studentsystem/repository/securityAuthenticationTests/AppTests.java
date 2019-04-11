package io.codelex.studentsystem.repository.securityAuthenticationTests;

import io.codelex.studentsystem.repository.service.EmployerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTests {
    @MockBean
    EmployerService employerService;
    @Test
    public void contextLoads() {
    }

}