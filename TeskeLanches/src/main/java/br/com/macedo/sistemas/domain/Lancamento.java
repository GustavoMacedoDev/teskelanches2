package br.com.macedo.sistemas.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "lancamento")
public class Lancamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lancamento")
	private Long id;
	
	@Column
	private int quantidade;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "lancamento_produto",	
			joinColumns = @JoinColumn(name = "id_lancamento"),
			inverseJoinColumns = @JoinColumn(name = "id_produto")
		)
	private List<Produto> produtos;
	
	@ManyToOne
	private Mesa mesa;
	
	
	public Lancamento() {
		super();
	}
	
	public Lancamento(Long id) {
		this.id = id;
	}


	public Lancamento(List<Produto> produtos) {
		super();
		this.produtos = produtos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
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
