package br.com.macedo.sistemas.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "lanche")
public class Lanche {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 50)
	private String nome;
	
	
	private double valor;
	
	@ManyToMany
	@JoinTable(
			name = "lancamento_lanche",	
			joinColumns = @JoinColumn(name = "lanche_id"),
			inverseJoinColumns = @JoinColumn(name = "lancamento_id")
		)
	private List<Lancamento> lancamentos;
	
	public Lanche() {
		super();
	}

	
	public Lanche(Long id, String nome, double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}


	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}


	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}


	@Override
	public String toString() {
		return "Lanche [nome=" + nome + "]";
	}
	
	
	
}
