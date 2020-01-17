package br.com.macedo.sistemas.dao;

import java.util.List;

import br.com.macedo.sistemas.domain.Quantidade;


public interface QuantidadeDao {

	void salvar(Quantidade quantidade);
	
	void editar(Quantidade quantidade);
	
	void inativa(Long id);
	
	Quantidade getId(Long id);
	
	List<Quantidade> getTodos();
	
}
