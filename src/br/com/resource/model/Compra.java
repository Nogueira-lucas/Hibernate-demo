package br.com.resource.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="compra_id")
	private int id;
	
	@Column(nullable=false)
	private LocalDate dataCompra;
	
	@Column(nullable=false, scale=2, name="valor_total")
	private BigDecimal valor;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cliente_fk")
	private Cliente cliente;
	
	/*@ManyToMany	
	@JoinTable(name="CompraProduto")
	private List<Produto> produtos = new LinkedList<>();
	*/
	@OneToMany(mappedBy="compra")
	private List<CompraProduto> compraProdutos = new LinkedList<>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<CompraProduto> getCompraProdutos() {
		return compraProdutos;
	}

	public void setCompraProdutos(List<CompraProduto> compraProdutos) {
		this.compraProdutos = compraProdutos;
	}

	/*public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}*/

	

	

}
