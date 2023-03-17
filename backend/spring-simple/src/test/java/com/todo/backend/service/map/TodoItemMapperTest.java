package com.todo.backend.service.map;

import com.todo.backend.model.TodoItem;
import com.todo.backend.service.map.TodoItemMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Clock;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@SpringBootTest
class TodoItemMapperTest {

    @Autowired
    private TodoItemMapper mapper;

    private TodoItem todoItem;
    @BeforeEach
    void setUp(){
        todoItem = new TodoItem();
        todoItem.setId(1);
        todoItem.setTitle("Todo");
        todoItem.setDescription("Description");
        todoItem.setCreatedAt(ZonedDateTime.now(Clock.systemUTC()));
        todoItem.setEditedAt(ZonedDateTime.now(Clock.systemUTC()));
    }

    @Test
    void mapDto() {
        var dto = mapper.mapDto(todoItem);
        assertAll(
                "Verify properties",
                () -> assertEquals(todoItem.getId(), dto.id()),
                () -> assertEquals(todoItem.getTitle(), dto.title()),
                () -> assertEquals(todoItem.getDescription(), dto.description()),
                () -> assertEquals(todoItem.getCreatedAt(), dto.createdAt()),
                () -> assertEquals(todoItem.getEditedAt(), dto.editedAt())
        );
    }

    @Test
    void map_TodoItemDTO() {
        var dto = mapper.mapDto(todoItem);
        var mapped = mapper.map(dto);
        assertAll(
                "Verify properties",
                () -> assertEquals(todoItem.getId(), mapped.getId()),
                () -> assertEquals(todoItem.getTitle(), mapped.getTitle()),
                () -> assertEquals(todoItem.getDescription(), mapped.getDescription()),
                () -> assertEquals(todoItem.getCreatedAt(), mapped.getCreatedAt()),
                () -> assertEquals(todoItem.getEditedAt(), mapped.getEditedAt())
        );
    }

    @Test
    void mapCreateDto() {
        var dto = mapper.mapCreateDto(todoItem);
        assertAll(
                "Verify properties",
                () -> assertEquals(todoItem.getTitle(), dto.title()),
                () -> assertEquals(todoItem.getDescription(), dto.description())
        );
    }

    @Test
    void map_TodoItemCreateDTO() {
        var dto = mapper.mapCreateDto(todoItem);
        var mapped = mapper.map(dto);
        assertAll(
                "Verify properties",
                () -> assertEquals(0, mapped.getId()),
                () -> assertEquals(todoItem.getTitle(), mapped.getTitle()),
                () -> assertEquals(todoItem.getDescription(), mapped.getDescription())
        );
    }

    @Test
    void mapUpdateDto() {
        var dto = mapper.mapUpdateDto(todoItem);
        assertAll(
                "Verify properties",
                () -> assertEquals(todoItem.getId(), dto.id()),
                () -> assertEquals(todoItem.getTitle(), dto.title()),
                () -> assertEquals(todoItem.getDescription(), dto.description())
        );
    }

    @Test
    void map_TodoItemUpdateDTO() {
        var dto = mapper.mapUpdateDto(todoItem);
        var mapped = mapper.map(dto);
        assertAll(
                "Verify properties",
                () -> assertEquals(todoItem.getId(), dto.id()),
                () -> assertEquals(todoItem.getTitle(), mapped.getTitle()),
                () -> assertEquals(todoItem.getDescription(), mapped.getDescription())
        );
    }
}