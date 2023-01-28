package py.edu.uc.lp3.utilidades;

import py.edu.uc.lp3exceptions.GeneralLP3Exception;

/*utilidad para calcular presupuesto
 * recibe los datos necesarios para calcular
 * precio, cantidad , impuesto porcentaje, honorarios despachante
 * honoarios transporte */

public class calcularPresupuesto {
	public static Float generarPresupuesto(Long precio, Long cantidad, Float imp,Long Honorarios, Long Honorarios1, Long almacenamiento) {
			try {
				float FIN;
				Long resul=precio*cantidad;//precioTotal
				Float impuesto=resul*imp;// impuesto
				Long sumaHonorarios=Honorarios+Honorarios1+almacenamiento;//total honorarios
				FIN = resul+impuesto+sumaHonorarios;//total+impuesto
				return FIN;
			}catch(Error error) {
				System.out.println(error);
				throw new GeneralLP3Exception("Error inesperado al calcular presupuesto en utilidad.");
			}
			
	}

}
