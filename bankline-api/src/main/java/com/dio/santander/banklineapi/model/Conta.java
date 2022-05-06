package com.dio.santander.banklineapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Embeddable
public class Conta implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column(nullable = false)
	private Long numero;
	@Column(nullable = false)
	private Double saldo;
	
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
}
