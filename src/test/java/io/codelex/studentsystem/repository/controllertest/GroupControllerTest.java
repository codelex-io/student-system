package io.codelex.studentsystem.repository.controllertest;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.codelex.studentsystem.GroupController;
import io.codelex.studentsystem.api.requests.AddGroup;
import io.codelex.studentsystem.service.GroupService;
import io.codelex.studentsystem.service.InstructorService;
import io.codelex.studentsystem.service.StudentService;
import io.codelex.studentsystem.service.TopicsService;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GroupController.class)
class GroupControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GroupService service;

    @MockBean
    private TopicsService topicsService;
    
    @MockBean
    private InstructorService instructorService;
    
    @MockBean
    private StudentService studentService;

    private LocalDate defaultDate = LocalDate.of(2019, 1, 1);

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Test
    void should_add_group_and_give_200_response() throws Exception {
        //given
        byte[] json = getRequest("/requests/addGroupCorrect");
        //expected
        mockMvc.perform(
                put("/internal-api/groups")
                        .content(json)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk()
                );
    }

    private byte[] getRequest(String s) throws IOException {
        File file = ResourceUtils.getFile(this.getClass().getResource(s));
        Assertions.assertTrue(file.exists());
        return Files.readAllBytes(file.toPath());
    }

    @Test
    void should_not_add_group_and_give_400_response_if_fields_null() throws Exception {
        //given
        byte[] json = getRequest("/requests/addGroupWithNull");
        //expected
        mockMvc.perform(
                put("/internal-api/groups")
                        .content(json)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest()
                );
    }

    @Test
    void should_not_add_group_and_give_400_response_if_contains_empty_field() throws Exception {
        //given
        byte[] json = getRequest("/requests/addGroupWithEmptyField");
        //expected
        mockMvc.perform(
                put("/internal-api/groups")
                        .content(json)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest()
                );
    }

    @Test
    void should_not_find_group_by_id_if_no_such_id_and_give_400_response() throws Exception {
        //given
        byte[] json = getRequest("/requests/addGroupCorrect");
        //expected
        mockMvc.perform(
                get("/internal-api/groups/222")
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
        byte[] json = getRequest("/requests/addGroupCorrect");
        //expected
        mockMvc.perform(
                delete("/internal-api/groups/1")
                        .content(json)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest()
                );
    }
}