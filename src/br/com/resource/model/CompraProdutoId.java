package br.com.resource.model;

import java.io.Serializable;


public class CompraProdutoId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int compra;
	private int produto;
	private int quantidade;
	
	public CompraProdutoId() {}
	
	public CompraProdutoId(int compra, int produto, int quantidade) {
		super();
		this.compra = compra;
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public int getCompra() {
		return compra;
	}
	public void setCompra(int compra) {
		this.compra = compra;
	}
	public int getProduto() {
		return produto;
	}
	public void setProduto(int produto) {
		this.produto = produto;
	}




	public int getQuantidade() {
		return quantidade;
	}




	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}




	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}
