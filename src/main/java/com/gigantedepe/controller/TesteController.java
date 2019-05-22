package com.gigantedepe.controller;

import java.util.ArrayList;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gigantedepe.model.Child;
import com.gigantedepe.model.Parent;

@Controller
public class TesteController {
	
	private Parent parent = new Parent();
	private Child child = new Child();
	
	@GetMapping("/child")
	public String index(Model model) {
//		child.setParent(parent);
		//parent.getChilds().add(0, child);
		model.addAttribute("parent", parent);
		model.addAttribute("child", child);
		return "teste-child";
	}
	
	@PostMapping("/child2")
	public String child2(final Parent _parent, Model model) {
		this.parent.setName(_parent.getName());
		_parent.getChilds().get(0).setParent(this.parent);
		this.parent.getChilds().get(0).setParent(this.parent);
//		this.parent.getChilds().add(0, new Child());
		this.parent.getChilds().addAll(_parent.getChilds());
		
		return "redirect:/child";
	}
	
	@PostMapping("/child1")
	public String child1(final Child _child, Model model) {
		this.parent.addChild(_child);
		return "redirect:/child";
	}

}
