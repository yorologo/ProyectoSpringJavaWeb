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
*  Java Hibernate - Model Class - TienditaJW.Productos
*  
*/
@Entity
@Table(name = "Productos")
public class Productos {

	// fields
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int m_id;

	@Column(name = "Nombre", nullable = false)
	private String m_Nombre;

	@Column(name = "Precio", nullable = false)
	private double m_Precio;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDproduto")
	private List<Compra> compra;

	/**
	 * Constructor
	 * 
	 * Example: Productos myProductos = new Productos();
	 */
	public Productos() {
		// empty constructor
	}

	/**
	 * Constructor
	 * 
	 * Example: Productos myProductos = new Productos( val1, val2,.. );
	 */
	public Productos(int id, String Nombre, double Precio) {
		this.setId(id);
		this.setNombre(Nombre);
		this.setPrecio(Precio);
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

	public String getNombre() {
		return this.m_Nombre;
	}

	public void setNombre(String Nombre) {
		this.m_Nombre = Nombre;
	}

	public double getPrecio() {
		return this.m_Precio;
	}

	public void setPrecio(double Precio) {
		this.m_Precio = Precio;
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