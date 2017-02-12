package br.com.fbscript.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fbscript.bookstore.dao.LivroDao;

@Controller
public class PrincipalController {
	private final LivroDao livroDao;
	
	@Autowired
	public PrincipalController(LivroDao livroDao){
		this.livroDao = livroDao;
	}
	
	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("livros", livroDao.lista());
		return "principal/index";
	}
	
	@RequestMapping("/painel-de-admin")
	public String painelAdmin(){
		return "principal/admin-menu";
	}
}
