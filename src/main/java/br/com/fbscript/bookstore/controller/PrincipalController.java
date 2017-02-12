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
public class PrincipalController {
	private final LivroDao livroDao;
	private final UsuarioDao usuarioDao;
	
	@Autowired
	public PrincipalController(LivroDao livroDao, UsuarioDao usuarioDao){
		this.livroDao = livroDao;
		this.usuarioDao = usuarioDao;
	}
	
	@RequestMapping("/entra")
	public String entra(){
		return "principal/formulario-login";
	}
	
	@RequestMapping("/efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session){
		usuario = usuarioDao.buscaPorNomeESenha(usuario.getNome(),usuario.getSenha());
		if(usuario != null){
			session.setAttribute("usuarioLogado", usuario);
		}else {
			return "redirect:principal/formulario-login";
		}
		return "redirect:principal/index";
	}
	
	@RequestMapping("/sair")
	public String sair(HttpSession session){
		session.removeAttribute("usuarioLogado");		
		return "redirect:principal/index";
	}
	
	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("categorias", livroDao.listaCategorias());
		model.addAttribute("livros", livroDao.lista());
		return "principal/index";
	}
	
	@RequestMapping("/painel-de-admin")
	public String painelAdmin(){
		return "principal/admin-menu";
	}
	
	@RequestMapping("/filtro")
	public String filtro(String categoria, Model model){
		model.addAttribute("categoriaSelecionada", categoria);
		model.addAttribute("categorias", livroDao.listaCategorias());
		if(categoria!=null && !categoria.isEmpty()){
			model.addAttribute("livros", livroDao.buscaPorCategoria(categoria));
		}else{
			model.addAttribute("livros", livroDao.lista());
		}
		return "principal/index";
	}
	
}
