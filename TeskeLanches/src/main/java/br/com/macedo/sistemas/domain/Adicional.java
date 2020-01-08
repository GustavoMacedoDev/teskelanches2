package br.com.macedo.sistemas.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "adicional")
public class Adicional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_adicional")
	private Long idAdicional;
	
	@Column(name = "descricao")
	private String descricao;
	

	@Column(name = "valor_adicional")
	private double valorAdicional;
	
	@OneToMany(mappedBy = "adicional")
	private List<DetalheAdicional> detalheAdicionais;
	
	
	public Adicional() {
		// TODO Auto-generated constructor stub
	}


	public Long getIdAdicional() {
		return idAdicional;
	}


	public void setIdAdicional(Long idAdicional) {
		this.idAdicional = idAdicional;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public double getValorAdicional() {
		return valorAdicional;
	}


	public void setValorAdicional(double valorAdicional) {
		this.valorAdicional = valorAdicional;
	}


	public List<DetalheAdicional> getDetalheAdicionais() {
		return detalheAdicionais;
	}


	public void setDetalheAdicionais(List<DetalheAdicional> detalheAdicionais) {
		this.detalheAdicionais = detalheAdicionais;
	}
	
}
