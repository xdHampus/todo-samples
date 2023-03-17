package com.todo.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.todo.backend.controller.api.TodoApi;
import com.todo.backend.dto.TodoItemDTO;
import com.todo.backend.dto.TodoItemUpdateDTO;
import com.todo.backend.service.map.TodoItemMapper;
import com.todo.backend.model.TodoItem;
import com.todo.backend.model.repository.TodoRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TodoControllerTest {

    @Autowired
    private TodoApi controller;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private TodoRepository repository;
    @Autowired
    private TodoItemMapper mapper;
    @Autowired
    private ObjectMapper objectMapper;
    private TodoItem todoItemHomework;


    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @BeforeEach
    void setUp(){
        repository.deleteAll();
        todoItemHomework = new TodoItem("Homework", "pom & backend apps");
        repository.save(todoItemHomework);
        repository.save(new TodoItem("Shopping", "groceries, cat food"));
       var a = repository.findAll();
    }

    @AfterEach
    void tearDown() throws JsonProcessingException {
        System.out.println("-- Test teardown --");
        for (TodoItem todoItem : repository.findAll()) {
            System.out.println(objectMapper.writeValueAsString(mapper.mapDto(todoItem)));
        }
        System.out.println();
    }

    @Test
    void getAll() throws Exception {
        this.mockMvc.perform(get("/todo/all")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(content().string(containsString("Homework")))
                .andExpect(content().string(containsString("Shopping")));
    }


    @Test
    void getTodoItem() throws Exception {
        this.mockMvc.perform(get("/todo/"+todoItemHomework.getId())).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Homework")));
    }
    @Test
    void getTodoItemFailItemNotFound() throws Exception {
        this.mockMvc.perform(get("/todo/"+Integer.MAX_VALUE)).andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void add() throws Exception {
        TodoItemDTO newItem = new TodoItemDTO("Testing", "unit tests, integrations tests");

        this.mockMvc.perform(post("/todo")
                        .content(objectMapper.writeValueAsString(newItem))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Testing")));

    }

    @Test
    void update() throws Exception {
        var updateDTO = mapper.mapUpdateDto(todoItemHomework);
        updateDTO = new TodoItemUpdateDTO(
                updateDTO.id(),
                updateDTO.title(),
                "pom & django backend app"
        );
        this.mockMvc.perform(put("/todo")
                        .content(objectMapper.writeValueAsString(updateDTO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Homework")))
                .andExpect(content().string(containsString("pom & django backend app")));

    }

    @Test
    void deleteById() throws Exception {
        this.mockMvc.perform(delete("/todo/"+todoItemHomework.getId())).andDo(print())
                .andExpect(status().isOk());
        this.mockMvc.perform(get("/todo/"+todoItemHomework.getId())).andDo(print())
                .andExpect(status().isNotFound());
    }
}