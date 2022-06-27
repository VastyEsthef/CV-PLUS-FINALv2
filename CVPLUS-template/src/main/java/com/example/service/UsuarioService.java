package com.example.service;

import java.util.ArrayList;

import com.example.entities.Role;
import com.example.entities.Usuario;
import com.example.repository.RoleRepository;
import com.example.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository uRepo;
	
	@Autowired
	private RoleRepository rRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public void insert(Usuario usuario) {
		Usuario objUser = usuario;
		objUser.setPassword(passwordEncoder.encode(objUser.getPassword()));
		objUser = uRepo.save(objUser);
		
		Role role = new Role();
		// Se asigna el rol con el que queremos que el usuario se cree
		role.setAuthority("ROLE_ADMIN");
		role = rRepo.save(role);

		objUser.setRoles(new ArrayList<Role>());
		objUser.getRoles().add(role);
		objUser = uRepo.save(objUser);
	}

}
