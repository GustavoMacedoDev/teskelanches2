package br.com.macedo.sistemas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.macedo.sistemas.domain.Bebida;

@Repository
@Transactional
public class BebidaDaoImpl implements BebidaDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void salvar(Bebida bebida) {
		entityManager.persist(bebida);
	}

	@Override
	public void editar(Bebida bebida) {
		entityManager.merge(bebida);
	}

	@Override
	public void inativa(Long id) {
		Bebida bebida = new Bebida();
		bebida.setStatus(false);
		entityManager.merge(entityManager.getReference(Bebida.class, id));
	}

	@Override
	@Transactional(readOnly = true)
	public Bebida getId(Long id) {
		String jpql = "from Bebida b where b.id = :id";
        TypedQuery<Bebida> query = entityManager.createQuery(jpql, Bebida.class);
        query.setParameter("id", id);
        return query.getSingleResult();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Bebida> getTodos() {
		String jpql = "from Bebida b";
		TypedQuery<Bebida> query = entityManager.createQuery(jpql, Bebida.class);
		return query.getResultList();
	}

	@Override
	public List<Bebida> getByName(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
