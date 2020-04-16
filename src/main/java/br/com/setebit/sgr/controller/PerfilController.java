package br.com.setebit.sgr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.setebit.sgr.dto.PerfilDTO;
import br.com.setebit.sgr.dto.PerfilRotinaDTO;
import br.com.setebit.sgr.dto.RotinaDTO;
import br.com.setebit.sgr.dto.UsuarioPerfilDTO;
import br.com.setebit.sgr.response.Response;
import br.com.setebit.sgr.security.entity.Perfil;
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

	@GetMapping(value = "/usuario-perfil/{idUsuario}")
	public ResponseEntity<Response<List<UsuarioPerfilDTO>>> listarPerfil(@PathVariable("idUsuario") Integer idUsuario) {
		System.out.println("###############listarPerfil");
		Response<List<UsuarioPerfilDTO>> response = new Response<List<UsuarioPerfilDTO>>();
		List<UsuarioPerfilDTO> list = perfilServico.listarUsuarioPerfil(idUsuario);
		response.setData(list);
		return ResponseEntity.ok(response);

	}

	@PostMapping(value = "/")
	public ResponseEntity<Response<PerfilDTO>> create(HttpServletRequest request, @RequestBody PerfilDTO dto) {
		System.out.println("entrou no create");
		System.out.println("###############create");
		System.out.println("###############create");

		Response<PerfilDTO> response = new Response<PerfilDTO>();
		PerfilDTO perfilDTO = PerfilDTO.toDTO(perfilServico.salvar(PerfilDTO.toDTO(dto)));
		response.setData(perfilDTO);

		return ResponseEntity.ok(response);
	}


	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Response<String>> delete(@PathVariable("id") Integer id) {
		Response<String> response = new Response<String>();
		Perfil obj = perfilServico.findById(id);
		if (obj == null) {
			response.getErrors().add("Register not found id:" + id);
			return ResponseEntity.badRequest().body(response);
		}
		perfilServico.delete(obj);
		return ResponseEntity.ok(new Response<String>());
	}

	@PostMapping(value = "/atualizar-perfil")
	public ResponseEntity<Response<UsuarioPerfilDTO>> atualizarPerfil(HttpServletRequest request,
			@RequestBody UsuarioPerfilDTO dto) {

		Response<UsuarioPerfilDTO> response = new Response<UsuarioPerfilDTO>();
		perfilServico.atualizar(dto);
		response.setData(dto);

		return ResponseEntity.ok(response);
	}

	@PostMapping(value = "/atualizar-perfil-rotina")
	public ResponseEntity<Response<PerfilRotinaDTO>> atualizarPerfilRotina(HttpServletRequest request,
			@RequestBody PerfilRotinaDTO dto) {

		Response<PerfilRotinaDTO> response = new Response<PerfilRotinaDTO>();
		perfilServico.atualizarPerfilRotina(dto);
		response.setData(dto);

		return ResponseEntity.ok(response);
	}

	@PostMapping(value = "/pesquisar")
	public ResponseEntity<Response<List<PerfilDTO>>> pesquisar(HttpServletRequest request, @RequestBody PerfilDTO pefil,
			BindingResult result) {
		Response<List<PerfilDTO>> response = new Response<List<PerfilDTO>>();
		try {
			List<PerfilDTO> list = PerfilDTO.toDTO(perfilServico.findByNomeLike(pefil.getNome()));
			response.setData(list);
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/perfil-rotina/{idPerfil}")
	public ResponseEntity<Response<List<PerfilRotinaDTO>>> listarPerfilRotina(@PathVariable("idPerfil") Integer idPerfil) {
		System.out.println("###############listarPerfilRotina");
		Response<List<PerfilRotinaDTO>> response = new Response<List<PerfilRotinaDTO>>();
		List<PerfilRotinaDTO> list = perfilServico.listarPerfilRotina(idPerfil);
		response.setData(list);
		return ResponseEntity.ok(response);
	}

}