package br.com.fbscript.bookstore.model;

import java.util.Calendar;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Cupom {

	@Temporal(TemporalType.DATE)
	private Calendar validade;	
	private Double porcentagemDeDesconto;
	
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
