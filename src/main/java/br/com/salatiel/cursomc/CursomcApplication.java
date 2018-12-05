package br.com.salatiel.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.salatiel.cursomc.domain.Categoria;
import br.com.salatiel.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
/*CommandLineRunner vai permitir implementar um metodo auxiliar para execitar
 * alguma ação quando a aplicação iniciar*/
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

@Override
public void run(String... args) throws Exception {
	// TODO Auto-generated method stub
	Categoria cat1 = new Categoria(null, "Informática");
	Categoria cat2 = new Categoria(null, "Escritório");
	
	//Salvar varios objetos no BD
	categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
	
}
}
