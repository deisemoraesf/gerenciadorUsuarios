package com.akatsukidevs.gerenciadorusuarios.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(unique=true)
	private String username;
	
	
	@NotEmpty
	@Column
	private String nomeCompleto;
	
	@NotEmpty
	@Column
	private String senha;
	
	@NotEmpty
	@Column
	private boolean status;
	
	@NotEmpty
	@OneToMany(mappedBy="usuario")
	private Set<Papeis> papel;
	
	@Column
	@DateTimeFormat(iso = ISO.DATE) // ISO-8601
	private LocalDate cadastro;
	
	public Usuario() {
		
	}

	
	public Usuario(Long id, @NotEmpty String username, @NotEmpty String nomeCompleto, @NotEmpty String senha,
			@NotEmpty boolean status, @NotEmpty Set<Papeis> papel, LocalDate cadastro) {
		this.id = id;
		this.username = username;
		this.nomeCompleto = nomeCompleto;
		this.senha = senha;
		this.status = status;
		this.papel = papel;
		this.cadastro = cadastro;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
	public Set<Papeis> getPapel() {
		return papel;
	}


	public void setPapel(Set<Papeis> papel) {
		this.papel = papel;
	}


	public LocalDate getCadastro() {
		return cadastro;
	}

	public void setCadastro(LocalDate cadastro) {
		this.cadastro = cadastro;
	}
	
	
	
	

}
