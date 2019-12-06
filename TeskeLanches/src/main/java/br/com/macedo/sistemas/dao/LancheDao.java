package br.com.macedo.sistemas.dao;

import java.util.List;

import br.com.macedo.sistemas.domain.Lanche;

public interface LancheDao {
	
	void salvar(Lanche lanche);
	
	void editar(Lanche lanche);
	
	void excluir(Long id);
	
	Lanche getId(Long id);
	
	List<Lanche> getTodos();
	
	List<Lanche> getByName(String nome);

	Lanche getId(Integer id);
	

}
