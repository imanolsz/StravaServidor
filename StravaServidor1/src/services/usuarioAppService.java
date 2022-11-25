package services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datos.Reto;
import datos.Usuario;


public class usuarioAppService {
	
	private List<Usuario> usuarios = new ArrayList<>();
	
	
	public Usuario registrarUsuario(String nombre, String email, String password, Date fechaNacimiento, float peso, float altura,
			float frecuenciaCardiacaMaxima, float frecuenciaCardiacaReposo) {
			Usuario newUsuario = new Usuario();
			newUsuario.setNombre(nombre);
			newUsuario.setEmail(email);
			newUsuario.setPassword(password);
			newUsuario.setFechaNacimiento(fechaNacimiento);
			newUsuario.setPeso(peso);
			newUsuario.setAltura(altura);
			newUsuario.setFrecuenciaCardiacaMaxima(frecuenciaCardiacaMaxima);
			newUsuario.setFrecuenciaCardiacaReposo(frecuenciaCardiacaReposo);
			usuarios.add(newUsuario);
			System.out.println(usuarios);
			System.out.println("si");
		

		return newUsuario;		
	}
	
	public Usuario loginUsuario(String email, String password) {
		Usuario user = null;
		System.out.println(usuarios);
		for ( Usuario usuario : this.usuarios) {
			//if (usuario.getEmail() == email && usuario.getPassword() == password) {
				user = usuario;
			//}
		}
		
		return user;	
	}
	
	public List<Reto> getRetosActivos(Usuario user) {
		List<Reto> lista = user.getListaRetosActivos();
		return lista;
	}

	
	
	
	
	
	
	
	
}
