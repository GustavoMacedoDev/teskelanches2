package br.com.macedo.sistemas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.macedo.sistemas.domain.Lanche;

@Repository
@Transactional
public class LancheDaoImpl implements LancheDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void salvar(Lanche lanche) {
		entityManager.persist(lanche);
		
	}

	@Override
	public void editar(Lanche lanche) {
		entityManager.merge(lanche);
	}

	
	@Override
	public void excluir(Long id) {
		entityManager.remove(entityManager.getReference(Lanche.class, id));
	}

	@Transactional(readOnly = true)
	@Override
	public Lanche getId(Long id) {
		String jpql = "from Lanche l where l.id = :id";
        TypedQuery<Lanche> query = entityManager.createQuery(jpql, Lanche.class);
        query.setParameter("id", id);
        return query.getSingleResult();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Lanche> getTodos() {
		String jpql = "from Lanche l";
		TypedQuery<Lanche> query = entityManager.createQuery(jpql, Lanche.class);
		
		return query.getResultList();
		
	}

	@Override
	public List<Lanche> getByName(String nome) {
		return null;
	}

	@Override
	public Lanche getId(Integer id) {
		String jpql = "from Lanche l where l.id = :id";
        TypedQuery<Lanche> query = entityManager.createQuery(jpql, Lanche.class);
        query.setParameter("id", id);
        return query.getSingleResult();
	}

	@Override
	public List<Lanche> getByLancamento(Long id) {
		String jpql = "select l from Lanche l JOIN l.lancamentos lan where lan.id = :id";
		TypedQuery<Lanche> query = entityManager.createQuery(jpql, Lanche.class);
		query.setParameter("id", id);
		return query.getResultList();
	}
	
}
