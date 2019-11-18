package br.com.setebit.sgr.util;

import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.setebit.sgr.dto.FiltroDTO;
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

	
	public JasperPrint gerarPdf(FiltroDTO dto) throws JRException, SQLException {
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

	private Map<String, Object> setParamentros(FiltroDTO dto) {
		
		Calendar dataAno = new GregorianCalendar( Integer.parseInt(dto.getAno()), dto.getMesInicio().getId(), 1);
		
		Calendar dataMesAnoInicio = new GregorianCalendar(
				Integer.parseInt( dto.getAnoInicio()), dto.getMesInicio().getId(), 1);
		
		Calendar dataMesAnoFim = new GregorianCalendar(
				Integer.parseInt(dto.getAnoFim()), 
				dto.getMesFim().getId(), 
				1);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Map<String, Object> parametros = new HashMap<String, Object>();

		parametros.put("DATA_MES_ANO_INICIO", dateFormat.format(dataMesAnoInicio.getTime()));
		parametros.put("DATA_MES_ANO_FIM", dateFormat.format(dataMesAnoFim.getTime()));
		
		parametros.put("MES_ANO_INICIO", IEADAMUtils.getMesByIndice(dto.getMesInicio().getId()) + "/" + dto.getAnoInicio());
		parametros.put("MES_ANO_FIM", IEADAMUtils.getMesByIndice(dto.getMesFim().getId()) + "/" + dto.getAnoFim());
		
		parametros.put("DATA_MES_ANO", dateFormat.format(dataAno.getTime()));
		parametros.put("MES_ANO", IEADAMUtils.getMesByIndice(dto.getMes().getId())+"/"+dto.getAno());
		parametros.put("DATA_ANO", dto.getAno());
		parametros.put("ZONA", dto.getZona().getId());
		parametros.put("NUCLEO", dto.getNucleo().getId());
		parametros.put("AREA", dto.getArea().getId());
		
		return parametros;
	}
	
}