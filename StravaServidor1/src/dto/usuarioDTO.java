package dto;

import java.io.Serializable;
import java.util.Date;

public class usuarioDTO implements Serializable {	
	
	private static final long serialVersionUID = 1L;	
	private String email;
	private String nombre;
	private Date fechaNacimiento;
	private float peso;
	private float altura;
	private float frecuenciaCardiacaMaxima;
	private float frecuenciaCardiacaReposo;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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
	
	
	}
