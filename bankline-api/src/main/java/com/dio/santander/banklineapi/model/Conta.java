package com.dio.santander.banklineapi.model;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Data;

@Data
public class Conta {
	@Id
	private Integer id;
	@Column(nullable = false)
	private Long numero;
	@Column(nullable = false)
	private Double saldo;
}
