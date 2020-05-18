package com.akatsukidevs.gerenciadorusuarios.controller;

import java.util.Optional;

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
import com.akatsukidevs.gerenciadorusuarios.repository.PapeisRepository;

@Controller
public class PapeisController {
	
	@Autowired
	private PapeisRepository pr;
	
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	
	@GetMapping("/papeis")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("papeis");
		Iterable<Papeis> p = pr.findAll();
		mv.addObject("papeis", p);
		return mv;
	}
	
	@PostMapping("/papeis")
	public String salvar(@Valid Papeis p, BindingResult result, RedirectAttributes attribute) {
		if(result.hasErrors()) {
			attribute.addFlashAttribute("mensagemErro", "Verifique campos em branco.");
		}
		pr.save(p);
			attribute.addFlashAttribute("mensagemSucesso", "Salvo com Sucesso.");
		return ("redirect:/papeis");

	}
	
	@GetMapping("/papeis/remover/{id}")
	public String deletarPapeis(@PathVariable ("id") Long id, RedirectAttributes attribute) {
		Optional<Papeis> p = pr.findById(id);
		Papeis papel = p.get();
		pr.delete(papel);
		attribute.addFlashAttribute("mensagemSucesso", "Deletado com sucesso");
		return ("redirect:/papeis");
		
	}
}
