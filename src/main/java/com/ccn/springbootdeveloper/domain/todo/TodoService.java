package com.ccn.springbootdeveloper.domain.todo;

import com.ccn.springbootdeveloper.domain.todo.dto.TodoRequest;
import com.ccn.springbootdeveloper.domain.user.User;
import com.ccn.springbootdeveloper.domain.user.UserRepository;
import com.ccn.springbootdeveloper.exception.TodoNotFoundException;
import com.ccn.springbootdeveloper.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public void addTodo(TodoRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(UserNotFoundException::new);

        Todo todo = new Todo(request.getContent(), user);

        todoRepository.save(todo);
    }

    public List<Todo> getTodos(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow();

        return todoRepository.findByUser(user);
    }

    public void addTodo(User user, TodoRequest request) {
        Todo todo = new Todo(request.getContent(), user);
        todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    public void toggleTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(TodoNotFoundException::new);

        todo.toggle();
    }
}