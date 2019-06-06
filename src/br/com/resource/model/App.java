package br.com.resource.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class App {
	
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setDataNascimento(LocalDate.of(1998, 02, 06));
		cliente.setEmail("lucas@gmail.com");
		cliente.setNome("Lucas Marques");
		cliente.setSenha("1223");
		
		Produto produto = new Produto();
		produto.setNome("Coca-cola");
		produto.setValor(BigDecimal.valueOf(33.00));

		Compra compra = new Compra();
		compra.setCliente(cliente);
		compra.setDataCompra(LocalDate.now());

		CompraProduto cp = new CompraProduto();
		
		compra.getCompraProdutos().add(cp);
		
		cp.setCompra(compra);
		cp.setProduto(produto);
		cp.setQuantidade(2);
		
		BigDecimal qtde = BigDecimal.valueOf(cp.getQuantidade());
		BigDecimal total = cp.getProduto().getValor().multiply(qtde);
		compra.setValor(total);
		
		Dao.salvar(cp);	
		

	}

}
