package br.com.macedo.sistemas.domain;


import javax.persistence.*;

@Entity
@Table(name = "detalhe_adicional")
public class DetalheAdicional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_detalhe_adicional")
	private Long idAdicional;
	
	@ManyToOne
	private Adicional adicional;
	
	public DetalheAdicional() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdAdicional() {
		return idAdicional;
	}

	public void setIdAdicional(Long idAdicional) {
		this.idAdicional = idAdicional;
	}

	public Adicional getAdicional() {
		return adicional;
	}

	public void setAdicional(Adicional adicional) {
		this.adicional = adicional;
	}

	
	
}
