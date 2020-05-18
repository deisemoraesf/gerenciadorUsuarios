package com.akatsukidevs.gerenciadorusuarios.controller;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.akatsukidevs.gerenciadorusuarios.model.Papeis;
import com.akatsukidevs.gerenciadorusuarios.model.Usuario;
import com.akatsukidevs.gerenciadorusuarios.repository.PapeisRepository;
import com.akatsukidevs.gerenciadorusuarios.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository ur;
	
	@Autowired
	private PapeisRepository pr;
	
	@GetMapping("/usuarios")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("usuarios");
		List<Usuario> usuarios = ur.findAll();
		mv.addObject("usuarios", usuarios);		
		return mv;
	}
	
	@GetMapping("/usuarios/remover/{id}")
	public String deletarUsuario(@PathVariable ("id") Long id, RedirectAttributes attribute) {
		Optional<Usuario> u = ur.findById(id);
		Usuario usuario = u.get();
		ur.delete(usuario);
		attribute.addFlashAttribute("mensagemSucesso", "Deletado com sucesso");
		return ("redirect:/usuarios");
		
	}
	
	@GetMapping(value="/usuarios/editar/{id}")
	public ModelAndView editarUsuario(@PathVariable ("id") Long id, RedirectAttributes attribute ) {
		ModelAndView mv = new ModelAndView("editUsuario");
		Optional<Usuario> u = ur.findById(id);
		List<Papeis> p = pr.findAll();
		Usuario usu = u.get();
		mv.addObject("usuario", usu);
		mv.addObject("papeis", p);
		return mv;
		
	}
	
	@PostMapping(value="/usuarios/editar/{id}")
	public String salvaEdicao(@Valid Usuario u, RedirectAttributes attribute) {
		ur.save(u);
		attribute.addFlashAttribute("mensagemSucesso", "Editado com Sucesso");
		return ("redirect:/usuarios");
	}
	
	@GetMapping("/usuarios/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView("cadUsuario");
		List<Papeis> papeis = pr.findAll();
		mv.addObject("papeis", papeis);
		return mv;
	}
	
	@PostMapping(value="/usuarios/cadastrar")
	public String salvar(@Valid Usuario usuario, Papeis papeis, BindingResult result, RedirectAttributes attribute) {
		
		if(result.hasErrors()) {
			attribute.addFlashAttribute("mensagemErro", "Verifique os campos em branco"); 
		}
		usuario.setCadastro(LocalDate.now());
		ur.save(usuario);
		Set<Papeis> p = new HashSet<>();
		p.add(papeis);
		papeis.setUsuario(usuario);
		usuario.setPapel(p);
				
		attribute.addFlashAttribute("mensagemSucesso", "Salvo com sucesso");
		return ("redirect:/usuarios");
	}
	
}
