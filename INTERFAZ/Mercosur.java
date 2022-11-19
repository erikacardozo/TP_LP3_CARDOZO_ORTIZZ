package py.edu.uc.lp3.interfaces;

public interface Mercosur {
	 //GET - trae los impuestos del IVA
	public int getIVA();

	//GET - trae los impuestos del IRP
	public int getIRP();

	//calcula el descuento al ser del mercosur
	public int getDescuento(); 
}
