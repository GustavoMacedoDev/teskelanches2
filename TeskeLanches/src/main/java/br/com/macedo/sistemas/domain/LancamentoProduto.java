package br.com.macedo.sistemas.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "lancamento_produto")
public class LancamentoProduto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lancamento_produto")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Produto produto;
	
	@Column(name = "quantidade")
	private int quantidade;
	
	
	 public LancamentoProduto() {
		// TODO Auto-generated constructor stub
	}

	 
	public LancamentoProduto(Long id) {
		super();
		this.id = id;
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


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	 
}
