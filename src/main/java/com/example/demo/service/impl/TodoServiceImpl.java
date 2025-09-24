package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {
	private final TodoRepository todoRepository;

	public TodoServiceImpl(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public Todo handleCreateTodo(Todo td) {
		Todo td1 = this.todoRepository.save(td);
		return td1;
	}

	public List<Todo> handleGetAllTodo() {
		List<Todo> td1 = this.todoRepository.findAll();
//		Optional<Todo> optionalTd = this.todoRepository.findByUsername("dat");
//		if (optionalTd.isPresent()) {
//			System.out.print(optionalTd.toString());
//		}
		return td1;
	}

	public Todo handleUpdateTodo(Todo td) {
		Optional<Todo> td1 = this.todoRepository.findById(td.getId());
		// hàm isPresent check nếu có td1 hay không
//		if(td1.isPresent()) {
//			
//		}
		Todo currentTodo = td1.get();
		currentTodo.setUserName(td.getUserName());
		currentTodo.setDateOfBirth(td.getDateOfBirth());
		currentTodo.setIsCompleted(td.getIsCompleted());
		Todo td3 = this.todoRepository.save(currentTodo);
		return td3;
	}

	public void handleDeleteTodo() {
		this.todoRepository.deleteById(1L);
	}

	public Todo handleFindByIdTodo(Long id) {
		Optional<Todo> td1 = this.todoRepository.findById(id);
		if (td1.isPresent()) {
			return td1.get();
		}
		return null;
	}

	public Todo createTodo(Todo td) {
		Todo td1 = this.todoRepository.save(td);
		return td1;
	}

	public Todo updateTodo(Long id, Todo td) {
		Optional<Todo> td1 = this.todoRepository.findById(id);
		if (td1.isPresent()) {
			Todo currentTodo = td1.get();
			currentTodo.setUserName(td.getUserName());
			currentTodo.setDateOfBirth(td.getDateOfBirth());
			currentTodo.setIsCompleted(td.getIsCompleted());
			Todo td3 = this.todoRepository.save(currentTodo);
			return td3;
		}
		return null;
	}

	public void deleteTodo(Long id) {
		this.todoRepository.deleteById(id);
	}
}
