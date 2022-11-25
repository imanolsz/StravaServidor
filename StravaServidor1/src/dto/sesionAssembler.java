package dto;

import java.util.ArrayList;
import java.util.List;

import datos.Sesion;


public class sesionAssembler {	
	private static sesionAssembler instance;

	private sesionAssembler() { }
	
	public static sesionAssembler getInstance() {
		if (instance == null) {
			instance = new sesionAssembler();
		}

		return instance;
	}
	
	public sesionDTO sesionToDTO(Sesion sesion) {
		sesionDTO dto = new sesionDTO();
		
		dto.setTitulo(sesion.getTitulo());
		dto.setDistancia(sesion.getDistancia());
		dto.setHoraInicio(sesion.getHoraInicio());
		dto.setFechaInicio(sesion.getFechaInicio());
		dto.setDuracion(sesion.getDuracion());
		
		return dto;
	}
	public List<sesionDTO> sesionToDTO(List<Sesion> sesiones) {
		List<sesionDTO> dtos = new ArrayList<>();
		
		for (Sesion sesion : sesiones) {
			dtos.add(this.sesionToDTO(sesion));
		}
		
		return dtos;		
	}
}