package br.com.sisbrava.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sisbrava.bean.Notificacao;
import br.com.sisbrava.interfaces.crud.ICrud;
import br.com.sisbrava.utilidades.JPAUtilMySql;

public class NotificacaoRepository implements ICrud {
	
	public static NotificacaoRepository instance;

	public static NotificacaoRepository getInstance() {
		if (NotificacaoRepository.instance == null)
			NotificacaoRepository.instance = new NotificacaoRepository();
		return NotificacaoRepository.instance;
	}
	
	@Override
	public void insert(Object object) {

		Notificacao notificacao = (Notificacao) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.persist(notificacao);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void update(Object object) {

		Notificacao notificacao = (Notificacao) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.merge(notificacao);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void delete(Object object) {

		Notificacao notificacao = (Notificacao) object;
		EntityManager em = new JPAUtilMySql().getEntityManager();
		em.getTransaction().begin();
		em.remove(em.getReference(Notificacao.class, notificacao.getId()));
		em.getTransaction().commit();
		em.close();

	}
	
	public Object getSelectOneObject(Integer id) {
		
		Notificacao notificacao = new Notificacao();
		
		try {
			EntityManager em = new JPAUtilMySql().getEntityManager();
			em.getTransaction().begin();
			notificacao = em.find(Notificacao.class, id);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return notificacao;
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