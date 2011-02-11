package org.jbase.data.eao;

import java.io.Serializable;
import java.util.List;

import org.jbase.data.entity.Idable;

/**
 * jBase SimpleEao: modelo padrão de Entity Access Object
 * Especifica os comportamentos básicos dos EAOs
 *  
 * @author jaumzera
 * @version Feb 10th, 2011
 * @param <E>
 */
public interface SimpleEaoInterface<T extends Idable<E>, E extends Number> extends Serializable {
	
	/**
	 * Salva a entidade T
	 */
	public void save(T entity);
	
	/**
	 * Atualiza a entidade T
	 * @param entity
	 */
	public void update(T entity);
	
	/**
	 * Recebe uma entidade detached e a retorna managed
	 * @param entity
	 * @return T
	 */
	public T merge(T entity);
	
	/**
	 * Remove a entidade T
	 * @param entity
	 */
	public void delete(T entity);
	
	/**
	 * Lista todas as entidades T 
	 * @return List<T>
	 */
	public List<T> list();
	
	/**
	 * Retorna uma entidade específica a partir do Id
	 */
	public T get(E id);
}
