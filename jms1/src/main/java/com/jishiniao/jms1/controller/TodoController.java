package com.jishiniao.jms1.controller;

import com.jishiniao.jms1.entity.Todo;
import com.jishiniao.jms1.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/u/{userId}")
    public List<Todo> getAllByUserId(@PathVariable Long userId) {
        return todoService.getAllByUserId(userId);
    }

    @PostMapping
    public Todo CreateTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @PutMapping
    public int updateTodo(@RequestBody Map<String, Object> requestBodyMap) {
        String id = (String) requestBodyMap.get("id");

        String name = (String) requestBodyMap.get("name");
        String status = (String) requestBodyMap.get("status");

        if (!name.isEmpty()) {
            return todoService.updateNameById(name, id);
        }

        return todoService.updateStatusById(status, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        todoService.deleteById(id);
    }

}
