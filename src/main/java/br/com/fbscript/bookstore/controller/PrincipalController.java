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
