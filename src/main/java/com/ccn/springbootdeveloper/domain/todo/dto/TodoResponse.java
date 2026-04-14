package com.ccn.springbootdeveloper.domain.todo.dto;

import com.ccn.springbootdeveloper.domain.todo.Todo;
import lombok.Getter;

@Getter
public class TodoResponse {
    private final Long id;
    private final String content;
    private final boolean completed;

    public TodoResponse(Todo todo) {
        this.id = todo.getId();
        this.content = todo.getContent();
        this.completed = todo.isCompleted();
    }
}
