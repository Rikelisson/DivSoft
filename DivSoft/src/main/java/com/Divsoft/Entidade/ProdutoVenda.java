package com.Divsoft.Entidade;

import java.io.Serializable;


import javax.persistence.EmbeddedId;




public class ProdutoVenda implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ProdutoVendaPK id = new ProdutoVendaPK();
	
	private boolean comprar;
	
	public ProdutoVenda() {}

	public ProdutoVenda(Produto produto, Venda venda,boolean compra) {
		super();
		id.setProduto(produto);
		id.setVenda(venda);
		this.comprar=compra;
	}


	public Venda getVenda() {
		return id.getVenda();
	}

	public void setVenda(Venda venda) {
		id.setVenda(venda);
	}

	public Produto getProduto() {
		return id.getProduto();
	}

	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}
	
	public ProdutoVendaPK getId() {
		return id;
	}

	public void setId(ProdutoVendaPK id) {
		this.id = id;
	}

	public boolean isComprar() {
		return comprar;
	}

	public void setComprar(boolean comprar) {
		this.comprar = comprar;
	}
	
	
	
	
	

}
