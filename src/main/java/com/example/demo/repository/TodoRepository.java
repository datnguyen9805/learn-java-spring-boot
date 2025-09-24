package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Todo;

@Repository
// JpaRepository<Todo, Long>: Todo: thao tác với đối tượng gì, Long: kiểu dữ liệu của khóa chính ( check phần Entity)
public interface TodoRepository extends JpaRepository<Todo, Long> {
	Optional<Todo> findByUsername(String username);
}
