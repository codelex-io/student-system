package io.codelex.studentsystem.repository.controllertest;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.codelex.studentsystem.GroupController;
import io.codelex.studentsystem.api.requests.AddGroup;
import io.codelex.studentsystem.service.GroupService;
import io.codelex.studentsystem.service.InstructorService;
import io.codelex.studentsystem.service.StudentService;
import io.codelex.studentsystem.service.TopicsService;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

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
        AddGroup request = new AddGroup("Group",
                defaultDate,
                defaultDate.plusDays(1),
                defaultDate.plusDays(2)
        );
        String json = MAPPER.writeValueAsString(request);
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

    @Test
    void should_not_add_group_and_give_400_response_if_fields_null() throws Exception {
        //given
        AddGroup request = new AddGroup("Group",
                null,
                defaultDate.plusDays(1),
                defaultDate.plusDays(2)
        );
        String json = MAPPER.writeValueAsString(request);
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
        AddGroup request = new AddGroup("",
                defaultDate,
                defaultDate.plusDays(1),
                defaultDate.plusDays(2)
        );
        String json = MAPPER.writeValueAsString(request);
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
        AddGroup request = addGroupRequest();
        String json = MAPPER.writeValueAsString(request);
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
        AddGroup request = addGroupRequest();
        String json = MAPPER.writeValueAsString(request);
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

    @NotNull
    private AddGroup addGroupRequest() {
        return new AddGroup("group",
                defaultDate,
                defaultDate.plusDays(1),
                defaultDate.plusDays(2)
        );
    }
}