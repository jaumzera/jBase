package org.jbase.data.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.brcont.centralbalancos.entity.Endereco;

/**
 * jBase BaseEntity: classe abstrata que define os atributos e comportamentos
 * comuns das entidades. Basicamente, todas as classes deverão apresentar um Id
 * numérico, uma data para determinar o dia do cadastro e uma data para
 * determinar quando ela foi desativada, se for o caso.
 * 
 * @author jaumzera
 * @version Feb 10th, 2011
 */
@MappedSuperclass
public abstract class AbstractBaseEntity<T extends Number> implements
		Idable<T>, Serializable {

	/* Número serial da classe */
	// TODO: pensar em um padrão para isso
	private static final long serialVersionUID = 1L;

	/* Data de ativação (criação) da entidade */
	@Column(name = "date_on")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOn = new Date();

	/* Data de desativação da entidade */
	@Column(name = "date_off")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOff = new Date();

	/**
	 * Sobrescrita padrão do método {@link java.lang.Object#hashCode()} NOTE: só
	 * funciona se a classe possuir um Id.
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	/**
	 * Sobrescrita padrão do método {@link java.lang.Object#equals(Object)}
	 * NOTE: só funciona se a classe comparada implementar Idable.
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		if (obj instanceof Idable == false)
			return false;
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Idable<T> other = (Idable<T>) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	/**
	 * Sobrescreve de forma padrão o método java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass() + "[id=" + getId() + "]";
	}

	/**
	 * Retorna a classe entidade herdada
	 * 
	 * @return Class<? extends AbstractBaseEntity<T>>
	 */
	@SuppressWarnings("unchecked")
	public Class<? extends AbstractBaseEntity<T>> getEntityClass() {
		return (Class<? extends AbstractBaseEntity<T>>) this.getClass();
	}

	/**
	 * Retorna o nome completo da entidade (com o namespace do pacote)
	 * 
	 * @return String
	 */
	public String getEntityFullName() {
		return this.getClass().getName();
	}

	/**
	 * Retorna o nome simples da entidade (sem o namespace do pacote)
	 * 
	 * @return String
	 */
	public String getEntitySimpleName() {
		return this.getClass().getSimpleName();
	}

	/**
	 * Configura a data de criação
	 * 
	 * @param dateOn
	 */
	public void setDateOn(Date dateOn) {
		this.dateOn = dateOn;
	}

	/**
	 * Retorna a data de criação
	 * 
	 * @return date
	 */
	public Date getDateOn() {
		return dateOn;
	}

	/**
	 * Configura a data de desativação
	 * 
	 * @param dateOff
	 */
	public void setDateOff(Date dateOff) {
		this.dateOff = dateOff;
	}

	/**
	 * Retorna a data de desativação
	 * 
	 * @return the dateOff
	 */
	public Date getDateOff() {
		return dateOff;
	}
}
