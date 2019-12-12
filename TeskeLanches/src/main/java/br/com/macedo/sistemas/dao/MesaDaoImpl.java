package br.com.macedo.sistemas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.macedo.sistemas.domain.Mesa;

@Repository
@Transactional
public class MesaDaoImpl implements MesaDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void salvar(Mesa mesa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(Mesa mesa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inativa(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Mesa getId(Long id) {
		String jpql = "from Mesa m where m.id = :id";
        TypedQuery<Mesa> query = entityManager.createQuery(jpql, Mesa.class);
        query.setParameter("id", id);
        return query.getSingleResult();
	}

	@Override
	public List<Mesa> getTodos() {
		String jpql = "from Mesa m";
		TypedQuery<Mesa> query = entityManager.createQuery(jpql, Mesa.class);
		return query.getResultList();
				
	}

	@Override
	public Integer getStatus(Long id) {
		
		String jpql = "select m.statusMesa from Mesa m where m.id = :id";
		TypedQuery<Integer> query = entityManager.createQuery(jpql, Integer.class);
		query.setParameter("id", id);
		
		System.out.print(query.getSingleResult());
		
		return query.getSingleResult();
	
	}

	@Override
	public void abreMesa(Mesa mesa) {
		String jpql = "update m from Mesa set status_mesa = 1";
		
	}
	

}
