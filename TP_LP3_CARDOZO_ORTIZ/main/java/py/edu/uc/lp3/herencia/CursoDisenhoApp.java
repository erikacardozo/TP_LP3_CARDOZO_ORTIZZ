package py.edu.uc.lp3.herencia;

public class CursoDisenhoApp {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CursoDisenhoApp cursoDisenhoApp = new CursoDisenhoApp(); //constructor default que da automaticamente JAVA
		System.out.println("CursoDisenhoApp.main()");
		System.out.println("Descripcion del curso: " + cursoDisenhoApp.describe());// describe informacion del curso
		//Ahora voy a crear un curso con los datos ya conocidos
	    CursoDisenhoApp cursoDisenhoDeVerano;
	    Brush brocha = new Brush();
	    brocha.setCantidadStrokes(100_000);
	    Double costo = 300_000.d;
	    Double duracionHoras = 20.0;
	    String modalidad = "Presencial";
	    Lienzo tipoLienzo = new Lienzo();
	    tipoLienzo.setMaterial("Cartulina de hilo");
	    
	    
	    cursoDisenhoDeVerano = new CursoDisenhoApp(modalidad, duracionHoras, costo, brocha, tipoLienzo);
	    System.out.println("CursoDisenhoApp.main()");
	    System.out.println("Descripcion del curso: " + cursoDisenhoDeVerano.describe());
	}
	private String describe() {
		// TODO Auto-generated method stub
		String descripcion = "Tipo de brocha: " + getBrocha().getCantidadStrokes();
		descripcion += "Tipo de lienzo: " + getTipoLienzo().getMaterial(); 
		descripcion += "Duracion del curso: " + getDuracionHoras();
		return descripcion;
	}
	
	Brush brocha;//como llamar a la clase brush
	Double costo;
	Double duracionHoras;
	String modalidad;

	Lienzo tipoLienzo;

	public CursoDisenhoApp() {//no tiene toda la info y debe elegir
		// TODO Auto-generated constructor stub
		/*Brush brocha = new Brush();
		Double costo = -1.0;
		Double duracionHoras =-1.0;
		String modalidad = "no se sabe";
		Lienzo tipoLienzo= new Lienzo();*/
	    this.brocha = new Brush();//asignar al valor de tu propiedad de esa clase
	    this.costo = -1.0;
	    this.duracionHoras = -1.0;
	    this.modalidad = "no se sabe";
	    this.tipoLienzo = new Lienzo();
		
	}

	public CursoDisenhoApp(String modalidad, Double duracionHoras, Double costo, Brush brocha, Lienzo tipoLienzo) {// ya tenes todos los datos
		super();
		this.modalidad = modalidad;
		this.duracionHoras = duracionHoras;
		this.costo = costo;
		this.brocha = brocha;
		this.tipoLienzo = tipoLienzo;
	}

	public Brush getBrocha() {
		return brocha;
	}

	public Double getCosto() {
		return costo;
	}

	public Double getDuracionHoras() {
		return duracionHoras;
	}

	public String getModalidad() {
		return modalidad;
	}

	public Lienzo getTipoLienzo() {
		return tipoLienzo;
	}

	public void setBrocha(Brush brocha) {
		this.brocha = brocha;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public void setDuracionHoras(Double duracionHoras) {
		this.duracionHoras = duracionHoras;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public void setTipoLienzo(Lienzo tipoLienzo) {
		this.tipoLienzo = tipoLienzo;
	}

}
