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

public class MovimentacaoDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private LocalDateTime dataHora;
	private String descricao;
	private Double valor;
	private MovimentacaoTipo tipo;
	private Integer idConta;
	
	public MovimentacaoDto(Movimentacao m) {
		this.id = m.getId();
		this.dataHora = m.getDataHora();
		this.descricao = m.getDescricao();
		this.valor = m.getValor();
		this.tipo = m.getTipo();
		this.idConta = m.getIdConta();
	}
}
