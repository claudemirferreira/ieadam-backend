package br.com.setebit.sgr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.setebit.sgr.response.Response;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.entity.UsuarioPerfil;
import br.com.setebit.sgr.service.UsuarioPerfilServico;
import br.com.setebit.sgr.service.UsuarioServico;

@RestController
@RequestMapping("/api/pefil")
@CrossOrigin(origins = "*")
public class PerfilController {

	@Autowired
	private UsuarioPerfilServico usuarioPerfilServico;

	@Autowired
	private PasswordEncoder passwordEncoder;



	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Response<String>> delete(@PathVariable("id") String id) {
		Response<String> response = new Response<String>();
		Usuario user = service.findByOne(Long.parseLong(id));
		if (user == null) {
			response.getErrors().add("Register not found id:" + id);
			return ResponseEntity.badRequest().body(response);
		}
		service.remover(user);
		;
		return ResponseEntity.ok(new Response<String>());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<List<Usuario>>> findAll(@PathVariable("id") String id) {
		Response<List<Usuario>> response = new Response<List<Usuario>>();
		List<UsuarioPerfil> users = usuarioPerfilServico.findByUsuario(new Usuario(Integer.parseInt(id)));
		response.setData(users);
		return ResponseEntity.ok(response);
	}

}
