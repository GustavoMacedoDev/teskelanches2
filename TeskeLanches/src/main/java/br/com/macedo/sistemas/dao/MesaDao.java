package br.com.macedo.sistemas.dao;

import java.util.List;

import br.com.macedo.sistemas.domain.Mesa;

public interface MesaDao {

	void salvar(Mesa mesa);
	
	void editar(Mesa mesa);
	
	void inativa(Long id);
	
	Mesa getId(Long id);
	
	List<Mesa> getTodos();
	
}
