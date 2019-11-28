package br.com.macedo.sistemas.domain;

import javax.persistence.*;

@Entity
@Table(name = "bebida")
public class Bebida {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 50)
	private String nome;
	
	
	private double valor;
	
	private boolean status = true;
	
	public Bebida() {
		super();
	}

	public Bebida(Long id, String nome, double valor, boolean status) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.status = status;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
