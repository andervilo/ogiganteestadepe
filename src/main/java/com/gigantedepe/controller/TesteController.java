package com.gigantedepe.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gigantedepe.model.Child;
import com.gigantedepe.model.Parent;
import com.gigantedepe.repository.ChildRepository;
import com.gigantedepe.repository.ParentRepository;

@Controller
public class TesteController {
	
	@Autowired
	private ParentRepository parentRepository;
	
	@Autowired
	private ChildRepository childRepository;
	
	private Parent parent = new Parent();
	private Child child = new Child();
	
	@GetMapping("/child")
	public String index(Model model) {
		model.addAttribute("parent", parent);
		model.addAttribute("child", child);
		return "teste-child";
	}
	
	@PostMapping(value="/child", params= {"addChild"})
	public String addChild(final Parent _parent, Model model) {
		this.parent.setName(_parent.getName());
		this.parent.addChild(_parent.getChilds().get(0));
		//_parent.getChilds().get(0).setParent(this.parent);
//		this.parent.getChilds().get(0).setParent(this.parent);
//		this.parent.getChilds().addAll(_parent.getChilds());
		
		return "redirect:/child";
	}
	
	@PostMapping(value="/child", params= {"removeChild"})
	public String removeChild(final Parent _parent, Model model, final HttpServletRequest req) {
		final Integer rowId = Integer.valueOf(req.getParameterMap().get("removeChild")[0]);		
		this.parent.getChilds().remove(rowId.intValue());
		return "redirect:/child";
	}
	
	@PostMapping(value="/child", params= {"saveParent"})
	public String savePrarent(@ModelAttribute Parent _parent, Model model) {
		this.parent.getChilds().remove(0);
		parentRepository.save(this.parent);
		//childRepository.saveAll(this.parent.getChilds());
		return "redirect:/child";
	}

}
