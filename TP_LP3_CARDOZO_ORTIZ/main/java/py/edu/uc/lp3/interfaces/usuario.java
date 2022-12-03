package py.edu.uc.lp3.interfaces;
import java.util.List;

public interface usuario {
	//POST - crear usuario
			public int createUsuario();
			
			//DELETE - elimina usuario
			public int deleteUsuario();

			//PUT - actualizar usuario
			public int modifyUsuario();

			//GET - listar todos los usuarios
			List<usuario>listarUsuarios(String nombre, String apellido, Long CI, Integer ID);
}
