package co.com.common.ofertaempleado.model;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "horarios")
public class Horario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonIgnoreProperties
	@ManyToOne
	@JoinColumn(name = "dia")
	private Dia dia;
	private LocalTime hora_inicio;
	private LocalTime  hora_fin;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Dia getDia() {
		return dia;
	}
	public void setDia(Dia dia) {
		this.dia = dia;
	}
	public LocalTime getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(LocalTime hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public LocalTime getHora_fin() {
		return hora_fin;
	}
	public void setHora_fin(LocalTime hora_fin) {
		this.hora_fin = hora_fin;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}