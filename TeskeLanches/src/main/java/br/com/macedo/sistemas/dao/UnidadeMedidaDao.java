package br.com.macedo.sistemas.dao;

import java.util.List;

import br.com.macedo.sistemas.domain.UnidadeMedida;

public interface UnidadeMedidaDao {
	
	void salvar(UnidadeMedida medida);
	
	void editar(UnidadeMedida medida);
	
	void excluir(Long id);
	
	UnidadeMedida getId(Long id);
	
	List<UnidadeMedida> getTodos();
	
	List<UnidadeMedida> getByName(String nome);
	

}
