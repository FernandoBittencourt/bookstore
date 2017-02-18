package br.com.fbscript.bookstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fbscript.bookstore.dao.CarrinhoDao;
import br.com.fbscript.bookstore.dao.CupomDao;
import br.com.fbscript.bookstore.dao.UsuarioDao;
import br.com.fbscript.bookstore.model.Carrinho;
import br.com.fbscript.bookstore.model.Cupom;
import br.com.fbscript.bookstore.model.Produto;
import br.com.fbscript.bookstore.model.Usuario;

@Controller
@RequestMapping("/compra")
public class CompraController {
	private final CarrinhoDao carrinhoDao;
	private final CupomDao cupomDao;
	private final UsuarioDao usuarioDao;
	
	@Autowired
	public CompraController(CarrinhoDao carrinhoDao, CupomDao cupomDao, UsuarioDao usuarioDao){
		this.carrinhoDao = carrinhoDao;
		this.cupomDao = cupomDao;
		this.usuarioDao = usuarioDao;
	}

	@RequestMapping("/dados")
	public String compraDados(HttpSession session, Model model){
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		Carrinho carrinho = carrinhoDao.busca(usuario.getCarrinho().getId());
		model.addAttribute("comprador", usuario.getNome());
		model.addAttribute("carrinho", carrinho);
		return "compra/dados";
	}
	
	@RequestMapping("/confirmar")
	public String compraFinalizada(Long id, HttpSession session, Model model){
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		Carrinho carrinho = carrinhoDao.busca(usuario.getCarrinho().getId());
		carrinho.setProdutos(new ArrayList<Produto>());
		Cupom cupom = carrinho.getCupom();
		carrinho.setCupom(null);
		carrinhoDao.altera(carrinho);
		if(cupom !=null){
			usuario = usuarioDao.busca(usuario.getId());
			List<Cupom> listaNova = new ArrayList<Cupom>();
			for(Cupom cupomUsuario:usuario.getCupons()){
				if(cupomUsuario.getId() != cupom.getId()){
					listaNova.add(cupomUsuario);
				}
			}
			usuario.setCupons(listaNova);
			usuarioDao.altera(usuario);
			cupomDao.remove(cupom);
		}
		model.addAttribute("usuario", usuario.getNome());
		return "compra/finalizada";
	}
	
	
}