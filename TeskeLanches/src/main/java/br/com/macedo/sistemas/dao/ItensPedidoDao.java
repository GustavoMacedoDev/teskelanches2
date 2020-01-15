package br.com.macedo.sistemas.dao;

import java.util.List;

import br.com.macedo.sistemas.domain.ItensPedido;


public interface ItensPedidoDao {


	void salvar(ItensPedido itensPedido);
	
	void editar(ItensPedido itensPedido);
	
	void inativa(Long id);
	
	ItensPedido getId(Long id);
	
	List<ItensPedido> getTodos();
	
	
}
