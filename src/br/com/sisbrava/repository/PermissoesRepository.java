package br.com.sisbrava.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sisbrava.bean.Permissoes;
import br.com.sisbrava.interfaces.crud.ICrud;
import br.com.sisbrava.utilidades.JPAUtilMySql;

public class PermissoesRepository implements ICrud {
	
	public static PermissoesRepository instance;

	public static PermissoesRepository getInstance() {
		if (PermissoesRepository.instance == null)
			PermissoesRepository.instance = new PermissoesRepository();
		return PermissoesRepository.instance;
	}
	
	@Override
	public void insert(Object object) {

		Permissoes permissoes = (Permissoes) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.persist(permissoes);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void update(Object object) {

		Permissoes permissoes = (Permissoes) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.merge(permissoes);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void delete(Object object) {

		Permissoes permissoes = (Permissoes) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.remove(em.getReference(Permissoes.class, permissoes.getId()));
		em.getTransaction().commit();
		em.close();

	}
	
	public Object getSelectOneObject(Integer id) {
		
		Permissoes permissoes = new Permissoes();
		
		try {
			EntityManager em = new JPAUtilMySql().getEntityManager();
			em.getTransaction().begin();
			permissoes = em.find(Permissoes.class, id);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return permissoes;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> selectMultiplusObjects(String table) {

		String strQuery = "SELECT u FROM " + table + " u";

		EntityManager em = new JPAUtilMySql().getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		Query query = em.createQuery(strQuery);

		List<Object> objetos = query.getResultList();

		tx.commit();

		return objetos;

	}
	
}
