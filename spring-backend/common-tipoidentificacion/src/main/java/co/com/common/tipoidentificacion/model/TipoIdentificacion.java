package co.com.common.tipoidentificacion.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tipos_identificacion")
public class TipoIdentificacion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	@Size(min = 4, max = 15)
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
