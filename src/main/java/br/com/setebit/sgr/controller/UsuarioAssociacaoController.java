package br.com.setebit.sgr.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.setebit.sgr.dto.UsuarioAreaDTO;
import br.com.setebit.sgr.dto.UsuarioAssociacaoDTO;
import br.com.setebit.sgr.dto.UsuarioNucleoDTO;
import br.com.setebit.sgr.dto.UsuarioZonaDTO;
import br.com.setebit.sgr.response.Response;
import br.com.setebit.sgr.service.UsuarioAreaServico;
import br.com.setebit.sgr.service.UsuarioNucleoServico;
import br.com.setebit.sgr.service.UsuarioServico;
import br.com.setebit.sgr.service.UsuarioZonaServico;

@RestController
@RequestMapping("/api/usuario-associacao")
@CrossOrigin(origins = "*")
public class UsuarioAssociacaoController {

	@Autowired
	private UsuarioServico usuarioServico;

	@Autowired
	private UsuarioZonaServico usuarioZonaServico;

	@Autowired
	private UsuarioNucleoServico usuarioNucleoServico;

	@Autowired
	private UsuarioAreaServico usuarioAreaServico;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<UsuarioAssociacaoDTO>> findUsuarioAssociacao(HttpServletRequest request,
			@PathVariable("id") Integer id) {

		Response<UsuarioAssociacaoDTO> response = new Response<UsuarioAssociacaoDTO>();
		UsuarioAssociacaoDTO dto = usuarioServico.findUsuarioAssociacao(id);
		response.setData(dto);

		return ResponseEntity.ok(response);
	}

	@PostMapping(value = "/atualizar-zona")
	public ResponseEntity<Response<UsuarioZonaDTO>> atualizarZona(HttpServletRequest request,
			@RequestBody UsuarioZonaDTO dto) {

		Response<UsuarioZonaDTO> response = new Response<UsuarioZonaDTO>();
		usuarioZonaServico.atualizar(dto);
		response.setData(dto);

		return ResponseEntity.ok(response);
	}

	@PostMapping(value = "/atualizar-nucleo")
	public ResponseEntity<Response<UsuarioNucleoDTO>> atualizarNucleo(HttpServletRequest request,
			@RequestBody UsuarioNucleoDTO dto) {

		Response<UsuarioNucleoDTO> response = new Response<UsuarioNucleoDTO>();
		usuarioNucleoServico.atualizar(dto);
		response.setData(dto);

		return ResponseEntity.ok(response);
	}

	@PostMapping(value = "/atualizar-area")
	public ResponseEntity<Response<UsuarioAreaDTO>> atualizarArea(HttpServletRequest request,
			@RequestBody UsuarioAreaDTO dto) {

		Response<UsuarioAreaDTO> response = new Response<UsuarioAreaDTO>();
		usuarioAreaServico.atualizar(dto);
		response.setData(dto);

		return ResponseEntity.ok(response);
	}

}
