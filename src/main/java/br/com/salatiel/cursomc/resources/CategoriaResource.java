package br.com.salatiel.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Anotações
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@RequestMapping(method=RequestMethod.GET) //VERBO HTTP(EX: get - usar o correto para cada operação)
	public String listar() {
		return "Rest está funcionando";
	}
	
}
