package com.ccn.springbootdeveloper.domain.todo;

import com.ccn.springbootdeveloper.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByUser(User user);
}