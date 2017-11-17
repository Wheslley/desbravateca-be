package br.com.sisbrava.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sisbrava.bean.EventoPossuiCep;
import br.com.sisbrava.interfaces.crud.ICrud;
import br.com.sisbrava.utilidades.JPAUtilMySql;

public class EventoPossuiCepRepository implements ICrud{
	
	public static EventoPossuiCepRepository instance;

	public static EventoPossuiCepRepository getInstance() {
		if (EventoPossuiCepRepository.instance == null)
			EventoPossuiCepRepository.instance = new EventoPossuiCepRepository();
		return EventoPossuiCepRepository.instance;
	}
	
	@Override
	public void insert(Object object) {

		EventoPossuiCep epCep = (EventoPossuiCep) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.persist(epCep);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void update(Object object) {

		EventoPossuiCep epCep = (EventoPossuiCep) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.merge(epCep);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void delete(Object object) {

		EventoPossuiCep epCep = (EventoPossuiCep) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.remove(em.getReference(EventoPossuiCep.class, epCep.getId()));
		em.getTransaction().commit();
		em.close();

	}
	
	public Object getSelectOneObject(Integer id) {
		
		EventoPossuiCep epCep = new EventoPossuiCep();
		
		try {
			EntityManager em = new JPAUtilMySql().getEntityManager();
			em.getTransaction().begin();
			epCep = em.find(EventoPossuiCep.class, id);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return epCep;
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
