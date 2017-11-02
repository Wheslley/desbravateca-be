package br.com.sisbrava.utilidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sisbrava.interfaces.mensagem.IHibernate;

public class JPAUtilMySql {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(IHibernate.PERSISTENCE_UNIT_MYSQL);

    public EntityManager getEntityManager() {
         return emf.createEntityManager();
    }
    
}
