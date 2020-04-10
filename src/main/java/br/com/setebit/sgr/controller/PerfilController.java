package br.com.setebit.sgr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.setebit.sgr.dto.PerfilDTO;
import br.com.setebit.sgr.dto.RotinaDTO;
import br.com.setebit.sgr.dto.UsuarioPerfilDTO;
import br.com.setebit.sgr.dto.UsuarioZonaDTO;
import br.com.setebit.sgr.response.Response;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.entity.ViewPerfilRotina;
import br.com.setebit.sgr.service.PerfilServico;

@RestController
@RequestMapping("/api/perfil")
@CrossOrigin(origins = "*")
public class PerfilController {

	@Autowired
	private PerfilServico perfilServico;

	@GetMapping(value = "/usuario")
	public ResponseEntity<Response<List<PerfilDTO>>> listarPerfilUsuario() {
		System.out.println("###############listarPerfilUsuario");
		Response<List<PerfilDTO>> response = new Response<List<PerfilDTO>>();
		List<PerfilDTO> list = perfilServico.listarPerfilDto();
		response.setData(list);
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<Response<List<PerfilDTO>>> listarTodos() {
		System.out.println("###############listarPerfilUsuario");
		Response<List<PerfilDTO>> response = new Response<List<PerfilDTO>>();
		List<PerfilDTO> list = PerfilDTO.toDTO(perfilServico.listarTodos());
		response.setData(list);
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Response<PerfilDTO>> listarPerfilRotina(@PathVariable("id") Long idPerfil) {
		System.out.println("###############listarPerfilUsuario");
		Response<PerfilDTO> response = new Response<PerfilDTO>();
		PerfilDTO dto = perfilServico.listarPerfilDto(idPerfil);
		response.setData(dto);
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping(value = "/listarRotinaPorPerfil/{id}")
	public ResponseEntity<Response<List<RotinaDTO>>> listarRotinaPorPerfil(@PathVariable("id") int idPerfil) {
		System.out.println("###############listarRotinaPorPerfil");
		Response<List<RotinaDTO>> response = new Response<List<RotinaDTO>>();
		List<RotinaDTO> dto = perfilServico.listarRotinaPorPerfil(idPerfil);
		response.setData(dto);
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping(value = "/usuario-perfil")
	public ResponseEntity<Response<List<UsuarioPerfilDTO>>> listarPerfil() {
		System.out.println("###############listarPerfil");
		Response<List<UsuarioPerfilDTO>> response = new Response<List<UsuarioPerfilDTO>>();
		List<UsuarioPerfilDTO> list = perfilServico.listarUsuarioPerfil();
		response.setData(list);
		return ResponseEntity.ok(response);
		
	}

	@PostMapping(value = "/atualizar-perfil")
	public ResponseEntity<Response<UsuarioPerfilDTO>> atualizarPerfil(HttpServletRequest request,
			@RequestBody UsuarioPerfilDTO dto) {

		Response<UsuarioPerfilDTO> response = new Response<UsuarioPerfilDTO>();
		perfilServico.atualizar(dto);
		response.setData(dto);

		return ResponseEntity.ok(response);
	}

}