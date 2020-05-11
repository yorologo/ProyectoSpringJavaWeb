package com.cherry.eshop.model;

import com.cherry.eshop.model.Productos;
import com.cherry.eshop.model.Ticket;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/* 
*  Java Hibernate - Model Class - TienditaJW.Compra
*  
*/
@Entity
@Table(name = "Compra")
public class Compra {

	// fields
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int m_id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDproduto", nullable = false)
	private Productos productos;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDticket", nullable = false)
	private Ticket ticket;

	@Column(name = "Cantidad")
	private int m_Cantidad;

	/**
	 * Constructor
	 * 
	 * Example: Compra myCompra = new Compra();
	 */
	public Compra() {
		// empty constructor
	}

	/**
	 * Constructor
	 * 
	 * Example: Compra myCompra = new Compra( val1, val2,.. );
	 */
	public Compra(int id, Productos productos, Ticket ticket, int Cantidad) {
		this.setId(id);
		this.setProductos(productos);
		this.setTicket(ticket);
		this.setCantidad(Cantidad);
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

	public Productos getProductos() {
		return this.productos;
	}

	public void setProductos(Productos productos) {
		this.productos = productos;
	}

	public Ticket getTicket() {
		return this.ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public int getCantidad() {
		return this.m_Cantidad;
	}

	public void setCantidad(int Cantidad) {
		this.m_Cantidad = Cantidad;
	}

	/**
	 * Methods
	 */

	@Override
	public String toString() {
		return "";
	}

}