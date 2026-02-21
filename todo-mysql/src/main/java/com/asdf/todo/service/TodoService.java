package com.asdf.todo.service;

import com.asdf.todo.dto.Todo;
import com.asdf.todo.repository.TodoInMemoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private final TodoInMemoryRepository todoRepository;

    @Autowired
    public TodoService(TodoInMemoryRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Todo findByID(Long id) {
        return todoRepository.findByID(id);
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo update(Long id, Todo todo) {
        todo.setId(id);
        return todoRepository.save(todo);
    }

    public void delete(Long id) {
        todoRepository.deleteByID(id);
    }
}
