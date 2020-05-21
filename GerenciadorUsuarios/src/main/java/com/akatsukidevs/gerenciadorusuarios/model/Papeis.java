package com.akatsukidevs.gerenciadorusuarios.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;


@Entity
public class Papeis implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NotBlank
	private String papel;
	
	
	
	@ManyToMany
	@JoinTable(name = "tb_usuario_papeis", joinColumns = @JoinColumn(name="id_papel"),
	   inverseJoinColumns = @JoinColumn(name="id_usuario"))
	private Set<Usuario> usuario = new HashSet<>();
	
	

	public Papeis() {
		
	}

	public Papeis(Long id, @NotBlank String papel) {
		this.id = id;
		this.papel = papel;
	}



	public Papeis(String source) {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	public Set<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(Set<Usuario> usuario) {
		this.usuario = usuario;
	}

	
	
		

}
