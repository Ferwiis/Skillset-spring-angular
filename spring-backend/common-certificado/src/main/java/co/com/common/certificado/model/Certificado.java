package co.com.common.certificado.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.com.common.ofertaempleado.model.Oferta;
import co.com.common.ofertaempleado.model.OfertaEmpleado;

@Entity
@Table(name = "certificados")
public class Certificado implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonIgnoreProperties
	@ManyToOne
	@JoinColumn(name = "id_oferta")
	private OfertaEmpleado oferta_empleado;
	@JsonIgnoreProperties
	@ManyToOne
	@JoinColumn(name = "tipo_cert")
	private TipoCertificado tipo_cert;
	@NotNull
	private byte[] imagen_cert;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public OfertaEmpleado getOferta_empleado() {
		return oferta_empleado;
	}
	public void setOferta_empleado(OfertaEmpleado oferta_empleado) {
		this.oferta_empleado = oferta_empleado;
	}
	public TipoCertificado getTipo_cert() {
		return tipo_cert;
	}
	public void setTipo_cert(TipoCertificado tipo_cert) {
		this.tipo_cert = tipo_cert;
	}
	public byte[] getImagen_cert() {
		return imagen_cert;
	}
	public void setImagen_cert(byte[] imagen_cert) {
		this.imagen_cert = imagen_cert;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
