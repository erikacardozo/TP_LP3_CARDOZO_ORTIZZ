package py.edu.uc.lp3.service;

import java.util.List;

import py.edu.uc.lp3.domain.Organizaciones;

public interface OrganizacionesService {
	public Organizaciones save(Organizaciones organizaciones);
	List<Organizaciones> findAll();
	List<Organizaciones> findByTipoDeOrganizacion(String tipoDeOrganizacion);

    Organizaciones updateOrg(Long IDOrg,Organizaciones organizaciones); 
    public void deleteOrg(Long IDOrg);
}
