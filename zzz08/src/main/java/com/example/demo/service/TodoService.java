package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Todo;
import com.example.demo.mapper.TodoMapper;

@Service
public class TodoService {

	@Autowired
	private TodoMapper todoMapper;
	
	@Transactional
	public List<Todo> selectAll(){
		return todoMapper.selectAll();
	}
	
	@Transactional
	public Todo selectOne(Long id) {
		return todoMapper.selectOne(id);
	}
	
	@Transactional
	public void insert(Todo todo) {
		todoMapper.insert(todo);
	}
	
	@Transactional
	public int update(Todo todo) {
		return todoMapper.update(todo);
	}
	
	@Transactional
	public void delete(Long id) {
		todoMapper.delete(id);
	}
}
