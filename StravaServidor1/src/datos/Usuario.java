package datos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Usuario {
	
	private String email;
	private String password;
	private String nombre;
	private Date fechaNacimiento;
	private float peso;
	private float altura;
	private float frecuenciaCardiacaMaxima;
	private float frecuenciaCardiacaReposo;
	private List<Reto> retosActivos = new ArrayList<>();
	private List<Sesion> sesiones = new ArrayList<>();
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		System.out.println(email + " dentro del set");
		this.email = email;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public Date getfechaNacimiento() {
		return fechaNacimiento;
	}
	public void setDate(Date fechaNacimiento) {
		this.fechaNacimiento =fechaNacimiento;
	}
	
	
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	
	public float getFrecuenciaCardiacaMaxima() {
		return frecuenciaCardiacaMaxima;
	}
	public void setFrecuenciaCardiacaMaxima(float frecuenciaCardiacaMaxima) {
		this.frecuenciaCardiacaMaxima = frecuenciaCardiacaMaxima;
	}
	
	
	public float getFrecuenciaCardiacaReposo() {
		return frecuenciaCardiacaReposo;
	}
	public void setFrecuenciaCardiacaReposo(float frecuenciaCardiacaReposo) {
		this.frecuenciaCardiacaReposo = frecuenciaCardiacaReposo;
	}
	

	
	
	public List<Sesion> getListaSesiones() {
		return sesiones;
	}
	public void setSesiones(List<Sesion> sesiones) {
		this.sesiones = sesiones;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}
	
	
	public boolean equals(Object obj) {
		if (this.getClass().getName().equals(obj.getClass().getName())) {
			return this.email.equals(((Usuario)obj).email);
		}
		
		return false;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public List<Reto> getListaRetosActivos() {
		return retosActivos;
	}
	public void setRetosActivos(List<Reto> retosActivos) {
		this.retosActivos = retosActivos;
	}

	
	
}
