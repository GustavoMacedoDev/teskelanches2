package br.com.macedo.sistemas.dao;

import java.util.List;

import br.com.macedo.sistemas.domain.Bebida;

public interface BebidaDao {

	void salvar(Bebida bebida);
	
	void editar(Bebida bebida);
	
	void inativa(Long id);
	
	Bebida getId(Long id);
	
	List<Bebida> getTodos();
	
	List<Bebida> getByName(String nome);
	
	List<Bebida> getByLancamento(Long id);
	
}
