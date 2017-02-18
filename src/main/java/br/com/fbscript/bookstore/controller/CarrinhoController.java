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
import br.com.fbscript.bookstore.dao.LivroDao;
import br.com.fbscript.bookstore.dao.UsuarioDao;
import br.com.fbscript.bookstore.model.Carrinho;
import br.com.fbscript.bookstore.model.Produto;
import br.com.fbscript.bookstore.model.Usuario;
import br.com.fbscript.bookstore.model.enumerate.TipoDoProduto;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {
	private final CarrinhoDao dao;
	private final LivroDao livroDao;
	private final UsuarioDao usuarioDao;
	private final CupomDao cupomDao;
	
	@Autowired
	public CarrinhoController(CarrinhoDao dao, LivroDao livroDao, UsuarioDao usuarioDao, CupomDao cupomDao){
		this.dao = dao;
		this.livroDao = livroDao;
		this.usuarioDao = usuarioDao;
		this.cupomDao = cupomDao;
	}

	@RequestMapping("/lista")
	public String lista(HttpSession session, Model model){
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		Carrinho carrinho = dao.busca(usuario.getCarrinho().getId());
		model.addAttribute("carrinho", carrinho);
		model.addAttribute("cupons", usuarioDao.busca(usuario.getId()).getCupons());
		model.addAttribute("produtos", carrinho.getProdutos());
		model.addAttribute("tiposDoProduto", TipoDoProduto.values());
		return "carrinho/lista";
	}
	
	@RequestMapping("/adiciona")
	public String adicionaProduto(Long id, HttpSession session, Model model){
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		Carrinho carrinho = dao.busca(usuario.getCarrinho().getId());
		Produto produto = new Produto();
		produto.setLivro(livroDao.busca(id));
		produto.setQuantidade(1);
		produto.setTipo(TipoDoProduto.EBOOK);
		carrinho.getProdutos().add(produto);
		dao.altera(carrinho);
		
		model.addAttribute("carrinho", carrinho);
		model.addAttribute("cupons", usuarioDao.busca(usuario.getId()).getCupons());
		model.addAttribute("produtos", carrinho.getProdutos());
		model.addAttribute("tiposDoProduto", TipoDoProduto.values());
		return "carrinho/lista";
	}
	
	@RequestMapping("/remove")
	public String removeProduto(Long id, HttpSession session, Model model){
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		Carrinho carrinho = dao.busca(usuario.getCarrinho().getId());
		List<Produto> novaLista = new ArrayList<Produto>();
		for(Produto produto:carrinho.getProdutos()){
			if(produto.getId()!=id){
				novaLista.add(produto);
			}
		}
		carrinho.setProdutos(novaLista);
		dao.altera(carrinho);
		
		model.addAttribute("carrinho", carrinho);
		model.addAttribute("cupons", usuarioDao.busca(usuario.getId()).getCupons());
		model.addAttribute("produtos", carrinho.getProdutos());
		model.addAttribute("tiposDoProduto", TipoDoProduto.values());
		return "carrinho/lista";
	}
	
	@RequestMapping("/alteraProdutoQuantidade")
	public String alteraProdutoQuantidade(Long id, int quantidade,  HttpSession session, Model model){
		if(quantidade > 0){
			Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
			Carrinho carrinho = dao.busca(usuario.getCarrinho().getId());
			for(Produto produto:carrinho.getProdutos()){
				if(produto.getId()==id){
					produto.setQuantidade(quantidade);
					dao.altera(carrinho);
					break;
				}
			}
		}
		return "/carrinho/lista";
	}
	
	@RequestMapping("/alteraProdutoTipo")
	public String alteraProdutoTipo(Long id, TipoDoProduto tipo,  HttpSession session, Model model){
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		Carrinho carrinho = dao.busca(usuario.getCarrinho().getId());
		for(Produto produto:carrinho.getProdutos()){
			if(produto.getId()==id){
				produto.setTipo(tipo);
				dao.altera(carrinho);
				break;
			}
		}
		return "/carrinho/lista";
	}
	
	@RequestMapping("/alteraCupom")
	public String alteraProdutoTipo(Long id, HttpSession session, Model model){
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		Carrinho carrinho = dao.busca(usuario.getCarrinho().getId());
		if(id != -1){
			carrinho.setCupom(cupomDao.busca(id));
		} else{
			carrinho.setCupom(null);
		}
		dao.altera(carrinho);
		return "/carrinho/lista";
	}
	
}