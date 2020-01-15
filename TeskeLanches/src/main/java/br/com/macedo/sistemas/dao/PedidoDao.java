package br.com.macedo.sistemas.dao;

import java.util.List;

import br.com.macedo.sistemas.domain.Pedido;


public interface PedidoDao {

	void salvar(Pedido pedido);
	
	void editar(Pedido pedido);
	
	void inativa(Long id);
	
	Pedido getId(Long id);
	
	List<Pedido> getTodos();
}
