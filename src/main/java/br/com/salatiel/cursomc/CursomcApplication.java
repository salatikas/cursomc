package br.com.salatiel.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.salatiel.cursomc.domain.Categoria;
import br.com.salatiel.cursomc.domain.Produto;
import br.com.salatiel.cursomc.repositories.CategoriaRepository;
import br.com.salatiel.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
/*CommandLineRunner vai permitir implementar um metodo auxiliar para execitar
 * alguma ação quando a aplicação iniciar*/
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

@Override
public void run(String... args) throws Exception {
	// TODO Auto-generated method stub
	Categoria cat1 = new Categoria(null, "Informática");
	Categoria cat2 = new Categoria(null, "Escritório");
	
	Produto p1 = new Produto(null, "Computador", 2000.00);
	Produto p2 = new Produto(null, "Impressora", 800.00);
	Produto p3 = new Produto(null, "Mouse", 80.00);
	
	//Adicionar os produtos nas categorias corretas
	cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
	cat2.getProdutos().addAll(Arrays.asList(p2));
	
	//Adicionar as categorias aos produtos
	p1.getCategorias().addAll(Arrays.asList(cat1));
	p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
	p3.getCategorias().addAll(Arrays.asList(cat1));
	
	//Salvar varios objetos no BD
	categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
	produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	
	
	
}
}
