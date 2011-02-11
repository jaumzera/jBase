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
	
	
	/**
	 * Retorna uma entidade a partir do valor de uma propriedade qualquer
	 * @param field nome do campo que será utilizado para a busca
	 * @param value valor do campo que será utilizado para a busca
	 * @param exactMatch true ? %value% : value
	 * @return List<T> das entidades encontradas
	 */
	public List<T> get(String field, String value, boolean exactMatch);
}
