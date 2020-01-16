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
	
	@OneToMany(mappedBy = "lancamento")
	private List<LancamentoProduto> lancamentosProdutos;
	
	@ManyToOne
	private Mesa mesa;
	
	
	public Lancamento() {
		super();
	}
	
	public Lancamento(Long id) {
		this.id = id;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public List<LancamentoProduto> getLancamentosProdutos() {
		return lancamentosProdutos;
	}

	public void setLancamentosProdutos(List<LancamentoProduto> lancamentosProdutos) {
		this.lancamentosProdutos = lancamentosProdutos;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	
}
