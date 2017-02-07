package br.com.fbscript.bookstore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import br.com.fbscript.bookstore.model.Livro;

@Repository
public class LivroDao {
	private Session session = new Configuration().configure().buildSessionFactory().openSession();
	
	public void adiciona(Livro livro) {
		this.session.beginTransaction();
		this.session.persist(livro);
		this.session.getTransaction().commit();
	}

	public void altera(Livro livro) {
		this.session.beginTransaction();
		this.session.merge(livro);
		this.session.getTransaction().commit();
	}

	public Livro busca(Long id) {
		return this.session.find(Livro.class, id);
	}

	public List<Livro> lista() {
		return this.session.createQuery("select c from Livro c", Livro.class).getResultList();
	}

	public void remove(Livro livro) {
		this.session.beginTransaction();
		Livro livroParaRemover = this.session.find(Livro.class, livro.getId());
		this.session.remove(livroParaRemover);
		this.session.getTransaction().commit();
	}

}
