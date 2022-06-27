package com.example.controller;

import java.text.ParseException;

import com.example.entities.Usuario;
import com.example.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UsuarioService uService;
	
	@RequestMapping("/new")
	public String goNewUser(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "users/user";
	}
	
	@RequestMapping("/save")
	public String save(@ModelAttribute Usuario usuario, BindingResult binRes, Model model) throws ParseException {
		try {
			uService.insert(usuario);
			return "redirect:/login";
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return "users/user";
		}
	}
}
