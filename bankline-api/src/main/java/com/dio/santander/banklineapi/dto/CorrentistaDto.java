package com.dio.santander.banklineapi.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dio.santander.banklineapi.model.Conta;
import com.dio.santander.banklineapi.model.Correntista;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Builder
public class CorrentistaDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String cpf;
	private String nome;
	private Conta conta;
	
	public CorrentistaDto(Correntista c) {
		this.id = c.getId();
		this.cpf = c.getCpf();
		this.nome = c.getNome();
		this.conta = c.getConta();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
