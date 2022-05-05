package com.dio.santander.banklineapi.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Embeddable
public class Conta {
	@Column(nullable = false)
	private Long numero;
	@Column(nullable = false)
	private Double saldo;
}
