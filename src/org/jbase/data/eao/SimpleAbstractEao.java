package org.jbase.data.eao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jbase.data.entity.AbstractBaseEntity;

/**
 * jBase SimpleAbstractEao: classe abstrata que define os comportamentos
 * comuns entre os EAOs do sistema.
 * @author jaumzera
 * @version Feb 11th, 2011
 * 
 * @param <T> A entidade que será manipulada pelo EAO (deve estender Idable)
 * @param <E> O tipo de dado usado para o Id da EAO (deve estender Number)
 */
public abstract class SimpleAbstractEao<T extends AbstractBaseEntity<E>, E extends Number> {
	
	//@PersistenceContext
	protected EntityManager em;
	
	public void save(T entity) {
		if(entity.getId() == null) {
			em.persist(entity);
		}
	}
	
	/**
	 * Retorna a entidade a partir do id
	 * @param id
	 * @return T
	 */
	public abstract T get(E id);
	
	public abstract List<T> list();
	
	public abstract List<T> list(Date begin, Date end);

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
}
