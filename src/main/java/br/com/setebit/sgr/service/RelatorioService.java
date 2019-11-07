package br.com.setebit.sgr.service;

import java.sql.SQLException;
import java.util.List;

import br.com.setebit.sgr.dto.FiltroDTO;
import br.com.setebit.sgr.dto.AreaDTO;
import br.com.setebit.sgr.dto.FiltroRelatorioDTO;
import br.com.setebit.sgr.dto.NucleoDTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

public interface RelatorioService {

	public JasperPrint gerarPdf(FiltroDTO dto) throws JRException, SQLException;

	public FiltroRelatorioDTO garregarDadosTela();
	
	public List<NucleoDTO> carregarNucleo(int id);
	
	public List<AreaDTO> carregarArea(int idNucleo);

}