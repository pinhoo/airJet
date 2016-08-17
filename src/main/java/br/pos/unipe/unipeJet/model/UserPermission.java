package br.pos.unipe.unipeJet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_roles")
public class UserPermission {
	
	public UserPermission() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String role;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UserPermission(Long id, String role) {
		super();
		this.id = id;
		this.role = role;
	}
	
	public UserPermission(Long id, String role, Usuario usuario) {
		super();
		this.id = id;
		this.role = role;
		this.usuario = usuario;
	}
	
	
	
}
