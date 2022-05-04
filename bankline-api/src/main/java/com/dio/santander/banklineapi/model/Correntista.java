package com.dio.santander.banklineapi.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
public class Correntista {
	@Id
	private Integer id;
	@Column(nullable = false)
	private String cpf;
	@Column(nullable = false)
	private String nome;
	@OneToOne
	private Conta conta;
}
