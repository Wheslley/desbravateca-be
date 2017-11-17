package br.com.sisbrava.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sisbrava.bean.EventoNotificacaoUsuario;
import br.com.sisbrava.interfaces.crud.ICrud;
import br.com.sisbrava.utilidades.JPAUtilMySql;

public class EventoNotificacaoUsuarioRepository implements ICrud{
	
	public static EventoNotificacaoUsuarioRepository instance;

	public static EventoNotificacaoUsuarioRepository getInstance() {
		if (EventoNotificacaoUsuarioRepository.instance == null)
			EventoNotificacaoUsuarioRepository.instance = new EventoNotificacaoUsuarioRepository();
		return EventoNotificacaoUsuarioRepository.instance;
	}
	
	@Override
	public void insert(Object object) {

		EventoNotificacaoUsuario enUsuario = (EventoNotificacaoUsuario) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.persist(enUsuario);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void update(Object object) {

		EventoNotificacaoUsuario enUsuario = (EventoNotificacaoUsuario) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.merge(enUsuario);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void delete(Object object) {

		EventoNotificacaoUsuario enUsuario = (EventoNotificacaoUsuario) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.remove(em.getReference(EventoNotificacaoUsuario.class, enUsuario.getId()));
		em.getTransaction().commit();
		em.close();

	}
	
	public Object getSelectOneObject(Integer id) {
		
		EventoNotificacaoUsuario enUsuario = new EventoNotificacaoUsuario();
		
		try {
			EntityManager em = new JPAUtilMySql().getEntityManager();
			em.getTransaction().begin();
			enUsuario = em.find(EventoNotificacaoUsuario.class, id);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return enUsuario;
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
