package com.example.config;

import com.example.service.JpaUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("deprecation")
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private LoginSucessHandler sucessHandler;
	
	private BCryptPasswordEncoder passwordEncoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		try {
			http.authorizeRequests()
					// Para permitir nuestro js y css (en nuestra carpeta static)
					.antMatchers("/*.js", "/*.css").permitAll()
					// Para permitir creación de usuarios sin necesidad de estar logueado
					.antMatchers("/users/**").permitAll()
					.antMatchers("/home/").access("hasRole('ROLE_ADMIN')")
                    .antMatchers("/empresas/").access("hasRole('ROLE_ADMIN')")
                    .antMatchers("/advisers/**").access("hasRole('ROLE_ADMIN')")
					// Lógica del login (configurado en LoginSucessHandler)
					.and().formLogin().successHandler(sucessHandler).loginPage("/login").loginProcessingUrl("/login")
					// Si el login es exitoso, retorna a /home
					.defaultSuccessUrl("/home").permitAll().and().logout().logoutSuccessUrl("/login").permitAll()
					// Si el usuario va a una ruta sin acceso, devuelve a /error_403 (Configurado en MvcConfig)
					.and().exceptionHandling().accessDeniedPage("/error403");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void configureGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

}
