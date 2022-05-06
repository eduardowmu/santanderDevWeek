package com.dio.santander.banklineapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.banklineapi.repository.CorrentistaRepository;
import com.dio.santander.banklineapi.repository.MovimentacaoRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dio.santander.banklineapi.dto.MovimentacaoDto;
import com.dio.santander.banklineapi.model.Correntista;
import com.dio.santander.banklineapi.model.Movimentacao;
import com.dio.santander.banklineapi.model.MovimentacaoTipo;

@Service
public class MovimentacaoService {
	private MovimentacaoRepository repository;
	private CorrentistaRepository cRepository;
	
	@Autowired
	public MovimentacaoService(MovimentacaoRepository repository, CorrentistaRepository cRepository) {
		this.repository = repository;
		this.cRepository = cRepository;
	}
	
	public List<MovimentacaoDto> findAll() {
		List<Movimentacao> movimentacoes = this.repository.findAll();
		List<MovimentacaoDto> list = new ArrayList<>();
		movimentacoes.forEach(m -> list.add(new MovimentacaoDto(m)));
		return list;
	}
	
	public MovimentacaoDto create(MovimentacaoDto mDto) {
		Movimentacao m = this.toMovimentacao(mDto);
		return new MovimentacaoDto(this.repository.save(m));
	}
	
	private Movimentacao toMovimentacao(MovimentacaoDto mDto) {
		Movimentacao m = new Movimentacao();
		m.setId(null);
		m.setDataHora(LocalDateTime.now());
		m.setDescricao(mDto.getDescricao());
		m.setIdConta(mDto.getIdConta());
		m.setTipo(mDto.getTipo());
		Double valor = mDto.getTipo() == MovimentacaoTipo.RECEITA ? mDto.getValor() : -1 * mDto.getValor();
		m.setValor(valor);
		
		Correntista c = this.cRepository.findById(mDto.getIdConta()).orElse(null);
		
		if(!c.equals(null)) {
			c.getConta().setSaldo(c.getConta().getSaldo() + valor);
			this.cRepository.save(c);
		}
		
		return  m;
	}
}
