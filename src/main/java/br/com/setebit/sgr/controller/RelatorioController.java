package br.com.setebit.sgr.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.setebit.sgr.dto.AreaDTO;
import br.com.setebit.sgr.dto.FiltroDTO;
import br.com.setebit.sgr.dto.FiltroRelatorioDTO;
import br.com.setebit.sgr.dto.NucleoDTO;
import br.com.setebit.sgr.dto.PerfilDTO;
import br.com.setebit.sgr.response.Response;
import br.com.setebit.sgr.service.LogAppServico;
import br.com.setebit.sgr.service.PerfilServico;
import br.com.setebit.sgr.service.RelatorioService;
import br.com.setebit.sgr.util.RelatorioUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@RestController
@RequestMapping("/api/relatorio")
@CrossOrigin(origins = "*")
public class RelatorioController {

	@Autowired
	private RelatorioUtil relatorioUtil;

	@Autowired
	private PerfilServico perfilServico;

	@Autowired
	private RelatorioService service;
	
	@Autowired
	private LogAppServico logService;

	@GetMapping(value = "/carregarDados")
	public ResponseEntity<Response<FiltroRelatorioDTO>> carregarDados() {
		System.out.println("##############carregarDados()");
		FiltroRelatorioDTO dto = service.garregarDadosTela();
		Response<FiltroRelatorioDTO> response = new Response<FiltroRelatorioDTO>();
		response.setData(dto);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/carregarNucleo/{idZona}")
	public ResponseEntity<Response<List<NucleoDTO>>> carregarNucleo(@PathVariable("idZona") String idZona) {
		System.out.println("##############carregarNucleo()");
		List<NucleoDTO> lista = service.carregarNucleo(Integer.parseInt(idZona));
		Response<List<NucleoDTO>> response = new Response<List<NucleoDTO>>();
		response.setData(lista);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/carregarArea/{idNucleo}")
	public ResponseEntity<Response<List<AreaDTO>>> carregarArea(@PathVariable("idNucleo") String idNucleo) {
		System.out.println("##############carregarNucleo()");
		List<AreaDTO> lista = service.carregarArea(Integer.parseInt(idNucleo));
		Response<List<AreaDTO>> response = new Response<List<AreaDTO>>();
		response.setData(lista);
		return ResponseEntity.ok(response);
	}

	@RequestMapping(value = "/geraPdf", method = RequestMethod.POST)
	public ResponseEntity<byte[]> geraPdf(HttpServletResponse response, @RequestBody FiltroDTO dto)
			throws JRException, SQLException, IOException {
		System.out.println("########## getPDF");
		try {

			System.out.println(dto.toString());

			JasperPrint jasperPrint = relatorioUtil.gerarPdf(dto);
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline; filename=Relatorio.pdf");
			// Faz a exportação do relatório para o HttpServletResponse
			final OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

			byte[] output = JasperExportManager.exportReportToPdf(jasperPrint);

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.parseMediaType("application/pdf"));
			String filename = "relatorio.pdf";
			headers.setContentDispositionFormData(filename, filename);
			ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(output, headers, HttpStatus.OK);

			//inseri o log 
			System.out.println(dto.getNomeRelatorio());
			logService.salvarLog(dto.getNomeRelatorio());
			
			return responseEntity;
		} catch (FileNotFoundException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}
		return null;
	}

	@GetMapping(value = "/perfilUsuario")
	public ResponseEntity<Response<List<PerfilDTO>>> listarPerfilUsuario() {
		System.out.println("###############listarPerfilUsuario");
		Response<List<PerfilDTO>> response = new Response<List<PerfilDTO>>();
		List<PerfilDTO> list = PerfilDTO.toDTO(perfilServico.listarPerfil());
		response.setData(list);
		return ResponseEntity.ok(response);
	}

}