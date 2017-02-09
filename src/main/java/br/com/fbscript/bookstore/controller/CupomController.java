package br.com.fbscript.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fbscript.bookstore.dao.CupomDao;
import br.com.fbscript.bookstore.model.Cupom;

@Controller
@RequestMapping("/cupom")
public class CupomController {
	private final CupomDao dao;
	
	@Autowired
	public CupomController(CupomDao dao){
		this.dao = dao;
	}

	@RequestMapping("/lista")
	public String lista(Model model){
		model.addAttribute("cupons", dao.lista());
		return "cupom/lista";
	}
	
	@RequestMapping("/novo")
	public String novo(){
		return "cupom/formulario";
	}

	@RequestMapping("/altera")
	public String altera(Long id, Model model){	
		model.addAttribute("cupom", dao.busca(id));
		return "cupom/formulario";
	}
	
	
	@RequestMapping("/adiciona")
	public String adiciona(Cupom cupom){
		if(cupom.getId()==null){
			dao.adiciona(cupom);
		} else {
			dao.altera(cupom);
		}
		return "redirect:/cupom/lista";
	}	

	@RequestMapping("/remove")
	public String remove(Long id){		
		dao.remove(dao.busca(id));
		return "redirect:/cupom/lista";
	}
}