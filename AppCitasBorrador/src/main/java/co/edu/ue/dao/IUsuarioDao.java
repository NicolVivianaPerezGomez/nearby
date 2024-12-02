package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.Usuario;

public interface IUsuarioDao {

	//DECLARACION DE METODOS ABSTRACTOS O CONSTANTES
	
	
	List<Usuario> guardarUsuario(Usuario usuario);
	Usuario actualizarUsuario(Usuario usuario);
	
	//CONSULTAS
	
	List<Usuario> listaCompleta();
	Usuario busquedaporId(String Id);
	Usuario busquedaPorEmail(String usuEmail);
	
	
		
}
