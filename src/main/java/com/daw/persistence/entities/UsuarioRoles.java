package com.daw.persistence.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_roles")
public class UsuarioRoles {

	@Id
	private long id_rol;
	@Id
	private String role;
	@Column(name = "granted_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime granted_date;
	@ManyToOne
	@JoinColumn(name = "id_rol", referencedColumnName = "id_usuario", insertable = false, updatable = false)
	private Usuario usuario;

	public long getId_rol() {
		return id_rol;
	}

	public void setId_rol(long id_rol) {
		this.id_rol = id_rol;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDateTime getGranted_date() {
		return granted_date;
	}

	public void setGranted_date(LocalDateTime granted_date) {
		this.granted_date = granted_date;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
