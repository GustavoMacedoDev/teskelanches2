package br.com.macedo.sistemas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.macedo.sistemas.domain.LancamentoProduto;

@Repository
@Transactional
public class LancamentoProdutoDaoImpl implements LancamentoProdutoDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void salvar(LancamentoProduto lancamentoProduto) {
		entityManager.persist(lancamentoProduto);
		
	}

	@Override
	public void editar(LancamentoProduto lancamentoProduto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inativa(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LancamentoProduto getId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LancamentoProduto> getTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
