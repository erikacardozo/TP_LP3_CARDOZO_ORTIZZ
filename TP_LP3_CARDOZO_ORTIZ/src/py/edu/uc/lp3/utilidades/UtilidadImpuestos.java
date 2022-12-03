package py.edu.uc.lp3.utilidades;

import py.edu.uc.lp3.clases.Impuestos;
import py.edu.uc.lp3.clases.Mercaderia;

public class UtilidadImpuestos {
	public float calcularImpuestoIVA(Mercaderia m1,Impuestos i1) {
		/*Calcula el impuesto de IVA */
		float ImpuestosIVA = m1.precio*i1.IVA;
		return ImpuestosIVA;
		
	}
	public float calcularImpuestoarancel(Mercaderia m1,Impuestos i1) {
		/*Calcula el impuesto de arancel */
		float ImpuestosArancel = m1.precio*i1.arancel;
		return ImpuestosArancel;
		
	}
	public boolean verificarImpuesto(Impuestos impuesto) {
		/*Verificamos que los impuestos sean de acorde al producto, si es el arancel correcto*/
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Impuesto verificado " );
	}
}
