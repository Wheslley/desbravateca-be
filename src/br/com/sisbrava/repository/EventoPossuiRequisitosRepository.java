package br.com.sisbrava.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sisbrava.bean.EventoPossuiRequisitos;
import br.com.sisbrava.interfaces.crud.ICrud;
import br.com.sisbrava.utilidades.JPAUtilMySql;

public class EventoPossuiRequisitosRepository implements ICrud{
	
	public static EventoPossuiRequisitosRepository instance;

	public static EventoPossuiRequisitosRepository getInstance() {
		if (EventoPossuiRequisitosRepository.instance == null)
			EventoPossuiRequisitosRepository.instance = new EventoPossuiRequisitosRepository();
		return EventoPossuiRequisitosRepository.instance;
	}
	
	@Override
	public void insert(Object object) {

		EventoPossuiRequisitos epRequisito = (EventoPossuiRequisitos) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.persist(epRequisito);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void update(Object object) {

		EventoPossuiRequisitos epRequisito = (EventoPossuiRequisitos) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.merge(epRequisito);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void delete(Object object) {

		EventoPossuiRequisitos epRequisito = (EventoPossuiRequisitos) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.remove(em.getReference(EventoPossuiRequisitos.class, epRequisito.getId()));
		em.getTransaction().commit();
		em.close();

	}
	
	public Object getSelectOneObject(Integer id) {
		
		EventoPossuiRequisitos epRequisito = new EventoPossuiRequisitos();
		
		try {
			EntityManager em = new JPAUtilMySql().getEntityManager();
			em.getTransaction().begin();
			epRequisito = em.find(EventoPossuiRequisitos.class, id);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return epRequisito;
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
