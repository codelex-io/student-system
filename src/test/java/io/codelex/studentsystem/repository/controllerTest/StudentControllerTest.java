package io.codelex.studentsystem.repository.controllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.codelex.studentsystem.StudentController;
import io.codelex.studentsystem.api.requests.AddStudent;
import io.codelex.studentsystem.repository.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
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

    static {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addDeserializer(
                LocalDateTime.class,
                new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
        );
        javaTimeModule.addDeserializer(
                LocalDate.class,
                new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        );
        javaTimeModule.addSerializer(
                LocalDateTime.class,
                new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
        );
        javaTimeModule.addSerializer(
                LocalDate.class,
                new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        );
        builder.modules(javaTimeModule);
        builder.featuresToDisable(WRITE_DATES_AS_TIMESTAMPS);
        MAPPER.registerModule(javaTimeModule);
    }

    @Test
    void should_add_student_and_give_200_response() throws Exception {
        //given
        AddStudent request = new AddStudent("Bob",
                "ImgURL.COM",
                "linkedin.com",
                "github.com",
                "123123123",
                "janis@janis.lv",
                "really long description",
                "failed"
        );
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
                "failed"
        );
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
                "failed"
        );
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
    void should_find_student_by_id_and_give_200_response() throws Exception {
        //given
        AddStudent request = new AddStudent("Bob",
                "ImgURL.COM",
                "linkedin.com",
                "github.com",
                "123123123",
                "janis@janis.lv",
                "really long description",
                "failed"
        );
        String json = MAPPER.writeValueAsString(request);
        //expected
        mockMvc.perform(
                get("/internal-api/students/1")
                        .content(json)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk()
                );
    }

    @Test
    void should_not_find_student_by_id_if_no_such_id_and_give_400_response() throws Exception {
        //given
        AddStudent request = new AddStudent("Bob",
                "ImgURL.COM",
                "linkedin.com",
                "github.com",
                "123123123",
                "janis@janis.lv",
                "really long description",
                "failed"
        );
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
    void should_delete_by_id_and_return_200_response() throws Exception {
        //given
        AddStudent request = new AddStudent("Bob",
                "ImgURL.COM",
                "linkedin.com",
                "github.com",
                "123123123",
                "janis@janis.lv",
                "really long description",
                "failed"
        );
        String json = MAPPER.writeValueAsString(request);
        //expected
        mockMvc.perform(
                delete("/internal-api/students/1")
                        .content(json)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk()
                );
    }

    @Test
    void should_return_400_response_if_no_such_id_to_delete() throws Exception {
        //given
        AddStudent request = new AddStudent("Bob",
                "ImgURL.COM",
                "linkedin.com",
                "github.com",
                "123123123",
                "janis@janis.lv",
                "really long description",
                "failed"
        );
        String json = MAPPER.writeValueAsString(request);
        //expected
        mockMvc.perform(
                delete("/internal-api/students/111")
                        .content(json)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest()
                );
    }
}