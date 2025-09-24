package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todos")
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	String username;
	Boolean isCompleted;
	String dateOfBirth;

	public Todo() {
	}

	public Todo(String username, Boolean isCompleted, String dateOfBirth) {
		this.username = username;
		this.isCompleted = isCompleted;
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", isCompleted=" + isCompleted + ", dateOfBirth="
				+ dateOfBirth + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(long i) {
		this.id = i;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
