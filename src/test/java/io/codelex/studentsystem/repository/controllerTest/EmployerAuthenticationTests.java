package io.codelex.studentsystem.repository.controllerTest; //todo package names

import com.fasterxml.jackson.databind.ObjectMapper;
import io.codelex.studentsystem.api.requests.AddEmployer;
import io.codelex.studentsystem.authentication.AuthenticationService;
import io.codelex.studentsystem.authentication.EmployerAuthenticationController;
import io.codelex.studentsystem.repository.service.EmployerService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployerAuthenticationController.class)
class EmployerAuthenticationTests {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AuthenticationService authService;
    @MockBean
    private EmployerService employerService;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Test
    void should_register_employer_and_give_201_response() throws Exception {
        //given
        AddEmployer request = setEmployer();
        String json = MAPPER.writeValueAsString(request);
        //expected
        mockMvc.perform(
                put("/api/register")
                        .content(json)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated()
                );
    }

    @Test
    void should_not_be_able_to_register_employer_with_empty_fields() throws Exception {
        //given
        AddEmployer request = setEmployer();
        String json = MAPPER.writeValueAsString(request);
        //expected
        mockMvc.perform(
                put("/api/register")
                        .content(json)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated()
                );
    }


    private AddEmployer setEmployer() {
        return new AddEmployer("Big Company",
                "BOB",
                "292929229",
                "janis@janis.eu",
                "parole23",
                "login22"
        );
    }

    private AddEmployer setEmployerWithNull() {
        return new AddEmployer("Big Company",
                "BOB",
                null,
                "janis@janis.eu",
                "parole23",
                "login22"
        );
    }
}
