package br.com.macedo.sistemas.domain;

import javax.persistence.*;

@Entity
@Table(name = "itens_pedido")
public class ItensPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_itens_pedido")
	private Long idItensPedido;

	@Column(name = "quantidade")
	private int quantidade;
	
	@Column(name = "valor_unitario")
	private double valorUnitario;
	
	@Column(name = "valor_total")
	private double valorTotal;
	
	@ManyToOne
	private Pedido pedido;
	
	@ManyToOne
	private Produto produto;
	
	public ItensPedido() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdItensPedido() {
		return idItensPedido;
	}

	public void setIdItensPedido(Long idItensPedido) {
		this.idItensPedido = idItensPedido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
