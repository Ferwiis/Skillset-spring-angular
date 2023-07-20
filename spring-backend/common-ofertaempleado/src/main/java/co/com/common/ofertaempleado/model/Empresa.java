package co.com.common.ofertaempleado.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.com.common.usuario.model.Usuario;
import co.com.common.tipoidentificacion.model.TipoIdentificacion;

@Entity
@Table(name = "empresas")
public class Empresa implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JoinColumn(name="usuario")
	@ManyToOne(cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Usuario usuario;
	@Pattern(regexp = "^(([0-9]{3}\\.){2})[0-9]{3}(\\-[0-9])$", message = "El formato de NIT es XXX.XXX.XXX-X donde X es cualquier número del 0 al 9")
	@Column(unique=true)
	private String nit;
	@NotEmpty(message = "No puede ser vacio")
	@Size(min = 3, max = 50, message = "el número de caracteres debe estar entre 3 y 50")
	@Column(unique=true)
	private String razon_social;
//	@Temporal(TemporalType.DATE)
//	private Date fecha_fund;
	@Min(value = 100000000)
	@Max(value = 999999999)
	@Column(unique=true)
	private Integer tel_fijo;
	private byte[] matricula_merc;
	@NotEmpty(message = "No puede ser vacio")
	@Size(min = 3, max = 25, message = "el número de caracteres debe estar entre 3 y 25")
	@Pattern(regexp = "^[A-ZÑ]((([a-zñ]{2,}\\s)[A-ZÑ]([a-zñ]{2,}))|([a-zñ]{2,}))$", message = "Solo se aceptan letras")
	private String nom_duenio;
	@NotEmpty(message = "No puede ser vacio")
	@Size(min = 3, max = 25, message = "el número de caracteres debe estar entre 3 y 25")
	@Pattern(regexp = "^[A-ZÑ]((([a-zñ]{2,}\\s)[A-ZÑ]([a-zñ]{2,}))|([a-zñ]{2,}))$", message = "Solo se aceptan letras")
	private String ape_duenio;
	@OneToOne
	@JoinColumn(name="tipo_id_duenio")
	private TipoIdentificacion tipo_id_duenio;
	@Digits(integer = 10, fraction = 0)
	private Long num_id_duenio;
//	@Temporal(TemporalType.DATE)
//	private Date fecha_nac_duenio;
	@Min(value = 300000000)
	@Max(value = 399999999)
	@Column(unique=true)
	private Integer tel_duenio;
	@NotEmpty(message = "No puede ser vacio")
	@Size(min = 3, max = 25, message = "el número de caracteres debe estar entre 3 y 25")
	@Pattern(regexp = "^[A-ZÑ]((([a-zñ]{2,}\\s)[A-ZÑ]([a-zñ]{2,}))|([a-zñ]{2,}))$", message = "Solo se aceptan letras")
	private String nom_rep;
	@Size(min = 3, max = 25, message = "el número de caracteres debe estar entre 3 y 25")
	@Pattern(regexp = "^[A-ZÑ]((([a-zñ]{2,}\\s)[A-ZÑ]([a-zñ]{2,}))|([a-zñ]{2,}))$", message = "Solo se aceptan letras")
	private String ape_rep;
	@OneToOne
	@JoinColumn(name="tipo_id_rep")
	private TipoIdentificacion tipo_id_rep;
	@Digits(integer = 10, fraction = 0)
	private Long num_id_rep;
//	@Temporal(TemporalType.DATE)
//	private Date fecha_nac_rep;
	@Min(value = 300000000)
	@Max(value = 399999999)
	@Column(unique=true)
	private Integer tel_rep;
	private byte[] tarj_pro_rep;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public Integer getTel_fijo() {
		return tel_fijo;
	}

	public void setTel_fijo(Integer tel_fijo) {
		this.tel_fijo = tel_fijo;
	}

	public byte[] getMatricula_merc() {
		return matricula_merc;
	}

	public void setMatricula_merc(byte[] matricula_merc) {
		this.matricula_merc = matricula_merc;
	}

	public String getNom_duenio() {
		return nom_duenio;
	}

	public void setNom_duenio(String nom_duenio) {
		this.nom_duenio = nom_duenio;
	}

	public String getApe_duenio() {
		return ape_duenio;
	}

	public void setApe_duenio(String ape_duenio) {
		this.ape_duenio = ape_duenio;
	}

	public TipoIdentificacion getTipo_id_duenio() {
		return tipo_id_duenio;
	}

	public void setTipo_id_duenio(TipoIdentificacion tipo_id_duenio) {
		this.tipo_id_duenio = tipo_id_duenio;
	}

	public Long getNum_id_duenio() {
		return num_id_duenio;
	}

	public void setNum_id_duenio(Long num_id_duenio) {
		this.num_id_duenio = num_id_duenio;
	}

	public Integer getTel_duenio() {
		return tel_duenio;
	}

	public void setTel_duenio(Integer tel_duenio) {
		this.tel_duenio = tel_duenio;
	}

	public String getNom_rep() {
		return nom_rep;
	}

	public void setNom_rep(String nom_rep) {
		this.nom_rep = nom_rep;
	}

	public String getApe_rep() {
		return ape_rep;
	}

	public void setApe_rep(String ape_rep) {
		this.ape_rep = ape_rep;
	}

	public TipoIdentificacion getTipo_id_rep() {
		return tipo_id_rep;
	}

	public void setTipo_id_rep(TipoIdentificacion tipo_id_rep) {
		this.tipo_id_rep = tipo_id_rep;
	}

	public Long getNum_id_rep() {
		return num_id_rep;
	}

	public void setNum_id_rep(Long num_id_rep) {
		this.num_id_rep = num_id_rep;
	}

	public Integer getTel_rep() {
		return tel_rep;
	}

	public void setTel_rep(Integer tel_rep) {
		this.tel_rep = tel_rep;
	}

	public byte[] getTarj_pro_rep() {
		return tarj_pro_rep;
	}

	public void setTarj_pro_rep(byte[] tarj_pro_rep) {
		this.tarj_pro_rep = tarj_pro_rep;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
