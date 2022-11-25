package dto;

import java.util.ArrayList;
import java.util.List;

import datos.Usuario;

public class usuarioAssembler {
	private static usuarioAssembler instance;

	private usuarioAssembler() { }
	
	public static usuarioAssembler getInstance() {
		if (instance == null) {
			instance = new usuarioAssembler();
		}

		return instance;
	}

	public usuarioDTO userToDTO(Usuario user) {
		usuarioDTO dto = new usuarioDTO();
		
		dto.setNombre(user.getNombre());
		dto.setEmail(user.getEmail());
		dto.setFechaNacimiento(user.getfechaNacimiento());
		dto.setPeso(user.getPeso());
		dto.setAltura(user.getAltura());
		dto.setFrecuenciaCardiacaMaxima(user.getFrecuenciaCardiacaMaxima());
		dto.setFrecuenciaCardiacaReposo(user.getFrecuenciaCardiacaReposo());
		
		return dto;
	}
	public List<usuarioDTO> categoryToDTO(List<Usuario> usuarios) {		
		List<usuarioDTO> dtos = new ArrayList<>();
		
		for (Usuario usuario : usuarios) {
			dtos.add(this.userToDTO(usuario));
		}
		
		return dtos;
	}
}