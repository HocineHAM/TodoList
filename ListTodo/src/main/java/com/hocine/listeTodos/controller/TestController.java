package com.hocine.listeTodos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hocine.listeTodos.Entity.ListeTodos;
import com.hocine.listeTodos.service.ICrudService;

@Controller
public class TestController {
	
	@Autowired
	ICrudService<ListeTodos, Long> service;
	
	

	@RequestMapping("/")
	public String home(Model model) {
		List<ListeTodos> list = service.getAll();
		model.addAttribute("listetodos", list);
		return "index";
	}

	@GetMapping("/signup")
    public String showSignUpForm(Model model) {
		model.addAttribute("todo", new ListeTodos());
        return "add-todos";
        
        
    }
     
    @PostMapping("/addtodo")
    public String addTodo(@Valid @ModelAttribute("todo") ListeTodos todo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-todos";
        }
         
        service.add(todo);
        model.addAttribute("listetodos", service.getAll());
        return "index";
    }
    
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        ListeTodos todo = service.findbyid(id);
        //.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
         
        model.addAttribute("todo", todo);
        return "update-todos";
    }
    @PostMapping("/update/{id}")
    public String updateTodo(@PathVariable("id") long id, @Valid @ModelAttribute("todo") ListeTodos todo, 
      BindingResult result, Model model) {
        if (result.hasErrors()) {
            todo.setId(id);
            return "update-todos";
        }
             
        service.update(todo);
        model.addAttribute("listetodos", service.getAll());
        return "index";
    }
	
    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable("id") long id, Model model) {
        ListeTodos todo = service.findbyid(id)
        		;//.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        service.delete(todo);
        model.addAttribute("listetodos", service.getAll());
        return "index";
    }

	
	

}
