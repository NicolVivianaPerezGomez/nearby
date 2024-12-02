package co.edu.ue.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.Usuario;

public interface IUsuarioJpa extends JpaRepository<Usuario, String> { //HEREDAR DATOS DEL REPOSITORIO

	Usuario findByteDatEmail(String usuEmail);
	
	
	
	
	
}
