package br.com.macedo.sistemas.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lancamento")
	private Long id;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "lancamento_produto",	
			joinColumns = @JoinColumn(name = "id_lancamento"),
			inverseJoinColumns = @JoinColumn(name = "id_produto")
		)
	private List<Produto> produtos;
	
	@Column
	private int quantidade;
	
	
	public Lancamento() {
		super();
	}
	
	public Lancamento(Long id) {
		this.id = id;
	}

	public Lancamento(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
