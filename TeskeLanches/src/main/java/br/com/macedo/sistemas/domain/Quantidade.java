package br.com.macedo.sistemas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "quantidade")
public class Quantidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private int valor;
	
	@OneToMany(mappedBy = "quantidade")
	private List<LancamentoProduto> lancamentosProdutos;
	
	
	public Quantidade() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public List<LancamentoProduto> getLancamentosProdutos() {
		return lancamentosProdutos;
	}

	public void setLancamentosProdutos(List<LancamentoProduto> lancamentosProdutos) {
		this.lancamentosProdutos = lancamentosProdutos;
	}
	
}
