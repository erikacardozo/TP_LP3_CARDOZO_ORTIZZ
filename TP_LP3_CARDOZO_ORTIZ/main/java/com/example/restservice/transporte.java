package com.example.restservice;

public class transporte {
	private long id;
	private int cantidad;
	private String tipo;
	public transporte(int cantidad, String tipo, long id) {
		super();
		this.id=id;
		this.cantidad = cantidad;
		this.tipo = tipo;
	}
	
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
