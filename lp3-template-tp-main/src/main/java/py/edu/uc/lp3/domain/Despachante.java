package py.edu.uc.lp3.domain;


public class Despachante extends Usuario{
	Long honorarios=500000l;
	
	
	public Despachante() {
		// TODO Auto-generated constructor stub
	}

	public Long getHonorarios() {
		return honorarios;
	}


	public void setHonorarios(Long honorarios) {
		this.honorarios = honorarios;
	}
	
}
