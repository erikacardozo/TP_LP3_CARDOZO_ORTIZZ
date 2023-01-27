package py.edu.uc.lp3.utilidades;

public class calcularPresupuesto {
	public static Float generarPresupuesto(Long precio, Long cantidad, Float imp,Long Honorarios, Long Honorarios1) {
			float FIN;
			Long resul=precio*cantidad;//precioTotal
			Float impuesto=resul*imp;// impuesto
			Long sumaHonorarios=Honorarios+Honorarios1;//total honorarios
			FIN = resul+impuesto+sumaHonorarios;//total+impuesto
			return FIN;
	
	}

}
