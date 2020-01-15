package br.com.macedo.sistemas.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lancamento")
public class Lancamento {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lancamento")
	private Long id;
	
	//@OneToMany(mappedBy = "lancamento", cascade = CascadeType.ALL)
	//private List<LancamentoProduto> lancamentoProdutos;
	
	public Lancamento() {
		// TODO Auto-generated constructor stub
	}
	
	public Lancamento(Long id) {
		super();
		this.id = id;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
