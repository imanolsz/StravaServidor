package services;


import java.util.Date;

import datos.Sesion;
import datos.Usuario;


public class sesionAppService {
	
	public boolean anadirSesion(Usuario usuario, String titulo, float duracion, float distancia, Date fechaInicio, Date horaInicio) {
		if (usuario != null) {
			Sesion nuevaSesion = new Sesion();	
			nuevaSesion.setTitulo(titulo);
			nuevaSesion.setDuracion(duracion);
			nuevaSesion.setDistancia(distancia);
			nuevaSesion.setFechaInicio(fechaInicio);
			nuevaSesion.setHoraInicio(horaInicio);
			usuario.getListaSesiones().add(nuevaSesion);
			return true;
		} else {
			return false;
		}
	}
}
