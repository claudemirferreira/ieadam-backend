package br.com.setebit.sgr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.setebit.sgr.dto.UsuarioDTO;
import br.com.setebit.sgr.response.Response;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.service.UsuarioServico;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UsuarioServico service;

	@PostMapping()
	public ResponseEntity<Response<Usuario>> create(HttpServletRequest request, @RequestBody Usuario user,
			BindingResult result) {
		Response<Usuario> response = new Response<Usuario>();
		try {
			validateCreateUsuario(user, result);
			if (result.hasErrors()) {
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			Usuario userPersisted = (Usuario) service.salvar(user);
			response.setData(userPersisted);
		} catch (DuplicateKeyException dE) {
			response.getErrors().add("E-mail already registered !");
			return ResponseEntity.badRequest().body(response);
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}

	private void validateCreateUsuario(Usuario user, BindingResult result) {
		if (user.getEmail() == null) {
			result.addError(new ObjectError("Usuario", "Email no information"));
			return;
		}
	}

	@PutMapping()
	public ResponseEntity<Response<UsuarioDTO>> update(HttpServletRequest request, @RequestBody Usuario user,
			BindingResult result) {
		Response<UsuarioDTO> response = new Response<UsuarioDTO>();
		try {
			validate(user, result);
			if (result.hasErrors()) {
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			UsuarioDTO userPersisted = UsuarioDTO.toDTO(service.salvar(user));
			response.setData(userPersisted);
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}

	@PutMapping("/alterar-senha")
	public ResponseEntity<Response<UsuarioDTO>> alterarSenha(HttpServletRequest request, @RequestBody UsuarioDTO user,
			BindingResult result) {
		Response<UsuarioDTO> response = new Response<UsuarioDTO>();
		try {
			UsuarioDTO userPersisted = UsuarioDTO.toDTO(service.alterarSenha(user));
			response.setData(userPersisted);
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
	@PostMapping(value = "/pesquisar")
	public Page<Usuario> pesquisar1(
			HttpServletRequest request, 
			@RequestBody UsuarioDTO user,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size,
			BindingResult result) {
		
			return service.pesquisarUsuario(user, page, size);
	}

	private void validateUpdate(Usuario user, BindingResult result) {
		if (user.getId() == 0) {
			result.addError(new ObjectError("Usuario", "Id no information"));
			return;
		}
		if (user.getEmail() == null) {
			result.addError(new ObjectError("Usuario", "Email no information"));
			return;
		}
	}

	private void validate(Usuario user, BindingResult result) {
		System.out.println(user.getId());
		System.out.println("getLogin="+user.getLogin());
		if (user.getId() == 0) {
			if (service.findByLogin(user.getLogin()) != null) {
				result.addError(new ObjectError("Usuario", "Ja existe um usuario com o login " + user.getLogin() ));
				return;
			}
		}
		if (user.getSenha() == null) {
			user.setSenha("ieadam");
		}
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<Response<UsuarioDTO>> findById(@PathVariable("id") Integer id) {
		Response<UsuarioDTO> response = new Response<UsuarioDTO>();
		UsuarioDTO user = UsuarioDTO.getDTO(service.findByOne(id));
		if (user == null) {
			response.getErrors().add("Register not found id:" + id);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(user);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Response<String>> delete(@PathVariable("id") Integer id) {
		Response<String> response = new Response<String>();
		Usuario user = service.findByOne(id);
		if (user == null) {
			response.getErrors().add("Register not found id:" + id);
			return ResponseEntity.badRequest().body(response);
		}
		service.remover(user);
		return ResponseEntity.ok(new Response<String>());
	}

	@GetMapping(value = "{page}/{count}")
	public ResponseEntity<Response<List<Usuario>>> findAll(@PathVariable int page, @PathVariable int count) {
		Response<List<Usuario>> response = new Response<List<Usuario>>();
		List<Usuario> users = service.listarTodos();
		response.setData(users);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("search")
	public Page<Usuario> search(
			@RequestParam(value = "nome", required = false, defaultValue = "0") String nome,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		System.out.println("search");

		return service.findByNomeLike(nome, page, size);

	}

}
