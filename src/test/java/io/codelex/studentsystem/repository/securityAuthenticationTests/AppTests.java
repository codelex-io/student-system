package io.codelex.studentsystem.repository.securityAuthenticationTests;

import io.codelex.studentsystem.service.EmployerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest //todo not needed
public class AppTests {
    @MockBean
    EmployerService employerService;

    @Test
    public void contextLoads() {
    }

}