package br.com.macedo.sistemas.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "produto")
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;

	public enum Categoria {
		BEBIDA, LANCHE, PORCAO
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long idProduto;

	@Column(name = "produto")
	private String produto;
	
	@Column(name = "valor_produto")
	private double valorProduto;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "categoria", nullable = false)
	private Categoria categoria;
	
	@OneToMany(mappedBy = "produto")
	private List<ItensPedido> itensPedidos = new ArrayList<>();
	
	
	public Produto() {
		// TODO Auto-generated constructor stub
	}
	

	public Produto(Long idProduto) {
		super();
		this.idProduto = idProduto;
	}
	
	
	public Produto(Categoria categoria) {
		super();
		this.categoria = categoria;
	}


	public Produto(List<ItensPedido> itensPedidos) {
		super();
		this.itensPedidos = itensPedidos;
	}

	public Produto(Long idProduto, String produto, double valorProduto, List<ItensPedido> itensPedidos) {
		super();
		this.idProduto = idProduto;
		this.produto = produto;
		this.valorProduto = valorProduto;
		this.itensPedidos = itensPedidos;
	}



	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}

	public List<ItensPedido> getItensPedidos() {
		return itensPedidos;
	}

	public void setItensPedidos(List<ItensPedido> itensPedidos) {
		this.itensPedidos = itensPedidos;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


}
