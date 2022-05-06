package com.dio.santander.banklineapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.banklineapi.dto.CorrentistaDto;
import com.dio.santander.banklineapi.model.Correntista;
import com.dio.santander.banklineapi.repository.CorrentistaRepository;

@Service
public class CorrentistaService {
	private CorrentistaRepository repository;
	
	@Autowired
	public CorrentistaService(CorrentistaRepository repository) {
		this.repository = repository;
	}
	
	public List<CorrentistaDto> findAll() {
		List<Correntista> correntistas = this.repository.findAll();
		List<CorrentistaDto> list = new ArrayList<>();
		correntistas.forEach(c -> list.add(new CorrentistaDto(c)));
		return list;
	}
	
	public CorrentistaDto create(CorrentistaDto correntista) {
		Correntista c = this.toCorrentista(correntista);
		return new CorrentistaDto(this.repository.save(c));
	}
	
	private Correntista toCorrentista(CorrentistaDto correntista) {
		Correntista c = new Correntista();
		c.setId(null);
		c.setCpf(correntista.getCpf());
		c.setNome(correntista.getNome());
		c.setConta(correntista.getConta());
		return c;
	}
}
