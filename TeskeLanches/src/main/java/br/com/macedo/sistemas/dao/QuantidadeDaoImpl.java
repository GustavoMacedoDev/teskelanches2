package br.com.macedo.sistemas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.macedo.sistemas.domain.Mesa;
import br.com.macedo.sistemas.domain.Quantidade;

@Repository
@Transactional
public class QuantidadeDaoImpl implements QuantidadeDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void salvar(Quantidade quantidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(Quantidade quantidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inativa(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Quantidade getId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Quantidade> getTodos() {
		String jpql = "from Quantidade m";
		TypedQuery<Quantidade> query = entityManager.createQuery(jpql, Quantidade.class);
		return query.getResultList();
	}

}
