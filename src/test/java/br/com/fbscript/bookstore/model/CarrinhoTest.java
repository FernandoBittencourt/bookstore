package br.com.fbscript.bookstore.model;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fbscript.bookstore.model.enumerate.TipoDoProduto;

public class CarrinhoTest {
	
	private Carrinho carrinho;

	private Produto produto1;
	private Produto produto2;
	private Produto produto3;
	
	private Cupom cupom;
	
	@Before
	public void inicializa(){
		Livro livro = new Livro();
		livro.setEbookPreco(new BigDecimal(10.0));
		livro.setImpressoPreco(new BigDecimal(15.99));
		livro.setComboPreco(new BigDecimal(21.35));
		
		carrinho = new Carrinho();
		
		produto1 = new Produto();
		produto1.setLivro(livro);
		produto1.setQuantidade(1);
		produto1.setTipo(TipoDoProduto.COMBO);
		
		produto2 = new Produto();
		produto2.setLivro(livro);
		produto2.setQuantidade(2);
		produto2.setTipo(TipoDoProduto.EBOOK);
		
		produto3 = new Produto();
		produto3.setLivro(livro);
		produto3.setQuantidade(1);
		produto3.setTipo(TipoDoProduto.IMPRESSO);
		
		cupom = new Cupom();
		cupom.setPorcentagemDeDesconto(10.0);
	}
	
	@Test
	public void deveSerCapazDeCalcularOPreco(){
		BigDecimal valor = carrinho.getPreco();
		Assert.assertTrue(valor.compareTo(BigDecimal.ZERO) == 0);
		
		carrinho.getProdutos().add(produto1);
		valor = carrinho.getPreco();
		Assert.assertTrue(valor.compareTo(BigDecimal.valueOf(21.35)) == 0);
		
		carrinho.getProdutos().add(produto2);
		valor = carrinho.getPreco();
		Assert.assertTrue(valor.compareTo(BigDecimal.valueOf(41.35)) == 0);
		
		carrinho.getProdutos().add(produto3);
		valor = carrinho.getPreco();
		Assert.assertTrue(valor.compareTo(BigDecimal.valueOf(57.34)) == 0);
		
	}
	
	@Test
	public void deveSerCapazDeCalcularOPrecoComDesconto(){
		BigDecimal valor = carrinho.getPrecoComDesconto();
		Assert.assertTrue(valor.compareTo(BigDecimal.ZERO) == 0);
		
		carrinho.setCupom(cupom);
		valor = carrinho.getPrecoComDesconto();
		Assert.assertTrue(valor.compareTo(BigDecimal.ZERO) == 0);
		
		carrinho.getProdutos().add(produto1);
		valor = carrinho.getPrecoComDesconto();
		Assert.assertTrue(valor.compareTo(BigDecimal.valueOf(19.21)) == 0);
		
		carrinho.getProdutos().add(produto2);
		valor = carrinho.getPrecoComDesconto();
		Assert.assertTrue(valor.compareTo(BigDecimal.valueOf(37.21)) == 0);
		
		carrinho.getProdutos().add(produto3);
		valor = carrinho.getPrecoComDesconto();
		Assert.assertTrue(valor.compareTo(BigDecimal.valueOf(51.60)) == 0);
	}
}
