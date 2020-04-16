package br.com.setebit.sgr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.setebit.sgr.dto.RotinaDTO;
import br.com.setebit.sgr.response.Response;
import br.com.setebit.sgr.security.entity.Rotina;
import br.com.setebit.sgr.service.RotinaServico;

@RestController
@RequestMapping("/api/rotina")
@CrossOrigin(origins = "*")
public class RotinaController {

	@Autowired
	private RotinaServico servico;

	@GetMapping(value = "/perfil/{idPerfil}")
	public ResponseEntity<Response<List<RotinaDTO>>> listarPerfilUsuario(@PathVariable("idPerfil") Integer idPerfil) {
		System.out.println("###############listarPerfilUsuario");
		Response<List<RotinaDTO>> response = new Response<List<RotinaDTO>>();
		List<RotinaDTO> list = RotinaDTO.toDTO(servico.listarRotinaPorPerfil(idPerfil));
		response.setData(list);
		return ResponseEntity.ok(response);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<RotinaDTO>> findById(@PathVariable("id") Integer id) {
		System.out.println("###############findById");
		Response<RotinaDTO> response = new Response<RotinaDTO>();
		RotinaDTO list = RotinaDTO.toDTO(servico.findById(id));
		response.setData(list);
		return ResponseEntity.ok(response);

	}

	@PostMapping(value = "/pesquisar")
	public ResponseEntity<Response<List<RotinaDTO>>> pesquisar(HttpServletRequest request, @RequestBody Rotina rotina,
			BindingResult result) {
		Response<List<RotinaDTO>> response = new Response<List<RotinaDTO>>();
		try {
			List<RotinaDTO> list = RotinaDTO.toDTO(servico.findByNomeLike(rotina.getNome()));
			response.setData(list);
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Response<RotinaDTO>> delete(@PathVariable("id") Integer id) {
		System.out.println("###############findById");
		Response<RotinaDTO> response = new Response<RotinaDTO>();
		servico.delete(id);
		return ResponseEntity.ok(response);

	}

	@GetMapping(value = "/")
	public ResponseEntity<Response<List<RotinaDTO>>> listAll() {
		System.out.println("###############listAll");
		Response<List<RotinaDTO>> response = new Response<List<RotinaDTO>>();
		List<RotinaDTO> list = RotinaDTO.toDTO(servico.listarTodos());
		response.setData(list);
		return ResponseEntity.ok(response);

	}

	@PostMapping(value = "/")
	public ResponseEntity<Response<RotinaDTO>> create(HttpServletRequest request, @RequestBody RotinaDTO rotina,
			BindingResult result) {
		System.out.println("################################entrou no create");
		Response<RotinaDTO> response = new Response<RotinaDTO>();
		try {
			RotinaDTO dto = RotinaDTO.toDTO(servico.salvar(RotinaDTO.toEntity(rotina)));
			response.setData(dto);
		} catch (DuplicateKeyException dE) {
			response.getErrors().add("E-mail already registered !");
			return ResponseEntity.badRequest().body(response);
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}

}