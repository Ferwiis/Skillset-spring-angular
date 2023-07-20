package co.com.common.curso.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cursos")
public class Curso implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 4, max = 50, message = "El nombre de curso debe ser de 4 letras mínimo y máximo, 50 letras")
	private String nombre;
	@NotNull
	@Size(min = 10,  max = 150, message = "Lo siento, el objetivo solo puede soportar 150 caracteres, minimo, un objetivo de 10 caracteres")
	private String objetivo;
	private int sesiones_semanales;
	private int sesiones_curso;
	private int horas_sesion;
	@NotNull
	private String contenidos;
	private double precio;
	@JsonIgnoreProperties
	@ManyToOne
	@JoinColumn(name = "tipo_curso")
	private TipoCurso tipo_curso;
	
	public Curso() {
		
	}
	
	public Curso(Long id, TipoCurso tipo_curso, String nombre, String objetivo, String contenidos, int horas_sesion, int sesiones_curso, int sesiones_semanales, double precio) {
		this.id = id;
		this.tipo_curso = tipo_curso;
		this.nombre = nombre;
		this.objetivo = objetivo;
		this.contenidos = contenidos;
		this.horas_sesion = horas_sesion;
		this.sesiones_curso = sesiones_curso;
		this.sesiones_semanales = sesiones_semanales;
		this.precio = precio;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public int getSesiones_semanales() {
		return sesiones_semanales;
	}
	public void setSesiones_semanales(int sesiones_semanales) {
		this.sesiones_semanales = sesiones_semanales;
	}
	public int getSesiones_curso() {
		return sesiones_curso;
	}
	public void setSesiones_curso(int sesiones_curso) {
		this.sesiones_curso = sesiones_curso;
	}
	public int getHoras_sesion() {
		return horas_sesion;
	}
	public void setHoras_sesion(int horas_sesion) {
		this.horas_sesion = horas_sesion;
	}
	public String getContenidos() {
		return contenidos;
	}
	public void setContenidos(String contenidos) {
		this.contenidos = contenidos;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public TipoCurso getTipo_curso() {
		return tipo_curso;
	}
	public void setTipo_curso(TipoCurso tipo_curso) {
		this.tipo_curso = tipo_curso;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

