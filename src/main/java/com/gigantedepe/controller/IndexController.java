package com.gigantedepe.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gigantedepe.enums.EstadosEnum;
import com.gigantedepe.model.Cidade;
import com.gigantedepe.repository.CidadeRepository;

@Controller
public class IndexController {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	private Cidade cidade = null;

	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("cidades", cidadeRepository.findAll());
		return "inicio";
	}
	
	@GetMapping("/cadastrar-cidade")
	public String cadastrar(Model model) {
		
		model.addAttribute("cidade", cidade != null ? cidade : new Cidade());
		model.addAttribute("cidades", cidadeRepository.findAll());
		model.addAttribute("estados", EstadosEnum.values());
		return "cadastro";
	}
	
	@PostMapping("/cadastrar-cidade")
	public String salvar(@ModelAttribute Cidade cidade, Model model) {
		cidadeRepository.saveAndFlush(cidade);
		this.cidade = null;
		return "redirect:/cadastrar-cidade";
	}
	
	@GetMapping("/cadastrar-cidade/{id}/deletar")
	public String excluir(@PathVariable Long id, Model model) {
		cidadeRepository.deleteById(id);
		return "redirect:/cadastrar-cidade";
	}
	
	@GetMapping("/cadastrar-cidade/{id}/editar")
	public String editar(@PathVariable Long id, Model model) {
		this.cidade = cidadeRepository.getOne(id);
		return "redirect:/cadastrar-cidade";
	}
	
	@GetMapping("/teste")
	@ResponseBody
	public String teste() {
		return "teste";
	}
}
