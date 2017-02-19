package br.com.fbscript.bookstore.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.fbscript.bookstore.model.enumerate.TipoDoProduto;

@Entity
public class Produto {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	

	@ManyToOne
	private Livro livro;
	
	private TipoDoProduto tipo;
	
	private Integer quantidade;
	
	public BigDecimal getPreco(){
		BigDecimal preco;
		if(tipo.equals(TipoDoProduto.COMBO)){
			preco = livro.getComboPreco();
		}else if(tipo.equals(TipoDoProduto.IMPRESSO)){
			preco = livro.getImpressoPreco();
		}else{
			preco = livro.getEbookPreco();
		}
		preco = preco.multiply(BigDecimal.valueOf(quantidade)).setScale(2, BigDecimal.ROUND_DOWN);
		return preco;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public TipoDoProduto getTipo() {
		return tipo;
	}
	public void setTipo(TipoDoProduto tipo) {
		this.tipo = tipo;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
