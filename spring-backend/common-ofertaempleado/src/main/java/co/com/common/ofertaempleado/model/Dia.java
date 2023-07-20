package co.com.common.ofertaempleado.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "dias")
public class Dia implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "No puede ser vacio")
	@Size(min = 5, max = 9, message = "Lo siento, el nombre del dia a ingresar debe ser entre 5 a 9 caracteres")
	private String nombre_dia;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre_dia() {
		return nombre_dia;
	}
	public void setNombre_dia(String nombre_dia) {
		this.nombre_dia = nombre_dia;
	}
	
	

}
