package com.dio.santander.banklineapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.santander.banklineapi.dto.CorrentistaDto;
import com.dio.santander.banklineapi.model.Correntista;
import com.dio.santander.banklineapi.service.CorrentistaService;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {
	private CorrentistaService service;
	
	@Autowired
	public CorrentistaController(CorrentistaService service) {
		this.service = service;
	}

	@GetMapping("/list")
	public List<CorrentistaDto> findAll() {
		return this.service.findAll();
	}
	
	@PostMapping("/create")
	public ResponseEntity<CorrentistaDto> create(@RequestBody CorrentistaDto correntista) {
		return ResponseEntity.ok().body(this.service.create(correntista));
	}
}
