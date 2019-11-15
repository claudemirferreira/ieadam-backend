package br.com.setebit.sgr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.setebit.sgr.dto.PerfilDTO;
import br.com.setebit.sgr.response.Response;
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

}