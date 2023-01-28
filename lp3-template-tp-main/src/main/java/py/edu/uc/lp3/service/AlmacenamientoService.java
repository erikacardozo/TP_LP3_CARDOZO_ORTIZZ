package py.edu.uc.lp3.service;
import java.util.List;

import py.edu.uc.lp3.domain.Almacenamiento;

public interface AlmacenamientoService {
	List<Almacenamiento> findAll();
    void deleteAlmacenamientoById(Long id);
    Almacenamiento save(Almacenamiento transporte);
    Almacenamiento updateAlmacenamiento(long id, Almacenamiento almacenamiento);
}
