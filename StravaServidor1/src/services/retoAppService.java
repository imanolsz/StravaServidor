package services;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datos.Reto;
import datos.Usuario;


public class retoAppService {
	
	private List<Reto> retos = new ArrayList<>();
	
	public Reto crearReto(String nombre, Date fechaInicio, Date fechaFin, float distancia,float duracion) {
		Reto reto = new Reto();
		reto.setNombre(nombre);
		reto.setFechaInicio(fechaInicio);
		reto.setFechaFin(fechaFin);
		reto.setDistancia(distancia);
		reto.setTiempo(duracion);
		retos.add(reto);
		return reto;
		
	}

	public List<Reto> getRetos() {
		return retos;
	}
	
	public boolean anadirRetoActivo(Usuario usuario, String nombre, Date fechaInicio, Date fechaFin, float distancia,float duracion) {
		if (usuario != null) {
			Reto nuevaRetoActivo = new Reto();	
			nuevaRetoActivo.setNombre(nombre);
			nuevaRetoActivo.setFechaInicio(fechaInicio);
			nuevaRetoActivo.setFechaFin(fechaFin);
			nuevaRetoActivo.setDistancia(distancia);
			nuevaRetoActivo.setTiempo(duracion);
			usuario.getListaRetosActivos().add(nuevaRetoActivo);
			return true;
		} else {
			return false;
		}
	}
	
}
