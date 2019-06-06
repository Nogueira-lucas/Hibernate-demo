package br.com.resource.model;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="produto_id")
	private int id;
	
	@Column(name="nomeProduto", nullable=false)
	private String nome;
	
	@Column(name="valorProduto", nullable=false)
	private BigDecimal valor;
	
	/*@ManyToMany(mappedBy="produtos", fetch = FetchType.LAZY)
	private List<Compra> compras = new LinkedList<>();*/
	
	@OneToMany(mappedBy="produto")
	private List<CompraProduto> compraProdutos = new LinkedList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	/*public List<Compra> getCompras() {
		return compras;
	}
	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}*/

	

}
