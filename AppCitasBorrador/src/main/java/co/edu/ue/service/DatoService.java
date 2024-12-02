package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IUsuarioDao;
import co.edu.ue.entity.Usuario;


@Service
public class DatoService implements IUsuarioService {

	@Autowired
	IUsuarioDao dao;
	
	@Override
	public List<Usuario> addUsuario(Usuario usuario) {
		return dao.guardarUsuario(usuario);
	}

	@Override
	public Usuario upUsuario(Usuario usuario) {
		return dao.actualizarUsuario(usuario);
	}

	@Override
	public List<Usuario> listAll() {
		return dao.listaCompleta();
	}

	@Override
	public Usuario findIdUsuario(String Id) {
		return dao.busquedaporId(Id);
	}

	@Override
	public Usuario findEmailUsuario(String usuEmail) {
		dao.busquedaPorEmail(usuEmail);
		return null;
	}

}
