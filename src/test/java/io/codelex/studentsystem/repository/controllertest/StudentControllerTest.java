package io.codelex.studentsystem.repository.controllertest;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.codelex.studentsystem.StudentController;
import io.codelex.studentsystem.api.requests.AddStudent;
import io.codelex.studentsystem.service.StudentService;
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
@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService service;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Test
    void should_add_student_and_give_200_response() throws Exception {
        //given
        AddStudent request = addStudentRequest();
        String json = MAPPER.writeValueAsString(request);
        //expected
        mockMvc.perform(
                put("/internal-api/students")
                        .content(json)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk()
                );
    }

    @Test
    void should_not_add_student_and_give_400_response_if_fields_null() throws Exception {
        //given
        AddStudent request = new AddStudent("Bob",
                "ImgURL.COM",
                "linkedin.com",
                "github.com",
                null,
                "janis@janis.lv",
                "really long description",
                "failed",
                1L);
        String json = MAPPER.writeValueAsString(request);
        //expected
        mockMvc.perform(
                put("/internal-api/students")
                        .content(json)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest()
                );
    }

    @Test
    void should_not_add_student_and_give_400_response_if_contains_empty_field() throws Exception {
        //given
        AddStudent request = new AddStudent("Bob",
                "ImgURL.COM",
                "",
                "github.com",
                "123123123",
                "janis@janis.lv",
                "really long description",
                "failed",
                1L);
        String json = MAPPER.writeValueAsString(request);
        //expected
        mockMvc.perform(
                put("/internal-api/students")
                        .content(json)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest()
                );
    }

    @Test
    void should_not_find_student_if_no_such_id_and_give_400_response() throws Exception {
        //given
        AddStudent request = addStudentRequest();
        String json = MAPPER.writeValueAsString(request);
        //expected
        mockMvc.perform(
                get("/internal-api/students/222")
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
        AddStudent request = addStudentRequest();
        String json = MAPPER.writeValueAsString(request);
        //expected
        mockMvc.perform(
                delete("/internal-api/students/1")
                        .content(json)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest()
                );
    }

    @NotNull
    private AddStudent addStudentRequest() {
        return new AddStudent("Bob",
                "ImgURL.COM",
                "linkedin.com",
                "github.com",
                "123123123",
                "janis@janis.lv",
                "really long description",
                "failed",
                1L);
    }
}