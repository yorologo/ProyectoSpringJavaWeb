package com.cherry.eshop.model;

import com.cherry.eshop.model.Compra;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/* 
*  Java Hibernate - Model Class - TienditaJW.Ticket
*  
*/
@Entity
@Table(name = "Ticket")
public class Ticket {

	// fields
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int m_id;

	@Column(name = "Fecha", nullable = false)
	private java.sql.Timestamp m_Fecha;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDticket")
	private List<Compra> compra;

	/**
	 * Constructor
	 * 
	 * Example: Ticket myTicket = new Ticket();
	 */
	public Ticket() {
		// empty constructor
	}

	/**
	 * Constructor
	 * 
	 * Example: Ticket myTicket = new Ticket( val1, val2,.. );
	 */
	public Ticket(int id, java.sql.Timestamp Fecha) {
		this.setId(id);
		this.setFecha(Fecha);
	}

	/**
	 * Getters and Setters
	 */

	public int getId() {
		return this.m_id;
	}

	public void setId(int id) {
		this.m_id = id;
	}

	public java.sql.Timestamp getFecha() {
		return this.m_Fecha;
	}

	public void setFecha(java.sql.Timestamp Fecha) {
		this.m_Fecha = Fecha;
	}

	public List<Compra> getCompra() {
		return this.compra;
	}

	public void setCompra(List<Compra> compra) {
		this.compra = compra;
	}

	/**
	 * Methods
	 */

	@Override
	public String toString() {
		return "";
	}

}