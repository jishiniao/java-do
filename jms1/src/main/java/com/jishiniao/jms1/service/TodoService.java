package com.jishiniao.jms1.service;

import com.jishiniao.jms1.entity.Todo;
import com.jishiniao.jms1.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Transactional
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Transactional
    public void deleteById(String id) {
        todoRepository.deleteById(UUID.fromString(id));
    }

    public int updateStatusById(String status, String id) {
        return todoRepository.updateStatusById(status, UUID.fromString(id));
    }

    public int updateNameById(String name, String id) {
        return todoRepository.updateNameById(name, UUID.fromString(id));
    }

    @Transactional(readOnly = true)
    public List<Todo> getAllByUserId(Long userId) {
        return todoRepository.findByUserId(userId);
    }
}
