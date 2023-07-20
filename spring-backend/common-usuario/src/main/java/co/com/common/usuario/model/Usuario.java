package co.com.common.usuario.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "No puede ser vacio")
	@Email(message = "No contiene un formato de correo valido")
	@Column(unique=true)
	private String correo;
	@NotEmpty(message = "No puede ser vacio")
	@Column(unique=true)
	private String nickname;
	@NotEmpty(message = "No puede ser vacio")
	private String contrasena;
	@Value("${some.key:false}")
	private boolean esta_activo;
	@Value("${some.key:false}")
	private boolean cuenta_activada;
	@JoinTable(name="usuario_roles", joinColumns = @JoinColumn(name="usuario"), 
			inverseJoinColumns = @JoinColumn(name="rol"), 
			uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario", "rol"})})
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private List<Rol> roles;
	
	
	public Usuario() {
		roles = new ArrayList<>();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public boolean getEsta_activo() {
		return esta_activo;
	}
	public void setEsta_activo(boolean esta_activo) {
		this.esta_activo = esta_activo;
	}
	public boolean getCuenta_activada() {
		return cuenta_activada;
	}
	public void setCuenta_activada(boolean cuenta_activada) {
		this.cuenta_activada = cuenta_activada;
	}
	public List<Rol> getRoles() {
		return roles;
	}
	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}