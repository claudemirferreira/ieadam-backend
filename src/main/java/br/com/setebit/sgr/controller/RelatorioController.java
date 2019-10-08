package br.com.setebit.sgr.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

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

import br.com.setebit.sgr.dto.ParametroRelatorioDTO;
import br.com.setebit.sgr.dto.ParametroRelatorioDTO2;
import br.com.setebit.sgr.response.Response;
import br.com.setebit.sgr.security.entity.Usuario;
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
	private RelatorioService service;

	@PostMapping(path = "/pdf")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public void imprimir(@RequestBody ParametroRelatorioDTO dto, HttpServletResponse response)
			throws JRException, SQLException, IOException {
		// CALL proc_rel_fin_debito_financeiro ($P{DATA_ANO}, $P{ZONA} , $P{NUCLEO} ,
		// $P{AREA}, 0);
		// CALL proc_rel_fin_debito_financeiro ('2019', 1 , 17 , 13, 0);

		JasperPrint jasperPrint = relatorioUtil.gerarPdf(dto);

		// Configura a respota para o tipo PDF
		response.setContentType("application/pdf");
		// Define que o arquivo pode ser visualizado no navegador e também nome final do
		// arquivo
		// para fazer download do relatório troque 'inline' por 'attachment'
		response.setHeader("Content-Disposition", "inline; filename=Relatorio.pdf");

		// Faz a exportação do relatório para o HttpServletResponse
		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}
	
	@GetMapping(value = "/carregarDados/{id}")
	@PreAuthorize("hasAnyRole('ADMIN','CUSTOMER','TECHNICIAN')")
	public ResponseEntity<Response<ParametroRelatorioDTO2>> carregarDados(@PathVariable("id") int id) {
		ParametroRelatorioDTO2 dto = service.garregarDadosTela(new Usuario(id));
		Response<ParametroRelatorioDTO2> response = new Response<ParametroRelatorioDTO2>();
		response.setData(dto);
		return ResponseEntity.ok(response);
	}

}