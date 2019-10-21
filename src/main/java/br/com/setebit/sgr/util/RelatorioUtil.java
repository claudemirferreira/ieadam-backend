package br.com.setebit.sgr.util;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.setebit.sgr.dto.ParametroRelatorioDTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Component
public class RelatorioUtil {

	@Autowired
	private DataSource dataSource;

	public RelatorioUtil() {
	}

	
	public JasperPrint gerarPdf(ParametroRelatorioDTO dto) throws JRException, SQLException {
		Map<String, Object> parametros = setParamentros(dto);
		// Pega o arquivo .jasper localizado em resources
		InputStream jasperStream = this.getClass().getResourceAsStream("/jasper/" + dto.getNomeRelatorio());
		// Cria o objeto JaperReport com o Stream do arquivo jasper
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		// Passa para o JasperPrint o relatório, os parâmetros e a fonte dos dados, no
		// caso uma conexão ao banco de dados
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, dataSource.getConnection());
		return jasperPrint;
	}

	private Map<String, Object> setParamentros(ParametroRelatorioDTO dto) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("DATA_ANO", dto.getAno());
		parametros.put("ZONA", dto.getIdZona());
		parametros.put("NUCLEO", dto.getIdNucleo());
		parametros.put("AREA", dto.getIdArea());

		return parametros;
	}
	
}