package br.com.salatiel.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.salatiel.cursomc.domain.Categoria;
import br.com.salatiel.cursomc.domain.Cidade;
import br.com.salatiel.cursomc.domain.Cliente;
import br.com.salatiel.cursomc.domain.Endereco;
import br.com.salatiel.cursomc.domain.Estado;
import br.com.salatiel.cursomc.domain.Pagamento;
import br.com.salatiel.cursomc.domain.PagamentoComBoleto;
import br.com.salatiel.cursomc.domain.PagamentoComCartao;
import br.com.salatiel.cursomc.domain.Pedido;
import br.com.salatiel.cursomc.domain.Produto;
import br.com.salatiel.cursomc.domain.enums.EstadoPagamento;
import br.com.salatiel.cursomc.domain.enums.TipoCliente;
import br.com.salatiel.cursomc.repositories.CategoriaRepository;
import br.com.salatiel.cursomc.repositories.CidadeRepository;
import br.com.salatiel.cursomc.repositories.ClienteRepository;
import br.com.salatiel.cursomc.repositories.EnderecoRepository;
import br.com.salatiel.cursomc.repositories.EstadoRepository;
import br.com.salatiel.cursomc.repositories.PagamentoRepository;
import br.com.salatiel.cursomc.repositories.PedidoRepository;
import br.com.salatiel.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	/*
	 * CommandLineRunner vai permitir implementar um metodo auxiliar para execitar
	 * alguma ação quando a aplicação iniciar
	 */

	// REPOSITORY
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// CATEGORIAS E PRODUTOS
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		// Adicionar os produtos nas categorias corretas
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		// Adicionar as categorias aos produtos
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		// Salvar Categorias e Produtos no BD
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		// CIDADES E ESTADOS
		// Adicionar os Estados
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		// Adicionar as Cidades
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		// Atribuir as cidades aos estados
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		// PS: As cidades já conhecem seu estado

		// Salvar Cidades e Estados no BD
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		// CLIENTE E ENDEREÇO
		// Adiconar Clientes
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);

		// Atribuir Telefones ao Cliente
		cli1.getTelefones().addAll(Arrays.asList("27363323", "9383893"));

		// Adicionar endereços
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 2013", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);

		// Atribuir endereço ao cliente
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		// Salvando Clientes e Enderecos no BD
		// Sempre salvar primeiro quem é independente
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		// INSTANCIAR PEDIDOS E PAGAMENTOS
		// Mascara de formação para data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf2.parse("20/10/2017"), null);
		ped2.setPagamento(pagto2);
		
		//Associar os pedidos ao cliente
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		//Salvar pedidos e pagamentos
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));

	}
}
