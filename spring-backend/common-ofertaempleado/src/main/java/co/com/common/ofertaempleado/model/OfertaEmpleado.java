package co.com.common.ofertaempleado.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="oferta_empleado")
public class OfertaEmpleado implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name="oferta", updatable = false)
	private Oferta oferta;
	
	@ManyToOne
	@JoinColumn(name="empleado", updatable = false)
	private Empleado empleado;
	
	@Column
	private int asistencias;
	
	@Column
	private double nota_definitiva;
	
	@Column
	private boolean es_modificable = true;
	
	public OfertaEmpleado() {
		
	}
	
	public OfertaEmpleado(Oferta oferta, Empleado empleado) {
		this.oferta = oferta;
		this.empleado = empleado;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public int getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}

	public double getNota_definitiva() {
		return nota_definitiva;
	}

	public void setNota_definitiva(double nota_definitiva) {
		this.nota_definitiva = nota_definitiva;
	}

	public boolean getEs_modificable() {
		return es_modificable;
	}

	public void setEs_modificable(boolean es_modificable) {
		this.es_modificable = es_modificable;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
