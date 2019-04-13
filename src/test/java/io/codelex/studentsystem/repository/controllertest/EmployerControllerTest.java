package io.codelex.studentsystem.repository.controllertest;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.codelex.studentsystem.EmployerController;
import io.codelex.studentsystem.api.requests.AddEmployer;
import io.codelex.studentsystem.service.EmployerService;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployerController.class)
class EmployerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployerService service;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Test
    void should_add_employer_and_give_200_response() throws Exception {
        //given
        AddEmployer request = addEmployerMethod();
        String json = MAPPER.writeValueAsString(request);
        //expected
        mockMvc.perform(
                put("/internal-api/employers")
                        .content(json)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk()
                );
    }

    @Test
    void should_not_add_employer_and_give_400_if_contains_null() throws Exception {
        //given
        AddEmployer request = new AddEmployer("Big Company",
                null,
                "292929229",
                "janis@janis.eu",
                "parole23",
                "login"
        );
        String json = MAPPER.writeValueAsString(request);
        //expected
        mockMvc.perform(
                put("/internal-api/employers")
                        .content(json)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest()
                );
    }

    @Test
    void should_not_add_employer_and_give_400_if_contains_empty_field() throws Exception {
        //given
        AddEmployer request = new AddEmployer("Big Company",
                "",
                "292929229",
                "janis@janis.eu",
                "parole23",
                "login"
        );
        String json = MAPPER.writeValueAsString(request);
        //expected
        mockMvc.perform(
                put("/internal-api/employers")
                        .content(json)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest()
                );
    }

    @Test
    void should_not_find_employer_by_id_if_no_such_id_and_give_400_response() throws Exception {
        //given
        AddEmployer request = addEmployerMethod();
        String json = MAPPER.writeValueAsString(request);
        //expected
        mockMvc.perform(
                get("/internal-api/employers/222")
                        .content(json)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest()
                );
    }

    @Test
    void should_return_400_response_if_no_such_id_to_delete() throws Exception {
        //given
        AddEmployer request = addEmployerMethod();
        String json = MAPPER.writeValueAsString(request);
        //expected
        mockMvc.perform(
                delete("/internal-api/employers/111")
                        .content(json)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest()
                );
    }

    @NotNull
    private AddEmployer addEmployerMethod() {
        return new AddEmployer("Big Company",
                "BOB",
                "292929229",
                "janis@janis.eu",
                "parole23",
                "login"
        );
    }
}