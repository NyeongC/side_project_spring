package com.ccn.springbootdeveloper.domain.todo;

import com.ccn.springbootdeveloper.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "todos")
public class Todo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private boolean completed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Todo(String content, User user) {
        this.content = content;
        this.user = user;
        this.completed = false;
    }

    public void toggle() {
        this.completed = !this.completed;
    }
}