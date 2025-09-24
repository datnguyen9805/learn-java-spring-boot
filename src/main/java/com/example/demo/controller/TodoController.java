package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ApiResponse;
import com.example.demo.entity.Todo;
import com.example.demo.service.impl.TodoServiceImpl;

@RestController
public class TodoController {
	private final TodoServiceImpl todoService;

	public TodoController(TodoServiceImpl todoService) {
		this.todoService = todoService;
	}

	@GetMapping("/todos/{id}")
//	@ResponseBody
	public ResponseEntity getTodoById(@PathVariable Long id) {
		Todo td1 = this.todoService.handleFindByIdTodo(id);
		return ResponseEntity.ok().body(td1);
	}

	@GetMapping("/create-todo")
	public String create() {
		Todo todo1 = new Todo("trang", true, "01021998");
		Todo newTodo = this.todoService.handleCreateTodo(todo1);
		return "Create Todo" + newTodo.getId();
	}

	@GetMapping("/todos")
	public ResponseEntity<List<Todo>> getAll() {
		List<Todo> td1 = this.todoService.handleGetAllTodo();
		return ResponseEntity.ok().body(td1);
	}

	@GetMapping("/update-todo")
	public String update() {
		Todo td1 = new Todo("dat99", false, "update-11051998");
		td1.setId(1);
		Todo td = this.todoService.handleUpdateTodo(td1);
		return td.toString();
	}

	@GetMapping("/delete-todo")
	public void delete() {
		this.todoService.handleDeleteTodo();
	}

	@GetMapping("/datnv")
	public ResponseEntity<String> getDetail() {
		return ResponseEntity.internalServerError().body("Internal Server");
	}

	@PostMapping("/todos")
	public ResponseEntity<ApiResponse<Todo>> createTD(@RequestBody Todo input) {
		Todo td1 = this.todoService.createTodo(input);
		ApiResponse<Todo> result = new ApiResponse<Todo>(HttpStatus.OK, "Success", td1, null);
		// cách viết khác: var result = new ApiResponse<Todo>(HttpStatus.OK,
		// "Success", td1, null);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@PutMapping("/todos/{id}")
//	@ResponseBody
	public ResponseEntity updateTodo(@PathVariable Long id, @RequestBody Todo input) {
		Todo td1 = this.todoService.updateTodo(id, input);
		return ResponseEntity.ok().body(td1);
	}

	@DeleteMapping("/todos/{id}")
	public ResponseEntity<String> deleteTD(@PathVariable Long id) {
		this.todoService.deleteTodo(id);
		return ResponseEntity.ok().body("delete success");
	}
}
