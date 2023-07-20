package co.com.common.usuario.model;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="roles")
public class Rol implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int rol;
	private String nombre;
	
	public Rol() {
		
	}
	
	public Rol(int rol) {
		this.rol = rol;
	}
	
	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
