package br.com.fbscript.bookstore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import br.com.fbscript.bookstore.model.Carrinho;
import br.com.fbscript.bookstore.model.Usuario;

@Repository
public class CarrinhoDao {
	private Session session = new Configuration().configure().buildSessionFactory().openSession();
	
	public void adiciona(Carrinho carrinho) {
		this.session.beginTransaction();
		this.session.persist(carrinho);
		this.session.getTransaction().commit();
	}

	public void altera(Carrinho carrinho) {
		this.session.beginTransaction();
		this.session.merge(carrinho);
		this.session.getTransaction().commit();
	}

	public Carrinho busca(Long id) {
		return this.session.find(Carrinho.class, id);
	}

	public List<Carrinho> lista() {
		return this.session.createQuery("select c from Carrinho c", Carrinho.class).getResultList();
	}

	public void remove(Carrinho carrinho) {
		this.session.beginTransaction();
		Carrinho carrinhoParaRemover = this.session.find(Carrinho.class, carrinho.getId());
		this.session.remove(carrinhoParaRemover);
		this.session.getTransaction().commit();
	}
	
	public Carrinho buscaPorUsuario(Usuario usuario) {
		return this.session.createQuery("select c from Carrinho c where c.usuario.id = :usuarioId", Carrinho.class)
				.setParameter("usuarioId", usuario.getId())
				.getSingleResult();
	}
}
