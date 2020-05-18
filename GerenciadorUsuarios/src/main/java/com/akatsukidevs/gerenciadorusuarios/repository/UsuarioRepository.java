package com.akatsukidevs.gerenciadorusuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akatsukidevs.gerenciadorusuarios.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
