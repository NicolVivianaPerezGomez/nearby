package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Usuario;
import co.edu.ue.jpa.IUsuarioJpa;

@Repository
public class UsuarioDao implements IUsuarioDao{

	//INYECCION POR INTERFACE DE JPA
	
	@Autowired
	IUsuarioJpa jpa;
	
	@Override
	public List<Usuario> guardarUsuario(Usuario usuario) {
		jpa.save(usuario);
		return listaCompleta();
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		return jpa.save(usuario);
	}

	@Override
	public List<Usuario> listaCompleta() {
		return jpa.findAll();
	}

	@Override
	public Usuario busquedaporId(String Id) {
		return jpa.findById(Id).orElseThrow(null);
	}

	@Override
	public Usuario busquedaPorEmail(String usuEmail) {
		return jpa.findByteDatEmail(usuEmail);
	}
	
	
}
