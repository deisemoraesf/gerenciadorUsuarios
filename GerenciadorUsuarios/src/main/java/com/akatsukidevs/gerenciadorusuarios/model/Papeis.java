package com.akatsukidevs.gerenciadorusuarios.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinTable(name = "tb_pessoa_papeis", joinColumns = @JoinColumn(name="id_usuario"),
	   inverseJoinColumns = @JoinColumn(name="id_papel"))
	private Usuario usuario;
	
	

	public Papeis() {
		
	}

	public Papeis(Long id, @NotBlank String papel) {
		this.id = id;
		this.papel = papel;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
		

}
