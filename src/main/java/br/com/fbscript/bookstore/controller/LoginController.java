package br.com.fbscript.bookstore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fbscript.bookstore.dao.LivroDao;
import br.com.fbscript.bookstore.dao.UsuarioDao;
import br.com.fbscript.bookstore.model.Usuario;

@Controller
public class LoginController {
	private final LivroDao livroDao;
	private final UsuarioDao usuarioDao;
	
	@Autowired
	public LoginController(LivroDao livroDao, UsuarioDao usuarioDao){
		this.livroDao = livroDao;
		this.usuarioDao = usuarioDao;
	}
	
	@RequestMapping("/entra")
	public String entra(){
		return "principal/formulario-login";
	}
	
	@RequestMapping("/semPermissao")
	public String semPermissao(){
		return "principal/sem-permissao";
	}
	
	@RequestMapping("/efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session, Model model){
		usuario = usuarioDao.buscaPorNomeESenha(usuario.getNome(),usuario.getSenha());
		if(usuario != null){
			session.setAttribute("usuarioLogado", usuario);
		}
		model.addAttribute("categorias", livroDao.listaCategorias());
		model.addAttribute("livros", livroDao.lista());
		return "principal/index";
	}
	
	@RequestMapping("/sair")
	public String sair(HttpSession session, Model model){
		session.removeAttribute("usuarioLogado");

		model.addAttribute("categorias", livroDao.listaCategorias());
		model.addAttribute("livros", livroDao.lista());
		return "principal/index";
	}
}
