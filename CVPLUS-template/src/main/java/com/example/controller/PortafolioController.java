package com.example.controller;

import com.example.entities.Portafolio;
import com.example.service.EmpresaService;
import com.example.service.PortafolioService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/portafolios")
public class PortafolioController {
	
	private EmpresaService empresaService;
	private PortafolioService portafolioService;
	
	public PortafolioController(EmpresaService empresaService,PortafolioService portafolioService) {
		this.empresaService=empresaService;
		this.portafolioService=portafolioService;
	}
	
	
	@GetMapping
	public String homep(Model model) {
		model.addAttribute("portafolios",portafolioService.getAllPorta());
		return "portafolios/list";
	}
	
	
	
	@GetMapping("/comment/{id}")
	public String commentPortafolioForm(@PathVariable("id")long id,Model model) {
		Portafolio portafolio=portafolioService.getPortafolioById(id);
		System.out.println(portafolio.getNombre());
		model.addAttribute("portafolio",portafolio);
		return "portafolios/comment";
	}
	
	@GetMapping("/visual/{id}")
	public String visualPortafolioForm(@PathVariable("id")long id,Model model) {
		Portafolio portafolio=portafolioService.getPortafolioById(id);
		System.out.println(portafolio.getNombre());
		model.addAttribute("portafolio",portafolio);
		return "portafolios/visual";
	}
	
	
	@PostMapping("/update/{id}")
	public String updateEvaluacionPortafolio(@PathVariable("id") long id,Portafolio portafolio) {
		portafolioService.update(id,portafolio);
		
		return "redirect:/portafolios";
	}
	
	@GetMapping("/ordenarValoracion")
	public String home2(Model model) {
		model.addAttribute("portafolios",portafolioService.getAllPortafoliosByValoracion());
		return "portafolios/list";
	}

	@GetMapping("/ordenarNombre")
	public String home3(Model model) {
		model.addAttribute("portafolios",portafolioService.getAllPortafolios());
		return "portafolios/list";
	}

	@GetMapping("/ordenarCodigo")
	public String home4(Model model) {
		model.addAttribute("portafolios",portafolioService.getAllPortafoliosById());
		return "portafolios/list";
	}

	
	@PostMapping("/buscar")
	public String buscarValoracion(Model model,@ModelAttribute Portafolio portafolio) {
		model.addAttribute("portafolio", portafolioService.buscarPortafolioByValoracion(portafolio.getValoracion()));
		return "portafolios/list";
	}
	
}