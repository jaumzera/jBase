package org.jbase.data.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * jBase BaseEntity: classe abstrata que define os atributos e comportamentos
 * comuns das entidades. 
 * Basicamente, todas as classes deverão apresentar um Id numérico, uma
 * data para determinar o dia do cadastro e uma data para determinar quando
 * ela foi desativada, se for o caso.
 * 
 * @author jaumzera
 * @version Feb 10th, 2011
 */
@MappedSuperclass
public abstract class AbstractBaseEntity<T extends Number> implements Serializable {

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
	 * Configura a data de criação
	 * @param dateOn
	 */
	public void setDateOn(Date dateOn) {
		this.dateOn = dateOn;
	}

	/** 
	 * Retorna a data de criação
	 * @return date
	 */
	public Date getDateOn() {
		return dateOn;
	}

	/**
	 * Configura a data de desativação
	 * @param dateOff 
	 */
	public void setDateOff(Date dateOff) {
		this.dateOff = dateOff;
	}

	/**
	 * Retorna a data de desativação
	 * @return the dateOff
	 */
	public Date getDateOff() {
		return dateOff;
	}
}
