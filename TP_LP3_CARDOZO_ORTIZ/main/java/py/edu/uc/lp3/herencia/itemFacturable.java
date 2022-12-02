package py.edu.uc.lp3.herencia;

import py.edu.uc.lp3.interfaces.Cotizable;

public class itemFacturable implements Comparable<itemFacturable>, Cotizable{
	private String descripcion;
	private Long precio;
	private String codigo;
	Double rating;

	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public Long getPrecio() {
		return precio;
	}
	public void setPrecio(Long precio) {
		this.precio = precio;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public String getCodigo() {
		return codigo;
	}
	protected long calcularPrecio() {
		return getPrecio();
	}
	public static void main(String[] args) {
		itemFacturable item1= new servicio ();
		itemFacturable item2= new producto ();
		item1.setPrecio(1000l);//casting a Long = new long(1000);
		item2.setPrecio(5000l);
		System.out.println("Precio 1: "+ item1.calcularPrecio());
		System.out.println("Precio 2: "+ item2.calcularPrecio());
		item1.compareTo(item2);
		
		
	}
	@Override
	public int compareTo(itemFacturable itemAComparar) {
	    // TODO Auto-generated method stub
		int retorno=getPrecio().compareTo(itemAComparar.getPrecio());
	    return retorno;//-1 item 1 es menor que item 2
	   // return getCodigo().compareTo(itemAComparar.getCodigo());
	}
	@Override
	public Long getPrecio(String identificador) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Double getPrecioUSD(String identificador) {
		// TODO Auto-generated method stub
		return null;
	}
	
}



/*public getPrecio() {
	
}
public getCodigo() {
	
}
public getDescripcion() {
	
}
protected calcularPrecio() {
	
}*/

