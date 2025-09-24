package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.entity.Todo;

public interface TodoService {
	Todo handleCreateTodo(Todo td);

	List<Todo> handleGetAllTodo();

	Todo handleUpdateTodo(Todo td);

	void handleDeleteTodo();

	Todo handleFindByIdTodo(Long id);

	Todo createTodo(Todo td);

	Todo updateTodo(Long id, Todo td);

	void deleteTodo(Long id);
}
