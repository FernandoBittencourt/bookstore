package br.com.fbscript.bookstore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import br.com.fbscript.bookstore.model.Livro;
import br.com.fbscript.bookstore.model.Usuario;

@Repository
public class UsuarioDao {
	private Session session = new Configuration().configure().buildSessionFactory().openSession();
	
	public void adiciona(Usuario usuario) {
		this.session.beginTransaction();
		this.session.persist(usuario);
		this.session.getTransaction().commit();
	}

	public void altera(Usuario usuario) {
		this.session.beginTransaction();
		this.session.merge(usuario);
		this.session.getTransaction().commit();
	}

	public Usuario busca(Long id) {
		return this.session.find(Usuario.class, id);
	}

	public List<Usuario> lista() {
		return this.session.createQuery("select c from Usuario c", Usuario.class).getResultList();
	}

	public void remove(Usuario usuario) {
		this.session.beginTransaction();
		Usuario usuarioParaRemover = this.session.find(Usuario.class, usuario.getId());
		this.session.remove(usuarioParaRemover);
		this.session.getTransaction().commit();
	}

	public Usuario buscaPorNomeESenha(String nome, String senha) {
		return this.session.createQuery("select u from Usuario u where u.nome = :nome and u.senha = :senha", Usuario.class)
		.setParameter("nome", nome)
		.setParameter("senha", senha)
		.getSingleResult();
	}

}
