package py.edu.uc.lp3.clases;

public class usuario {
	private Integer IDuser;
	private String nombreUser;
	private Long ci;
	private String rol;
	private String email;
	private String passwd;
	public Integer getIDuser() {
		return IDuser;
	}
	public void setIDuser(Integer iDuser) {
		IDuser = iDuser;
	}
	public String getNombreUser() {
		return nombreUser;
	}
	public void setNombreUser(String nombreUser) {
		this.nombreUser = nombreUser;
	}
	public Long getCi() {
		return ci;
	}
	public void setCi(Long ci) {
		this.ci = ci;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
}

