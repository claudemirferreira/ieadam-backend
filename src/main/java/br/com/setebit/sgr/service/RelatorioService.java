package br.com.setebit.sgr.service;

import java.sql.SQLException;

import br.com.setebit.sgr.dto.ParametroRelatorioDTO;
import br.com.setebit.sgr.dto.ParametroRelatorioDTO2;
import br.com.setebit.sgr.security.entity.Usuario;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

public interface RelatorioService {

	public JasperPrint gerarPdf(ParametroRelatorioDTO dto) throws JRException, SQLException;

	public ParametroRelatorioDTO2 garregarDadosTela(Usuario usuario);

}