package br.com.fbscript.bookstore.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.fbscript.bookstore.model.enumerate.Perfil;

@Entity
public class Usuario {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String senha;
	
	private String email;
	
	@Enumerated(EnumType.STRING)
	private Perfil perfil;
	
	@OneToMany(mappedBy = "usuario", targetEntity = Cupom.class, cascade = CascadeType.REMOVE)
	private List<Cupom> cupons = new ArrayList<Cupom>();
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Carrinho carrinho = new Carrinho();
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<Cupom> getCupons() {
		return cupons;
	}

	public void setCupons(List<Cupom> cupons) {
		this.cupons = cupons;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}	
}
