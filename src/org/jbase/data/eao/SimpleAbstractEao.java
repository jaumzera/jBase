package org.jbase.data.eao;

import javax.persistence.EntityManager;

import org.jbase.data.entity.Idable;

/**
 * jBase SimpleAbstractEao: classe abstrata que define os comportamentos
 * comuns entre os EAOs do sistema.
 * @author jaumzera
 * @version Feb 11th, 2011
 * 
 * @param <T> A entidade que será manipulada pelo EAO (deve estender Idable)
 * @param <E> O tipo de dado usado para o Id da EAO (deve estender Number)
 */
public abstract class SimpleAbstractEao<T extends Idable<E>, E extends Number> {
	
	//@In // somente quando estiver no projeto Seam
	private EntityManager em;
	
	public void save(T entity) {
		if(entity.getId() == null) {
			em.persist(entity);
		}
	}
}
