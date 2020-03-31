package br.com.setebit.sgr.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.setebit.sgr.dto.UsuarioAssociacaoDTO;
import br.com.setebit.sgr.dto.UsuarioDTO;
import br.com.setebit.sgr.response.Response;
import br.com.setebit.sgr.service.UsuarioServico;

@RestController
@RequestMapping("/api/usuario-associacao")
@CrossOrigin(origins = "*")
public class UsuarioAssociacaoController {

	@Autowired
	private UsuarioServico usuarioServico;

	@PostMapping(value = "/findUsuarioAssociacao")
	public ResponseEntity<Response<UsuarioAssociacaoDTO>> findUsuarioAssociacao(HttpServletRequest request,
			@RequestBody UsuarioDTO usuario, BindingResult result) {
		
		Response<UsuarioAssociacaoDTO> response = new Response<UsuarioAssociacaoDTO>();
		UsuarioAssociacaoDTO dto = usuarioServico.findUsuarioAssociacao(usuario);
		response.setData(dto);
		
		return ResponseEntity.ok(response);
	}

}
