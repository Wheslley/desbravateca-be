package br.com.sisbrava.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sisbrava.bean.Evento;
import br.com.sisbrava.interfaces.crud.ICrud;
import br.com.sisbrava.utilidades.JPAUtilMySql;

public class EventoRepository implements ICrud {
	
	public static EventoRepository instance;

	public static EventoRepository getInstance() {
		if (EventoRepository.instance == null)
			EventoRepository.instance = new EventoRepository();
		return EventoRepository.instance;
	}
	
	@Override
	public void insert(Object object) {

		Evento evento = (Evento) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.persist(evento);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void update(Object object) {

		Evento evento = (Evento) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.merge(evento);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void delete(Object object) {

		Evento evento = (Evento) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.remove(em.getReference(Evento.class, evento.getId()));
		em.getTransaction().commit();
		em.close();

	}
	
	public Object getSelectOneObject(Integer id) {
		
		Evento evento = new Evento();
		
		try {
			EntityManager em = new JPAUtilMySql().getEntityManager();
			em.getTransaction().begin();
			evento = em.find(Evento.class, id);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return evento;
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
