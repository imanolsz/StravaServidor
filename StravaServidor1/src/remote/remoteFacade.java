package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import datos.Reto;
import datos.Usuario;
import dto.retoAssembler;
import dto.retoDTO;
import services.retoAppService;
import services.sesionAppService;
import services.usuarioAppService;




public class remoteFacade extends UnicastRemoteObject implements IremoteFacade {

	private static final long serialVersionUID = 1L;
	
	
	private Map<Long, Usuario> serverState = new HashMap<>();
	private usuarioAppService usuarioService = new usuarioAppService();
	private retoAppService retoService = new retoAppService();
	private sesionAppService sesionService = new sesionAppService();
	
	
	public remoteFacade() throws RemoteException {
		super();		
	}


	
	public boolean registrarUsuario(String nombre, String email, String password, Date fechaNacimiento, float peso, float altura,float frecuenciaCardiacaMaxima, float frecuenciaCardiacaReposo) throws RemoteException {
			
			Usuario usuario = this.usuarioService.registrarUsuario(nombre, email, password, fechaNacimiento, peso, altura, frecuenciaCardiacaMaxima, frecuenciaCardiacaReposo);
			
			if (usuario != null) {
				return true;
			}else {
				throw new RemoteException("No se ha podido crear usuario");
			}
		
	}




	public synchronized long login(String email, String password) throws RemoteException {
		Usuario usuario = usuarioService.loginUsuario(email, password);
		
		if (usuario != null) { 
			if (!this.serverState.values().contains(usuario)) {
				Long token = Calendar.getInstance().getTimeInMillis();		
				this.serverState.put(token, usuario);		
				return(token);
			} else {
				throw new RemoteException("Usuario ya logueado");
			}
		} else {
			throw new RemoteException("Fallo en el logueo");
		}
	}
	
	public synchronized void logout(long token) throws RemoteException {
		System.out.println(" * RemoteFacade logout(): " + token);
		
		if (this.serverState.containsKey(token)) {
			//Logout means remove the User from Server State
			this.serverState.remove(token);
		} else {
			throw new RemoteException("User is not logged in!");
		}
	}
	
	public boolean anadirSesion(long token,String titulo, float duracion, float distancia, Date fechaInicio, Date horaInicio) throws RemoteException {
		if (this.serverState.containsKey(token)) {						
			if (sesionService.anadirSesion(this.serverState.get(token), titulo, duracion, distancia, fechaInicio, horaInicio)) {
				return true;
			} else {
				throw new RemoteException("anadirSesion() fails!");
			}
		} else {
			throw new RemoteException("To place a sesion you must first log in");
		}
		
	}
	
	public boolean crearReto(long token, String nombre, Date fechaInicio, Date fechaFin, float distancia,float duracion) throws RemoteException {
		if (this.serverState.containsKey(token)) {
			if(retoService.crearReto(nombre, fechaInicio, fechaFin, distancia, duracion)!= null) {
				return true;
			}else {
				throw new RemoteException("No se ha podido crear reto");
			}
		}
		return false;
	}

	
	public List<retoDTO> getRetos() throws RemoteException {
		System.out.println(" * RemoteFacade getRetos()");
		
		List<Reto> retos = retoService.getRetos();
		
		if (retos != null) {
			return retoAssembler.getInstance().retoToDTO(retos);
		} else {
			throw new RemoteException("getRetos() fails!");
		}
	}




	public boolean anadirRetoActivo(long token, String nombre, Date fechaInicio, Date fechaFin, float distancia,float duracion) throws RemoteException {
		if (this.serverState.containsKey(token)) {						
			if (retoService.anadirRetoActivo(this.serverState.get(token), nombre, fechaInicio, fechaFin , distancia,duracion )) {
				return true;
			} else {
				throw new RemoteException("anadirRetoActivo() fails!");
			}
		} else {
			throw new RemoteException("To place a RetoActivo you must first log in");
		}
		
	}



	
	public List<retoDTO> getRetosActivos(long token) throws RemoteException {
		if (this.serverState.containsKey(token)) {
			List<Reto> lista = usuarioService.getRetosActivos(serverState.get(token));
			List<retoDTO> listaDto = new ArrayList<>();
			
			for (int i = 0; i < lista.size(); i++) {
				retoDTO reto = new retoDTO();
				reto.setDeporte(lista.get(i).getDeporte());
				reto.setDistancia(lista.get(i).getDistancia());
				reto.setFechaFin(lista.get(i).getFechaFin());
				reto.setFechaInicio(lista.get(i).getFechaFin());
				reto.setNombre(lista.get(i).getNombre());
				reto.setTiempo(lista.get(i).getTiempo());
				listaDto.add(reto);
			}
			return listaDto;
			}else {
				throw new RemoteException("No se ha podido obtener retos activos");
			}
		
		
	}

	
	
	
	
	
	
}
