package br.com.macedo.sistemas.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "lanche")
public class Lanche {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lanche_id")
	private Long id;
	
	@Column(nullable = false, length = 50, name = "nome_lanche")
	private String nomeLanche;
	
	@Column(name = "valor_lanche")
	private double valor;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "lancamento_lanche",	
			joinColumns = @JoinColumn(name = "lanche_id"),
			inverseJoinColumns = @JoinColumn(name = "lancamento_id")
		)
	private List<Lancamento> lancamentos;
	
	public Lanche(Long id) {
		this.id = id;
	}
	
	public Lanche() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
	public String getNomeLanche() {
		return nomeLanche;
	}

	public void setNomeLanche(String nomeLanche) {
		this.nomeLanche = nomeLanche;
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
		return "Lanche [nome=" + nomeLanche + "]";
	}
	
	
	
}
