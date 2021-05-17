package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Todo;
import com.example.demo.service.TodoService;

@Controller
@RequestMapping("/todos")
public class TodoController {

	
	@Autowired
	private TodoService todoService;
	
	@GetMapping("")
	public String top(Model model) {
		model.addAttribute("todo",todoService.selectAll());
		return "todos/top";
	}
	
	@GetMapping("new")
	public String newTodo(Model model,@ModelAttribute Todo todo) {
		return "todos/new";
	}
	
	@PostMapping("new")
	public String create(@Validated @ModelAttribute Todo todo,BindingResult result) {
		
		if(result.hasErrors()) {
			return "todos/new";
		}
		todoService.insert(todo);
		return "redirect:/todos";
	}
	@GetMapping("{id}")
	public String show(@PathVariable Long id,Model model) {
		model.addAttribute("todo",todoService.selectOne(id));
		return "todos/change";
	}
	@GetMapping("{id}/change")
	public String change(@PathVariable Long id,Model model) {
		model.addAttribute("todo",todoService.selectOne(id));
		return "todos/change";
	}
		
	
	
	@PutMapping("put/{id}")
	public String update(Todo todo) {
		todoService.update(todo);
		return "redirect:/todos";
	}
	@DeleteMapping("{id}/delete")
		public String dast(@PathVariable Long id) {
			todoService.delete(id);
			return "redirect:/todos";
		
	}
}
