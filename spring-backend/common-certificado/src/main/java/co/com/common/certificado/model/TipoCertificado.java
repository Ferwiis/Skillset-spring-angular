package co.com.common.certificado.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tipos_certificado")
public class TipoCertificado implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 10, max = 20, message = "Lo siento, el tipo de certificado debe ser de un nombre de entre 10 a 20 caracteres")
	private String nom_tipo;
	private byte[] plantilla;
	
	public Long getId() {
		return id;
	}
	public void setTipo_cert(Long id) {
		this.id = id;
	}
	public String getNom_tipo() {
		return nom_tipo;
	}
	public void setNom_tipo(String nom_tipo) {
		this.nom_tipo = nom_tipo;
	}
	public byte[] getPlantilla() {
		return plantilla;
	}
	public void setPlantilla(byte[] plantilla) {
		this.plantilla = plantilla;
	}
	
	

}
