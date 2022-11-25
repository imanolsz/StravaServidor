package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import dto.retoDTO;


public interface IremoteFacade extends Remote{
	
	public boolean registrarUsuario(String nombre, String email, String password, Date fechaNacimiento, float peso, float altura, float frecuenciaCardiacaMaxima, float frecuenciaCardiacaReposo) throws RemoteException;
	
	public boolean anadirSesion(long token, String titulo, float duracion, float distancia, Date fechaInicio, Date horaInicio) throws RemoteException;
	
	public boolean crearReto(long token,String nombre, Date fechaInicio, Date fechaFin,float distancia,float duracion) throws RemoteException;
	
	public boolean anadirRetoActivo(long token,String nombre, Date fechaInicio, Date fechaFin,float distancia,float duracion) throws RemoteException;
	
	public long login(String email, String password) throws RemoteException;
	
	public List<retoDTO> getRetos() throws RemoteException;
	
	public List <retoDTO> getRetosActivos(long token) throws RemoteException;
	
	public void logout(long token) throws RemoteException; 
}
