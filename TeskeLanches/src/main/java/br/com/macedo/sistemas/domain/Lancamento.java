package br.com.macedo.sistemas.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "lancamento")
public class Lancamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Mesa mesa;
	
	@ManyToMany
	@JoinTable(
			name = "lancamento_lanche",	
			joinColumns = @JoinColumn(name = "lancamento_id"),
			inverseJoinColumns = @JoinColumn(name = "lanche_id")
		)
	private List<Lanche> lanches;
	
	public Lancamento() {
		// TODO Auto-generated constructor stub
	}

	public Lancamento(Long id, Mesa mesa) {
		super();
		this.id = id;
		this.mesa = mesa;
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

	public List<Lanche> getLanches() {
		return lanches;
	}

	public void setLanches(List<Lanche> lanches) {
		this.lanches = lanches;
	}
	
	

}
