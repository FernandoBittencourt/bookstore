package br.com.fbscript.bookstore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import br.com.fbscript.bookstore.model.Cupom;

@Repository
public class CupomDao {
	private Session session = new Configuration().configure().buildSessionFactory().openSession();
	
	public void adiciona(Cupom cupom) {
		this.session.beginTransaction();
		this.session.persist(cupom);
		this.session.getTransaction().commit();
	}

	public void altera(Cupom cupom) {
		this.session.beginTransaction();
		this.session.merge(cupom);
		this.session.getTransaction().commit();
	}

	public Cupom busca(Long id) {
		return this.session.find(Cupom.class, id);
	}

	public List<Cupom> lista() {
		return this.session.createQuery("select c from Cupom c", Cupom.class).getResultList();
	}

	public void remove(Cupom cupom) {
		this.session.beginTransaction();
		Cupom cupomParaRemover = this.session.find(Cupom.class, cupom.getId());
		this.session.remove(cupomParaRemover);
		this.session.getTransaction().commit();
	}

}
