package dto;

import java.util.ArrayList;
import java.util.List;

import datos.Reto;




public class retoAssembler {	
	private static retoAssembler instance;

	private retoAssembler() { }
	
	public static retoAssembler getInstance() {
		if (instance == null) {
			instance = new retoAssembler();
		}

		return instance;
	}
	
	public retoDTO retoToDTO(Reto reto) {
		retoDTO dto = new retoDTO();
		
		dto.setNombre(reto.getNombre());
		dto.setFechaInicio(reto.getFechaInicio());
		dto.setFechaFin(reto.getFechaFin());
		dto.setDistancia(reto.getDistancia());
		dto.setTiempo(reto.getTiempo());
		
		return dto;
	}
	
	public List<retoDTO> retoToDTO(List<Reto> retos) {		
		List<retoDTO> dtos = new ArrayList<>();
		
		for (Reto reto : retos) {
			dtos.add(this.retoToDTO(reto));
		}
		
		return dtos;
	}
}