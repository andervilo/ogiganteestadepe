package com.gigantedepe.controller.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gigantedepe.enums.EstadosEnum;
import com.gigantedepe.model.Cidade;
import com.gigantedepe.repository.CidadeRepository;

@RestController
@RequestMapping("/api")
public class CidadeResource {
	
	@Autowired
	private CidadeRepository cidadeRepository;

	@GetMapping("/cidades")
	public ResponseEntity<?> getList(){
		return ResponseEntity.ok().body(cidadeRepository.findAll());
	}
	
	@GetMapping("/estados")
	private ResponseEntity<?> getEstsadosList(){
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<Map<Object, Object>> selectObject = new ArrayList<Map<Object,Object>>();
		
		for(EstadosEnum e : EstadosEnum.values()) {
			Map<Object, Object> object = new HashMap<Object, Object>();
			object.put("value", e.name());
			object.put("label", e.getNome());
			selectObject.add(object);
		}
		
		map.put("results", selectObject);
		return ResponseEntity.ok().body(selectObject);
	}
	
	@PostMapping("/cidades")
	public ResponseEntity<?> addCidade(@RequestBody Cidade cidade){
		try {
			cidadeRepository.saveAndFlush(cidade);
			return ResponseEntity.ok().body(true);
		} catch (Exception e) {
			e.getMessage();
		}
		return ResponseEntity.ok().body(false);
	}
	
}
