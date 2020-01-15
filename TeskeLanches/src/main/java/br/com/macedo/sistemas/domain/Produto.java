package br.com.macedo.sistemas.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "produto")
public class Produto{


	public enum Categoria {
		BEBIDA, LANCHE, PORCAO
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long id;

	@Column(name = "produto")
	private String descProduto;
	
	@Column(name = "valor_produto")
	private double valorProduto;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "categoria", nullable = false)
	private Categoria categoria;
	
	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
	private List<LancamentoProduto> lancamentoProdutos;
	
	
	public Produto() {
		super();
	}
	
	
	public Produto(Long id) {
		this.id = id;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto(List<LancamentoProduto> lancamentoProdutos) {
		super();
		this.lancamentoProdutos = lancamentoProdutos;
	}


	public Produto(Categoria categoria) {
		super();
		this.categoria = categoria;
	}

	public String getDescProduto() {
		return descProduto;
	}

	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}


	public double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public List<LancamentoProduto> getLancamentoProdutos() {
		return lancamentoProdutos;
	}


	public void setLancamentoProdutos(List<LancamentoProduto> lancamentoProdutos) {
		this.lancamentoProdutos = lancamentoProdutos;
	}

}
