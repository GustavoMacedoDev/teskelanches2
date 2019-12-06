package br.com.macedo.sistemas.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lancamento_id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Mesa mesa;
	
	@ManyToMany(fetch = FetchType.EAGER)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lanches == null) ? 0 : lanches.hashCode());
		result = prime * result + ((mesa == null) ? 0 : mesa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamento other = (Lancamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lanches == null) {
			if (other.lanches != null)
				return false;
		} else if (!lanches.equals(other.lanches))
			return false;
		if (mesa == null) {
			if (other.mesa != null)
				return false;
		} else if (!mesa.equals(other.mesa))
			return false;
		return true;
	}
	
	
	

}
