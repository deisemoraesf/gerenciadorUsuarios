package com.akatsukidevs.gerenciadorusuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akatsukidevs.gerenciadorusuarios.model.Papeis;

public interface PapeisRepository extends JpaRepository<Papeis, Long> {
	
	Iterable<Papeis> findByPapel(String papel);

}
