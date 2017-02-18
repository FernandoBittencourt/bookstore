package br.com.fbscript.bookstore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import br.com.fbscript.bookstore.model.Produto;

@Repository
public class ProdutoDao {
	private Session session = new Configuration().configure().buildSessionFactory().openSession();
	
	public void adiciona(Produto produto) {
		this.session.beginTransaction();
		this.session.persist(produto);
		this.session.getTransaction().commit();
	}

	public void altera(Produto produto) {
		this.session.beginTransaction();
		this.session.merge(produto);
		this.session.getTransaction().commit();
	}

	public Produto busca(Long id) {
		return this.session.find(Produto.class, id);
	}

	public List<Produto> lista() {
		return this.session.createQuery("select c from Produto c", Produto.class).getResultList();
	}

	public void remove(Produto produto) {
		this.session.beginTransaction();
		Produto produtoParaRemover = this.session.find(Produto.class, produto.getId());
		this.session.remove(produtoParaRemover);
		this.session.getTransaction().commit();
	}

}
