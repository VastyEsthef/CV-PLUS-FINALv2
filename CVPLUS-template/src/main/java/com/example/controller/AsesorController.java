package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entities.Asesor;
import com.example.service.AsesorService;
import com.example.service.RubroService;

@Controller
@RequestMapping("/asesors")
public class AsesorController {

	@Autowired
	private AsesorService asesorService;

	@Autowired
	private RubroService rubroService;

	@GetMapping("/nuevo")
	public String registrarAsesor(Model model) {
		model.addAttribute("asesor", new Asesor());
		model.addAttribute("rubros", rubroService.listarRubros());
		return "asesor/form";
	}

	@GetMapping
	public String listarAsesores(Model model) {
		model.addAttribute("asesor", new Asesor());
		model.addAttribute("asesores", asesorService.listarAsesores());
		return "asesor/list";
	}

	@PostMapping("/registrar")
	public String registrarAsesor(@Validated @ModelAttribute Asesor asesor, BindingResult result, Model model) {
		int rpta;

		if (result.hasErrors()) {
			model.addAttribute("rubros", rubroService.listarRubros());
			return "asesor/form";
		}

		rpta = asesorService.registrarAsesor(asesor);

		if (rpta > 0) {
			model.addAttribute("mensaje", "El numero de dni ya existe. Por favor, ingrese uno nuevo!");
			model.addAttribute("rubros", rubroService.listarRubros());

		} else {
			model.addAttribute("mensaje", "Exito. Se registro nuevo asesor");
			model.addAttribute("asesor", new Asesor());
			model.addAttribute("rubros", rubroService.listarRubros());
		}

		return "asesor/form";
	}

	@PostMapping("/buscar")
	public String buscarAsesor(Model model, @ModelAttribute Asesor asesor) {
		model.addAttribute("asesores", asesorService.buscarAsesorPorDni(asesor.getDni()));
		return "asesor/list";
	}

}
