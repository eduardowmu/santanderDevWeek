package com.dio.santander.banklineapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.santander.banklineapi.dto.MovimentacaoDto;
import com.dio.santander.banklineapi.model.Movimentacao;
import com.dio.santander.banklineapi.service.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
	private MovimentacaoService service;
	
	@Autowired
	public MovimentacaoController(MovimentacaoService service) {
		this.service = service;
	}
	
	@GetMapping("/list")
	public List<MovimentacaoDto> findAll() {
		return this.service.findAll();
	}
	
	@GetMapping("/{idConta}")
	public List<MovimentacaoDto> findByIdConta(@PathVariable("idConta") Integer idConta) {
		return this.service.findByIdConta(idConta);
	}
	
	@PostMapping("/create")
	public ResponseEntity<MovimentacaoDto> create(@RequestBody MovimentacaoDto mDto) {
		return ResponseEntity.ok(this.service.create(mDto));
	}
}
