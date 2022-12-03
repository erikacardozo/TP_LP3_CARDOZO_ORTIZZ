package py.edu.uc.lp3.interfaces;

import java.util.ArrayList;

import py.edu.uc.lp3.clases.Impuestos;

public interface ServicioTipoImpuesto {
	ArrayList<Impuestos> ListarImpuestos();
	public void eliminar_impuesto(Integer idMercaderia);
	void agregarImpuesto(Integer idMercaderia, Integer iva, Integer arancel);
	void actualizarImpuesto(Integer idMercaderia, Integer iva, Integer arancel);
}
