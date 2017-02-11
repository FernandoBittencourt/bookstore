package br.com.fbscript.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fbscript.bookstore.dao.CupomDao;
import br.com.fbscript.bookstore.dao.UsuarioDao;
import br.com.fbscript.bookstore.model.Cupom;

@Controller
@RequestMapping("/cupom")
public class CupomController {
	private final CupomDao dao;
	private final UsuarioDao usuariodao;
	
	@Autowired
	public CupomController(CupomDao dao, UsuarioDao usuariodao){
		this.dao = dao;
		this.usuariodao = usuariodao;
	}

	@RequestMapping("/lista")
	public String lista(Model model){
		model.addAttribute("cupons", dao.lista());
		return "cupom/lista";
	}
	
	@RequestMapping("/novo")
	public String novo(Model model){
		model.addAttribute("usuarios", usuariodao.lista());
		return "cupom/formulario";
	}

	@RequestMapping("/altera")
	public String altera(Long id, Model model){	
		model.addAttribute("usuarios", usuariodao.lista());
		model.addAttribute("cupom", dao.busca(id));
		return "cupom/formulario";
	}
	
	
	@RequestMapping("/adiciona")
	public String adiciona(Cupom cupom){
		cupom.setUsuario(usuariodao.busca(cupom.getUsuario().getId()));
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