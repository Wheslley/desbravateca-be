package br.com.sisbrava.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sisbrava.bean.ClubePossuiCep;
import br.com.sisbrava.interfaces.crud.ICrud;
import br.com.sisbrava.utilidades.JPAUtilMySql;

public class ClubePossuiCepRepository implements ICrud{
	
	public static ClubePossuiCepRepository instance;

	public static ClubePossuiCepRepository getInstance() {
		if (ClubePossuiCepRepository.instance == null)
			ClubePossuiCepRepository.instance = new ClubePossuiCepRepository();
		return ClubePossuiCepRepository.instance;
	}
	
	@Override
	public void insert(Object object) {

		ClubePossuiCep cpcep = (ClubePossuiCep) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.persist(cpcep);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void update(Object object) {

		ClubePossuiCep cpcep = (ClubePossuiCep) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.merge(cpcep);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void delete(Object object) {

		ClubePossuiCep cpcep = (ClubePossuiCep) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.remove(em.getReference(ClubePossuiCep.class, cpcep.getId()));
		em.getTransaction().commit();
		em.close();

	}
	
	public Object getSelectOneObject(Integer id) {
		
		ClubePossuiCep cpcep = new ClubePossuiCep();
		
		try {
			EntityManager em = new JPAUtilMySql().getEntityManager();
			em.getTransaction().begin();
			cpcep = em.find(ClubePossuiCep.class, id);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return cpcep;
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
