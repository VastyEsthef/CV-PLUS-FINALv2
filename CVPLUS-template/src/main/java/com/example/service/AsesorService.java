package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Asesor;
import com.example.repository.AsesorRepository;

@Service
public class AsesorService {

	@Autowired
	private AsesorRepository asesorRepository;

	public List<Asesor> listarAsesores() {
		double tarifaHora;
		List<Asesor> asesores = asesorRepository.findAll();

		for (Asesor asesor : asesores) {
			tarifaHora = 0 * asesor.getEdad() + 10 * asesor.getTiempoExperiencia();
			asesor.setTarifaHora(tarifaHora);
		}

		return asesores;
	}

	public int registrarAsesor(Asesor asesor) {
		int existeAsesor = asesorRepository.verificarExistenciaAsesor(asesor.getDni());

		if (existeAsesor == 0)
			asesorRepository.save(asesor);

		return existeAsesor;
	}

	public List<Asesor> buscarAsesorPorDni(String dni) {
		double tarifaHora;
		List<Asesor> asesores = asesorRepository.buscarAsesor(dni);

		for (Asesor asesor : asesores) {
			tarifaHora = 0 * asesor.getEdad() + 10 * asesor.getTiempoExperiencia();
			asesor.setTarifaHora(tarifaHora);
		}

		return asesores;
	}

}
