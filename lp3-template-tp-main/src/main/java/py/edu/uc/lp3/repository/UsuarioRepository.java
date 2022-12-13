package py.edu.uc.lp3.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import py.edu.uc.lp3.domain.Usuario;


public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {
		Usuario findByRol(String rol);
}

