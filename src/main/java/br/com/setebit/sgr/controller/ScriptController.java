package br.com.setebit.sgr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.setebit.sgr.dto.RotinaDTO;
import br.com.setebit.sgr.dto.UsuarioDTO;
import br.com.setebit.sgr.response.Response;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.service.RotinaServico;
import br.com.setebit.sgr.service.UsuarioServico;

@RestController
@RequestMapping("/api/script")
@CrossOrigin(origins = "*")
public class ScriptController {

	@Autowired
	private RotinaServico rotinaServico;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UsuarioServico usuarioServico;

	@GetMapping(value = "/atualizar-rotinas")
	public ResponseEntity<Response<List<RotinaDTO>>> atualizarRotinas() {
		System.out.println("###############listarPerfilUsuario");
		Response<List<RotinaDTO>> response = new Response<List<RotinaDTO>>();
		List<RotinaDTO> list = RotinaDTO.toDTO(rotinaServico.listarTodos());
		for (RotinaDTO rotinaDTO : list) {
			System.out.println(rotinaDTO.getAcao());
			rotinaServico.salvar(RotinaDTO.toEntity(rotinaDTO));
		}
		list = RotinaDTO.toDTO(rotinaServico.listarTodos());
		response.setData(list);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/atualizar-senhas")
	public ResponseEntity<Response<List<UsuarioDTO>>> atualizarSenhas() {
		System.out.println("###############listarPerfilUsuario");
		Response<List<UsuarioDTO>> response = new Response<List<UsuarioDTO>>();
		List<Usuario> list = usuarioServico.listarTodos();
		for (Usuario dto : list) {
			System.out.println(dto.getSenha());
			
			try {
				dto.setSenha( passwordEncoder.encode(dto.getSenha()));
				usuarioServico.salvar(dto);
				
			} catch (Exception e) {
				System.out.println("o usuario " + dto.getLogin() +" está com a senha nula.");
			}
		}
		List<UsuarioDTO> data = UsuarioDTO.toDTO(usuarioServico.listarTodos());
		response.setData(data);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/atualizar-senhas/{login}")
	public ResponseEntity<Response<UsuarioDTO>> atualizarSenha(@PathVariable("login") String login) {
		System.out.println("###############listarPerfilUsuario");
		Response<UsuarioDTO> response = new Response<UsuarioDTO>();
		Usuario usuario = usuarioServico.findByLogin(login);
		usuario.setSenha( passwordEncoder.encode("ieadam"));
		UsuarioDTO dto = UsuarioDTO.toDTO(usuarioServico.salvar(usuario));
		dto.setSenha("ieadam");		
		response.setData(dto);
		return ResponseEntity.ok(response);
	}

}