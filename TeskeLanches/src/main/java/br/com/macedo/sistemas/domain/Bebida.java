package br.com.macedo.sistemas.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "bebida")
public class Bebida {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bebida_id")
	private Long id;
	
	@Column(nullable = false, length = 50, name = "nome_bebida")
	private String nomeBebida;
	
	@Column(name = "valor_bebida", nullable = false)
	private double valor;
	
	@Column(name = "status_bebida")
	private boolean status = true;
	
	@ManyToMany
	@JoinTable(
			name = "lancamento_bebida",	
			joinColumns = @JoinColumn(name = "bebida_id"),
			inverseJoinColumns = @JoinColumn(name = "lancamento_id")
		)
	private List<Lancamento> lancamentos;
	
	public Bebida(Long id) {
		this.id = id;
	}
	
	public Bebida() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeBebida() {
		return nomeBebida;
	}

	public void setNomeBebida(String nomeBebida) {
		this.nomeBebida = nomeBebida;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

}
