package com.example.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entities.Adviser;
import com.example.entities.Servicio;
import com.example.entities.ServicioXAdviser;
import com.example.service.AdviserService;
import com.example.service.ServicioService;
import com.example.service.ServicioXAdviserService;

@Controller
@RequestMapping("/servicesxadvisers")
public class ServiceXAdviserController {

	@Autowired
	private ServicioXAdviserService sxaService;

	@Autowired
	private ServicioService servicioService;

	@Autowired
	private AdviserService adviserService;

	

	@GetMapping("/list")
	public String showAllSxA(Model model) {
		
		
		try {
			model.addAttribute("sxa", new ServicioXAdviser());
			model.addAttribute("sxa_collection", sxaService.getAllSxA());
			
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/views/advisers/list";
	}

	@GetMapping("/new")
	public String saveSxA(Model model) {
		
		List<Adviser> listAdvisers = adviserService.listarAdviser();
		List<Servicio> listServices = servicioService.getAllServices();

		model.addAttribute("titulo", "Registro de servicios por asesor");
		model.addAttribute("sxa", new ServicioXAdviser());
		model.addAttribute("advisers", listAdvisers);
		model.addAttribute("services", listServices);
		return "views/advisers/form";
	}

	@PostMapping("/save")
	public String saveAdvisory(@Validated ServicioXAdviser sxa, BindingResult result, Model model)
			throws Exception {
		
		List<Adviser> listAdvisers = adviserService.listarAdviser();
		List<Servicio> listServices = servicioService.getAllServices();
		
		if (result.hasErrors()) {

			model.addAttribute("advisers", listAdvisers);
			model.addAttribute("services", listServices);
			System.out.println("Hay errores en el formulario");
			return "views/advisers/form";
		} else {
			
			DateFormat dateFormat1 = new SimpleDateFormat("HH:mm a", Locale.ENGLISH);
			DateFormat dateFormat2 = new SimpleDateFormat("HH:mm a", Locale.ENGLISH);
			Date d1 = dateFormat1.parse(sxa.getHoraInicio());
			Date d2 = dateFormat2.parse(sxa.getHoraFin());
			System.out.println(d1);
			System.out.println(d2);
			System.out.println("HORARIOS SELECCIONADOS");
			
			if (d1.before(d2)) {
				int horita= sxaService.validarHora(d1, d2);
				
				if(horita == 1) {
					System.out.println("HORA INICIO ANTES DE HORA FIN - OK");
					sxaService.saveSxA(sxa);
					model.addAttribute("advisers", listAdvisers);
					model.addAttribute("services", listServices);
					model.addAttribute("listServicesxAdvisers", sxaService.getAllSxA());
					System.out.println("Servicio registrado con éxito");
					return "redirect:/servicesxadvisers/list";
				} else {
					model.addAttribute("sxa", sxa);
					model.addAttribute("mensaje", "La diferencia horaria entre el inicio y fin debe de ser mínimo 2h y máximo 4h");
					model.addAttribute("advisers", listAdvisers);
					model.addAttribute("services", listServices);
					System.out.println("Servicio registrado con errores de diferencia");
					return "views/advisers/form";
				}
					

			} else {
				model.addAttribute("sxa", sxa);
				model.addAttribute("mensaje", "La hora de inicio debe ser antes de la hora fin");
				model.addAttribute("advisers", listAdvisers);
				model.addAttribute("services", listServices);
				System.out.println("Hay errores de orden de horarios en el form");
				return "views/advisers/form";
			}

		}

	}

	@RequestMapping("/edit/{id}")
	public String editSxA(@PathVariable("id") Long idsxa, Model model) {

		ServicioXAdviser sxa = sxaService.FindById(idsxa);
		List<Adviser> listAdvisers = adviserService.listarAdviser();
		List<Servicio> listServices = servicioService.getAllServices();

		model.addAttribute("titulo", "Editar servicios del asesor");
		model.addAttribute("sxa", sxa);
		model.addAttribute("advisers", listAdvisers);
		model.addAttribute("services", listServices);
		return "/views/advisers/form";
	}

	@RequestMapping("/delete/{id}")
	public String deleteSxA(@PathVariable("id") Long idsxa) {

		sxaService.DeleteSxA(idsxa);

		return "redirect:/servicesxadvisers/list";
	}


}
