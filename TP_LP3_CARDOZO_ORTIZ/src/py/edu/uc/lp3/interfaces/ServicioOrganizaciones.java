package py.edu.uc.lp3.interfaces;

import java.util.List;

import py.edu.uc.lp3.clases.Organizaciones;

public interface ServicioOrganizaciones {
	List<Organizaciones> ListarTodo();
	List<Organizaciones> ListarTipoDeOrganizacion(String tipoDeOrganizacion);
	public void agregarOrganizacion(Integer IDOrganizacion, String tipoDeOrganizacion, String descripcion);
	public void eliminarOrganizacion(Integer IDorganizacion);
}
