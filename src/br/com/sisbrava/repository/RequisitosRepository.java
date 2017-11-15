package br.com.sisbrava.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sisbrava.bean.Requisitos;
import br.com.sisbrava.interfaces.crud.ICrud;
import br.com.sisbrava.utilidades.JPAUtilMySql;

public class RequisitosRepository implements ICrud {
	
	public static RequisitosRepository instance;

	public static RequisitosRepository getInstance() {
		if (RequisitosRepository.instance == null)
			RequisitosRepository.instance = new RequisitosRepository();
		return RequisitosRepository.instance;
	}
	
	@Override
	public void insert(Object object) {

		Requisitos requisitos = (Requisitos) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.persist(requisitos);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void update(Object object) {

		Requisitos requisitos = (Requisitos) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.merge(requisitos);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void delete(Object object) {

		Requisitos requisitos = (Requisitos) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.remove(em.getReference(Requisitos.class, requisitos.getId()));
		em.getTransaction().commit();
		em.close();

	}
	
	public Object getSelectOneObject(Integer id) {
		
		Requisitos requisitos = new Requisitos();
		
		try {
			EntityManager em = new JPAUtilMySql().getEntityManager();
			em.getTransaction().begin();
			requisitos = em.find(Requisitos.class, id);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return requisitos;
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
