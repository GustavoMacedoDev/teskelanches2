package br.com.macedo.sistemas.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "mesa")
public class Mesa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "numero_mesa")
	private String numero;
	
	@Column(name = "status_mesa")
	private int statusMesa = 0;
	
	@OneToMany(mappedBy = "mesa")
	private List<Lancamento> lancamentos;
	
	
	public Mesa() {
		super();
	}
	
	public Mesa(Long id) {
		this.id = id;
	}

	public Mesa(Long id, String numero) {
		super();
		this.id = id;
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	

	public int getStatusMesa() {
		return statusMesa;
	}

	public void setStatusMesa(int statusMesa) {
		this.statusMesa = statusMesa;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

}
