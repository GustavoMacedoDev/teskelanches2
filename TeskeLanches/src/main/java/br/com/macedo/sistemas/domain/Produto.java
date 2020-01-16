package br.com.macedo.sistemas.domain;

import java.io.Serializable;
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
	private Long id;

	@Column(name = "produto")
	private String descProduto;
	
	@Column(name = "valor_produto")
	private double valorProduto;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "categoria", nullable = false)
	private Categoria categoria;
	
	@OneToMany(mappedBy = "produto")
	private List<LancamentoProduto> lancamentosProdutos;
	
	
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


	public List<LancamentoProduto> getLancamentosProdutos() {
		return lancamentosProdutos;
	}


	public void setLancamentosProdutos(List<LancamentoProduto> lancamentosProdutos) {
		this.lancamentosProdutos = lancamentosProdutos;
	}

}
