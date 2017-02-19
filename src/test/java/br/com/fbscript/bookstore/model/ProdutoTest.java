package br.com.fbscript.bookstore.model;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fbscript.bookstore.model.enumerate.TipoDoProduto;

public class ProdutoTest {
	
	private Produto produto1;
	private Produto produto2;
	private Produto produto3;
	
	@Before
	public void inicializa(){
		Livro livro = new Livro();
		livro.setEbookPreco(new BigDecimal(10.0));
		livro.setImpressoPreco(new BigDecimal(15.99));
		livro.setComboPreco(new BigDecimal(21.35));
		
		
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
	}
	
	@Test
	public void deveSerCapazDeCalcularOPrecoTotal(){
		Assert.assertTrue(produto1.getPreco().compareTo(BigDecimal.valueOf(21.35)) == 0);
		Assert.assertTrue(produto2.getPreco().compareTo(BigDecimal.valueOf(20.00)) == 0);
		Assert.assertTrue(produto3.getPreco().compareTo(BigDecimal.valueOf(15.99)) == 0);		
	}
}
