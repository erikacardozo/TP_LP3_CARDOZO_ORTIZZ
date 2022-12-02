package py.edu.uc.lp3.interfaces;

import java.util.ArrayList;

import py.edu.uc.lp3.clases.impuesto;

public interface ServicioTipoImpuesto {
	ArrayList<impuesto> ListarImpuestos();
	void eliminarImpuesto(int idImpuesto, ArrayList<impuesto> ListarImpuestos);
	void agregarImpuesto(Integer idMercaderia, Integer cantidad, Integer precio, Float peso, String tipoProducto, Integer iva, Integer irp);
	void actualizarImpuesto(Integer idMercaderia, Integer iva, Integer irp);
}
