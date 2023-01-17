package py.edu.uc.lp3.interfaces;

import java.util.List;

import py.edu.uc.lp3.clases.Organizaciones;

public interface ServicioOrganizaciones {
	/*cambiar ingles y agregar al diagrama de clases */
    List<Organizaciones> findAll();
    List<Organizaciones> findByOrganization(String tipoDeOrganizacion);
    public void save(Integer IDOrganizacion, String tipoDeOrganizacion, String descripcion);
    public void delete(int IDorganizacion);
}
