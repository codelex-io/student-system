package io.codelex.studentsystem.repository.controllertest;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.codelex.studentsystem.InstructorController;
import io.codelex.studentsystem.api.requests.AddInstructor;
import io.codelex.studentsystem.service.InstructorService;
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
@WebMvcTest(InstructorController.class)
class InstructorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InstructorService service;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Test
    void should_add_instructor_and_give_200_response() throws Exception {
        //given
        AddInstructor request = addInstructorRequest();
        String json = MAPPER.writeValueAsString(request);
        //expected
        mockMvc.perform(
                put("/internal-api/instructors")
                        .content(json)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk()
                );
    }

    @Test
    void should_not_add_instructor_and_give_400_response_if_fields_null() throws Exception {
        //given
        AddInstructor request = new AddInstructor("Instructor",
                null,
                "github.com",
                "123123123",
                "janis@janis.eu"
        );
        String json = MAPPER.writeValueAsString(request);
        //expected
        mockMvc.perform(
                put("/internal-api/instructors")
                        .content(json)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest()
                );
    }

    @Test
    void should_not_add_instructor_and_give_400_response_if_contains_empty_field() throws Exception {
        //given
        AddInstructor request = new AddInstructor("Instructor",
                "linkedin.com",
                "github.com",
                "",
                "janis@janis.eu"
        );
        String json = MAPPER.writeValueAsString(request);
        //expected
        mockMvc.perform(
                put("/internal-api/instructors")
                        .content(json)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest()
                );
    }

    @Test
    void should_not_find_instructor_by_id_if_no_such_id_and_give_400_response() throws Exception {
        //given
        AddInstructor request = addInstructorRequest();
        String json = MAPPER.writeValueAsString(request);
        //expected
        mockMvc.perform(
                get("/internal-api/instructors/222")
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
        AddInstructor request = addInstructorRequest();
        String json = MAPPER.writeValueAsString(request);
        //expected
        mockMvc.perform(
                delete("/internal-api/instructors/111")
                        .content(json)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest()
                );
    }

    @NotNull
    private AddInstructor addInstructorRequest() {
        return new AddInstructor("Instructor",
                "linkedin.com",
                "github.com",
                "123123123",
                "janis@janis.eu"
        );
    }
}