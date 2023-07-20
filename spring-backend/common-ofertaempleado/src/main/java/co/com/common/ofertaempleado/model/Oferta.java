package co.com.common.ofertaempleado.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import co.com.common.curso.model.Curso;
import co.com.common.profesor.model.Profesor;

@Entity
@Table(name = "ofertas")
public class Oferta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JoinColumn(name = "curso")
	@ManyToOne(cascade = CascadeType.MERGE)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Curso curso;
	@JoinColumn(name = "profesor")
	@ManyToOne(cascade = CascadeType.MERGE)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Profesor profesor;
	@Temporal(TemporalType.DATE)
	private Date fecha_inicio;
	@Temporal(TemporalType.DATE)
	private Date fecha_fin;
	private int cupos;
	@JoinTable(name = "horario_oferta", joinColumns = @JoinColumn(name = "oferta"), inverseJoinColumns = @JoinColumn(name = "horario"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "oferta", "horario" }) })
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private List<Horario> horarios;
	
	public Oferta() {
		horarios = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public int getCupos() {
		return cupos;
	}

	public void setCupos(int cupos) {
		this.cupos = cupos;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}