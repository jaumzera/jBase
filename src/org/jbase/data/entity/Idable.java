package org.jbase.data.entity;

import java.io.Serializable;


/**
 * jBase Idable: especifica os comportamentos mínimos para que uma entidade
 * possa ser acessada a partir de um Id.
 * 
 * @author jaumzera
 * @version Feb 10th, 2011
 * @param <T extends Number> tipo numérico do identificador 
 */
public interface Idable<T extends Number> extends Serializable {
	
	/**
	 * Atribui o id da entidade
	 * @param T id
	 */
	public void setId(T id);
	
	/**
	 * Retorna o id da entidade
	 * @return T
	 */
	public T getId();
}
