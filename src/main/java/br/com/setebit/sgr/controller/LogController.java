package br.com.setebit.sgr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.setebit.sgr.dto.LogDTO;
import br.com.setebit.sgr.response.Response;
import br.com.setebit.sgr.service.LogAppServico;

@RestController
@RequestMapping("/api/log")
@CrossOrigin(origins = "*")
public class LogController {

	@Autowired
	private LogAppServico service;

	@PostMapping(value = "/pesquisar")
	public ResponseEntity<Response<List<LogDTO>>> atualizarRotinas(@RequestBody LogDTO dto) {
		System.out.println("###############listarPerfilUsuario");
		Response<List<LogDTO>> response = new Response<List<LogDTO>>();
		List<LogDTO> list = LogDTO.toDTO(service.listarPorFiltros(dto));
		response.setData(list);
		return ResponseEntity.ok(response);
	}

}