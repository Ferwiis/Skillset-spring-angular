package co.com.common.ofertaempleado.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

import co.com.common.tipoidentificacion.model.TipoIdentificacion;
import co.com.common.usuario.model.Usuario;

@Entity
@Table(name = "empleados")
public class Empleado implements Serializable
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
	@JoinColumn(name="empresa")
	@ManyToOne(cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Empresa empresa;
	@ManyToOne
	@JoinColumn(name="tipo_id")
	private TipoIdentificacion tipo_id;
	@Digits(integer = 10, fraction = 0)
	private Long num_id;
	@NotEmpty(message = "No puede ser vacio")
	@Size(min = 3, max = 25, message = "el número de caracteres debe estar entre 3 y 25")
	@Pattern(regexp = "^[A-ZÑ]((([a-zñ]{2,}\\s)[A-ZÑ]([a-zñ]{2,}))|([a-zñ]{2,}))$", message = "Solo se aceptan letras")
	private String nombre;
	@NotEmpty(message = "No puede ser vacio")
	@Size(min = 3, max = 25, message = "el número de caracteres debe estar entre 3 y 25")
	@Pattern(regexp = "^[A-ZÑ]((([a-zñ]{2,}\\s)[A-ZÑ]([a-zñ]{2,}))|([a-zñ]{2,}))$", message = "Solo se aceptan letras")
	private String apellido;
//	@Temporal(TemporalType.DATE)
//	private Date fecha_nac;
	@Size(min = 1, max = 35, message = "el número de caracteres debe estar entre 3 y 35")
	@NotEmpty(message = "No puede ser vacio")
	private String ciudad;
	@NotEmpty(message = "No puede ser vacio")
	@Size(min = 1, max = 35, message = "el número de caracteres debe estar entre 3 y 35")
	private String localidad;
	@NotEmpty(message = "No puede ser vacio")
	@Size(min = 1, max = 35, message = "el número de caracteres debe estar entre 3 y 35")
	private String direccion;
	@Min(value = 300000000)
	@Max(value = 399999999)
	@Column(unique=true)
	private Integer telefono;
	private byte[] tarj_pro;
	
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
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public TipoIdentificacion getTipo_id() {
		return tipo_id;
	}
	public void setTipo_id(TipoIdentificacion tipo_id) {
		this.tipo_id = tipo_id;
	}
	public Long getNum_id() {
		return num_id;
	}
	public void setNum_id(Long num_id) {
		this.num_id = num_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public byte[] getTarj_pro() {
		return tarj_pro;
	}
	public void setTarj_pro(byte[] tarj_pro) {
		this.tarj_pro = tarj_pro;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}