package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Usuario;
import co.edu.ue.service.IUsuarioService;

@RestController
public class UsuarioController { //SE COMUNICA CON EL SERVICIO
	
	@Autowired
	IUsuarioService service;
	
	@PostMapping(value="usuario-sav")
	public List<Usuario> postUsuario(@RequestBody Usuario usuario) {
		return service.addUsuario(usuario);
	}
	
	@GetMapping(value="usuario-all")
	public List<Usuario>getAllusuario() {
		return service.listAll();
	}
	
}
