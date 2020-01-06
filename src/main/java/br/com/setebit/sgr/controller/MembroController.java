package br.com.setebit.sgr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.setebit.sgr.dto.FiltroDTO;
import br.com.setebit.sgr.response.Response;
import br.com.setebit.sgr.security.entity.ViewMembro;
import br.com.setebit.sgr.service.MembroServico;

@RestController
@RequestMapping("/api/membro")
@CrossOrigin(origins = "*")
public class MembroController {

	@Autowired
	private MembroServico servico;

	@PostMapping(value = "/find")
	public ResponseEntity<Response<List<ViewMembro>>> find(HttpServletRequest request, @RequestBody FiltroDTO filtroDTO,
			BindingResult result) {
		Response<List<ViewMembro>> response = new Response<List<ViewMembro>>();
		List<ViewMembro> list = this.servico.listarMembrosByFiltros(filtroDTO);

		response.setData(list);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<ViewMembro>> find(@PathVariable("id") int id) {
		Response<ViewMembro> response = new Response<ViewMembro>();
		ViewMembro membro = this.servico.findById(id);

		response.setData(membro);
		return ResponseEntity.ok(response);
	}

}