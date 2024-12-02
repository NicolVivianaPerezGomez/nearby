package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Usuario;

public interface IUsuarioService {

	//DECLARACION DE METODOS ABSTRACTOS O CONSTANTES
	
	
		List<Usuario> addUsuario(Usuario usuario);
		Usuario upUsuario(Usuario usuario);
		
		//CONSULTAS
		
		List<Usuario> listAll();
		Usuario findIdUsuario(String Id);
		Usuario findEmailUsuario(String usuEmail);
		
	
}
