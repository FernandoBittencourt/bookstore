package br.com.fbscript.bookstore.model;

import java.util.Calendar;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Cupom {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Calendar validade;	
	
	private Double porcentagemDeDesconto;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Calendar getValidade() {
		return validade;
	}
	public void setValidade(Calendar validade) {
		this.validade = validade;
	}
	public Double getPorcentagemDeDesconto() {
		return porcentagemDeDesconto;
	}
	public void setPorcentagemDeDesconto(Double porcentagemDeDesconto) {
		this.porcentagemDeDesconto = porcentagemDeDesconto;
	}
}
