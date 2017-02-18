package br.com.fbscript.bookstore.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Carrinho {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Produto> produtos = new ArrayList<Produto>();
	
	@OneToOne
	private Usuario usuario;

	@OneToOne(cascade = CascadeType.REMOVE)
	private Cupom cupom;

	public BigDecimal getPreco(){
		BigDecimal preco = BigDecimal.ZERO;
		for(Produto produto: produtos){
			preco = preco.add(produto.getPreco());
		}
		return preco.setScale(2, BigDecimal.ROUND_DOWN);
	}
	public BigDecimal getPrecoComDesconto(){
		BigDecimal preco = getPreco();
		if(cupom != null){
			preco = preco.multiply(new BigDecimal((100 - cupom.getPorcentagemDeDesconto()) / 100));
		}
		return preco.setScale(2, BigDecimal.ROUND_DOWN);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public Cupom getCupom() {
		return cupom;
	}
	public void setCupom(Cupom cupom) {
		this.cupom = cupom;
	}
}
