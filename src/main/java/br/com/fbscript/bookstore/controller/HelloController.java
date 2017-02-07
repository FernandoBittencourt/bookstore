package br.com.fbscript.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/olaMundoSpring")
	public String execute(){
		System.out.println("Executando a lógica com Spring MVC");
		return "hello";
	}
}
