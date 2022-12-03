package com.example.restservice;

public class datosPersonales extends BaseResponse{
	private long id;
	private String rol;
	private String numeroLicencia;
	private long ci;
	private String empresa;
	


	public datosPersonales(long id, String rol, String numeroLicencia, long ci, String empresa) {
		//super();
		this.id = id;
		this.rol = rol;
		this.numeroLicencia = numeroLicencia;
		this.ci = ci;
		this.empresa = empresa;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumeroLicencia() {
		return numeroLicencia;
	}

	public void setNumeroLicencia(String numeroLicencia) {
		this.numeroLicencia = numeroLicencia;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public long getCi() {
		return ci;
	}

	public void setCi(long ci) {
		this.ci = ci;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
