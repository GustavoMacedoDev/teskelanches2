package br.com.macedo.sistemas.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "lancamento_produto")
public class LancamentoProduto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	private Produto produto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Lancamento lancamento;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Quantidade quantidade;

	public LancamentoProduto() {
		super();
	}
	
	public LancamentoProduto(Long id) {
		this.id = id;
	}

	public Quantidade getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Quantidade quantidade) {
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}
	
	
	
}
