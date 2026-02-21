package com.asdf.todo.repository;

import com.asdf.todo.dto.Todo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;

@Repository
public class TodoInMemoryRepository {
    private final Map<Long, Todo> todoMap = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    public List<Todo> findAll() {
        return new ArrayList<>(todoMap.values());
    }

    public Todo findByID(Long id) {
        return todoMap.get(id);
    }

    public Todo save(Todo todo) {
        if (todo.getId() == null) {
            todo.setId(counter.incrementAndGet());
        }
        todoMap.put(todo.getId(), todo);
        return todo;
    }

    public void deleteByID(Long id) {
        todoMap.remove(id);
    }
}
