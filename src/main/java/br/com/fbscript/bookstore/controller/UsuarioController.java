package br.com.fbscript.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fbscript.bookstore.dao.UsuarioDao;
import br.com.fbscript.bookstore.model.Usuario;
import br.com.fbscript.bookstore.model.enumerate.Perfil;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	private final UsuarioDao dao;
	
	@Autowired
	public UsuarioController(UsuarioDao dao){
		this.dao = dao;
	}

	@RequestMapping("/lista")
	public String lista(Model model){
		model.addAttribute("usuarios", dao.lista());
		return "usuario/lista";
	}
	
	@RequestMapping("/novo")
	public String novo(Model model){
		model.addAttribute("perfis", Perfil.values());
		return "usuario/formulario";
	}

	@RequestMapping("/altera")
	public String altera(Long id, Model model){	
		model.addAttribute("perfis", Perfil.values());
		model.addAttribute("usuario", dao.busca(id));
		return "usuario/formulario";
	}
	
	
	@RequestMapping("/adiciona")
	public String adiciona(Usuario usuario){
		if(usuario.getId()==null){
			dao.adiciona(usuario);
		} else {
			dao.altera(usuario);
		}
		return "redirect:/usuario/lista";
	}	

	@RequestMapping("/remove")
	public String remove(Long id){		
		dao.remove(dao.busca(id));
		return "redirect:/usuario/lista";
	}
}