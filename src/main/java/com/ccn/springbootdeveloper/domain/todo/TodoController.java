package com.ccn.springbootdeveloper.domain.todo;

import com.ccn.springbootdeveloper.domain.todo.dto.TodoRequest;
import com.ccn.springbootdeveloper.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public void add(@RequestBody TodoRequest request) {
        todoService.addTodo(request);
    }

    @GetMapping("/{userId}")
    public List<Todo> get(@PathVariable Long userId) {
        return todoService.getTodos(userId);
    }

    // 🔹 삭제 (기존 유지)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }

    // 🔥 토글 (이거 살아야 맞다)
    @PatchMapping("/{id}/toggle")
    public void toggle(@PathVariable Long id) {
        todoService.toggleTodo(id);
    }
}