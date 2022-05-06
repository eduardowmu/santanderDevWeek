package com.dio.santander.banklineapi.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dio.santander.banklineapi.model.Movimentacao;
import com.dio.santander.banklineapi.model.MovimentacaoTipo;

public class MovimentacaoDto implements Serializable{
	private Integer id;
	private LocalDateTime dataHora;
	private String descricao;
	private Double valor;
	private MovimentacaoTipo tipo;
	private Integer idConta;
	
	public MovimentacaoDto() {}

	public MovimentacaoDto(Integer id, LocalDateTime dataHora, String descricao, Double valor, MovimentacaoTipo tipo,
			Integer idConta) {
		this.id = id;
		this.dataHora = dataHora;
		this.descricao = descricao;
		this.valor = valor;
		this.tipo = tipo;
		this.idConta = idConta;
	}

	public MovimentacaoDto(Movimentacao m) {
		this.id = m.getId();
		this.dataHora = m.getDataHora();
		this.descricao = m.getDescricao();
		this.valor = m.getValor();
		this.tipo = m.getTipo();
		this.idConta = m.getIdConta();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public MovimentacaoTipo getTipo() {
		return tipo;
	}

	public void setTipo(MovimentacaoTipo tipo) {
		this.tipo = tipo;
	}

	public Integer getIdConta() {
		return idConta;
	}

	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}
}
