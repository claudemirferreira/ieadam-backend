package br.com.setebit.sgr.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.setebit.sgr.dto.ParametroRelatorioDTO;
import br.com.setebit.sgr.dto.FiltroRelatorioDTO;
import br.com.setebit.sgr.dto.NucleoDTO;
import br.com.setebit.sgr.response.Response;
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
	//@PreAuthorize("hasAnyRole('ADMIN','CUSTOMER','TECHNICIAN')")
	public void imprimir(@RequestBody ParametroRelatorioDTO dto, HttpServletResponse response)
			throws JRException, SQLException, IOException {
		// CALL proc_rel_fin_debito_financeiro ($P{DATA_ANO}, $P{ZONA} , $P{NUCLEO} ,
		// $P{AREA}, 0);
		// CALL proc_rel_fin_debito_financeiro ('2019', 1 , 17 , 13, 0);		
		dto.setAno("2019");
		dto.setIdZona(1);
		dto.setIdNucleo(17);
		dto.setIdArea(13);
		JasperPrint jasperPrint = relatorioUtil.gerarPdf(dto);
		response.setContentType("application/pdf");		
		response.setHeader("Content-Disposition", "inline; filename=Relatorio.pdf");
		// Faz a exportação do relatório para o HttpServletResponse
		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}
	
	@GetMapping(path = "/pdf")
	//@PreAuthorize("hasAnyRole('ADMIN','CUSTOMER','TECHNICIAN')")
	public void imprimir(HttpServletResponse response)
			throws JRException, SQLException, IOException {
		// CALL proc_rel_fin_debito_financeiro ($P{DATA_ANO}, $P{ZONA} , $P{NUCLEO} ,
		// $P{AREA}, 0);
		// CALL proc_rel_fin_debito_financeiro ('2019', 1 , 17 , 13, 0);
		ParametroRelatorioDTO dto = new ParametroRelatorioDTO();
		dto.setAno("2019");
		dto.setIdZona(1);
		dto.setIdNucleo(17);
		dto.setIdArea(13);
		dto.setNomeRelatorio("RelatorioDebitoFinanceiro.jasper");
		JasperPrint jasperPrint = relatorioUtil.gerarPdf(dto);
		response.setContentType("application/pdf");		
		response.setHeader("Content-Disposition", "inline; filename=Relatorio.pdf");
		// Faz a exportação do relatório para o HttpServletResponse
		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}
	
	@RequestMapping(value = "/downloadPDF", method = RequestMethod.GET, produces = "application/pdf")
    public ResponseEntity<byte[]> getPDF(HttpServletResponse response)
			throws JRException, SQLException, IOException {
    	System.out.println("########## getPDF");
        try {
        	ParametroRelatorioDTO dto = new ParametroRelatorioDTO();
    		dto.setAno("2019");
    		dto.setIdZona(1);
    		dto.setIdNucleo(17);
    		dto.setIdArea(13);
    		dto.setNomeRelatorio("RelatorioDebitoFinanceiro.jasper");
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
            
            return responseEntity;
        } catch (FileNotFoundException e) {
           System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
        return null;
    }
	
	@GetMapping(value = "/carregarDados")
	//@PreAuthorize("hasAnyRole('ADMIN','CUSTOMER','TECHNICIAN')")
	public ResponseEntity<Response<FiltroRelatorioDTO>> carregarDados() {
		System.out.println("##############carregarDados()");
		FiltroRelatorioDTO dto = service.garregarDadosTela();
		Response<FiltroRelatorioDTO> response = new Response<FiltroRelatorioDTO>();
		response.setData(dto);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/carregarNucleo/{idZona}")
	//@PreAuthorize("hasAnyRole('ADMIN','CUSTOMER','TECHNICIAN')")
	public ResponseEntity<Response<List<NucleoDTO>>> carregarNucleo(@PathVariable("idZona") String idZona) {
		List<NucleoDTO> lista = service.carregarNucleo(Integer.parseInt(idZona));
		Response<List<NucleoDTO>> response = new Response<List<NucleoDTO>>();
		response.setData(lista);
		return ResponseEntity.ok(response);	
		
	}

}