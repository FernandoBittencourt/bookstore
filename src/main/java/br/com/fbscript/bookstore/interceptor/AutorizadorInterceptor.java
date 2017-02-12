package br.com.fbscript.bookstore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.fbscript.bookstore.model.Usuario;
import br.com.fbscript.bookstore.model.enumerate.Perfil;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception {
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		//Não Precisa estar logado para acessar
		if(uri.contains(".")||uri.endsWith("bookstore/")||uri.endsWith("bookstore")||uri.endsWith("entra")||uri.endsWith("sair")||uri.endsWith("/bookstore/efetuaLogin") || uri.contains("/bookstore/livro/visualiza")){
			return true;
		}
		
		if (request.getSession().getAttribute("usuarioLogado") != null) {
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
			if(uri.contains("/bookstore/livro")|| uri.contains("/bookstore/painel-de-admin") || uri.contains("/bookstore/usuario") || uri.contains("/bookstore/cupom")){
				if(!usuario.getPerfil().equals(Perfil.ADMIN)){
					response.sendRedirect("/bookstore/semPermissao");
				}
			}
		} else {
			response.sendRedirect("/bookstore/entra");
		}

		return true;
	}
}
