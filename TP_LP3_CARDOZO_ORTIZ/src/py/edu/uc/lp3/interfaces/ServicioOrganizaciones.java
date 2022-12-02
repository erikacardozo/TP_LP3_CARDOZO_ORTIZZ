package py.edu.uc.lp3.interfaces;

import java.util.List;

import py.edu.uc.lp3.clases.organizaciones;

public interface ServicioOrganizaciones {
	List<organizaciones> ListarTodo();
	List<organizaciones> ListarTipoDeOrganizacion(String tipoDeOrganizacion);
}
