package br.com.fbscript.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fbscript.bookstore.dao.LivroDao;
import br.com.fbscript.bookstore.model.Livro;

@Controller
@RequestMapping("/livro")
public class LivroController {
	private final LivroDao dao;
	
	@Autowired
	public LivroController(LivroDao dao){
		this.dao = dao;
	}

	@RequestMapping("/lista")
	public String lista(Model model){
		model.addAttribute("livros", dao.lista());
		return "livro/lista";
	}
	
	@RequestMapping("/novo")
	public String novo(){
		return "livro/formulario";
	}

	@RequestMapping("/altera")
	public String altera(Long id, Model model){	
		model.addAttribute("livro", dao.busca(id));
		return "livro/formulario";
	}
	
	@RequestMapping("/visualiza")
	public String vizualizar(Long id, Model model){	
		model.addAttribute("livro", dao.busca(id));
		return "livro/dados";
	}
	
	@RequestMapping("/adiciona")
	public String adiciona(Livro livro){
		if(livro.getId()==null){
			dao.adiciona(livro);
		} else {
			dao.altera(livro);
		}
		return "redirect:/livro/lista";
	}	

	@RequestMapping("/remove")
	public String remove(Long id){		
		dao.remove(dao.busca(id));
		return "redirect:/livro/lista";
	}
}