package br.com.fbscript.bookstore.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livro {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String titulo;
	
	private String capa;
	
	private String autor;
	
	private String descricao;

	private BigDecimal ebookPreco;
	
	private BigDecimal impressoPreco;
	
	private BigDecimal comboPreco;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getCapa() {
		return capa;
	}
	
	public void setCapa(String capa) {
		this.capa = capa;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public BigDecimal getEbookPreco() {
		return ebookPreco;
	}
	
	public void setEbookPreco(BigDecimal ebookPreco) {
		this.ebookPreco = ebookPreco;
	}
	
	public BigDecimal getImpressoPreco() {
		return impressoPreco;
	}
	
	public void setImpressoPreco(BigDecimal impressoPreco) {
		this.impressoPreco = impressoPreco;
	}
	
	public BigDecimal getComboPreco() {
		return comboPreco;
	}
	
	public void setComboPreco(BigDecimal comboPreco) {
		this.comboPreco = comboPreco;
	}
}
