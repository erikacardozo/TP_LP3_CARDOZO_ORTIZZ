package com.example.restservice;

//import java.io.Serializable;



public class localizacion extends BaseResponse{
	private long id;
	private String tipo;
	private String nombre;

	
	public localizacion(long id, String tipo, String nombre) {
		super();
		this.id=id;
		this.tipo = tipo;
		this.nombre = nombre;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	//@Override
	/*public String toString() {
		return "localizacion [tipo=" + tipo + ", nombre=" + nombre + "]";
	}*/
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	

}
