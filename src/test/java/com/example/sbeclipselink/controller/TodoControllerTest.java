package com.example.sbeclipselink.controller;

import com.example.sbeclipselink.TestcontainersConfiguration;
import com.example.sbeclipselink.model.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllTodos() throws Exception {
        // Perform request and verify response
        mockMvc.perform(get("/api/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].title", is("Task 1")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].title", is("Task 2")));
    }

    @Test
    public void testGetTodoById() throws Exception {
        // Perform request and verify response
        mockMvc.perform(get("/api/todos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Task 1")))
                .andExpect(jsonPath("$.description", is("Description 1")));
    }

    @Test
    public void testCreateTodo() throws Exception {
        // Prepare test data
        Todo todoToCreate = new Todo("New Task", "New Description");

        // Perform request and verify response
        mockMvc.perform(post("/api/todos")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"New Task\",\"description\":\"New Description\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title", is("New Task")))
                .andExpect(jsonPath("$.description", is("New Description")));
    }

    @Test
    public void testUpdateTodo() throws Exception {
        // Perform request and verify response
        mockMvc.perform(put("/api/todos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"Updated Task\",\"description\":\"Updated Description\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Updated Task")))
                .andExpect(jsonPath("$.description", is("Updated Description")));
    }

    @Test
    public void testDeleteTodo() throws Exception {
        // Perform request and verify response
        mockMvc.perform(delete("/api/todos/1"))
                .andExpect(status().isNoContent());
    }
}
