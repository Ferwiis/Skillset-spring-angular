package co.com.common.curso.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tipos_curso")
public class TipoCurso implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 4, max = 20, message = "Lo siento, el nombre del tipo de curso, debe tener mínimo 4 caracteres y máximo 20 caracteres")
	private String nom_tipo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom_tipo() {
		return nom_tipo;
	}
	public void setNom_tipo(String nom_tipo) {
		this.nom_tipo = nom_tipo;
	}
}