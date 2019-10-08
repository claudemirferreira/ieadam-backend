package br.com.setebit.sgr.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.setebit.sgr.dto.AreaDTO;
import br.com.setebit.sgr.dto.NucleoDTO;
import br.com.setebit.sgr.dto.ParametroRelatorioDTO;
import br.com.setebit.sgr.dto.ParametroRelatorioDTO2;
import br.com.setebit.sgr.dto.ZonaDTO;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.jwt.JwtUser;
import br.com.setebit.sgr.service.AreaServico;
import br.com.setebit.sgr.service.NucleoServico;
import br.com.setebit.sgr.service.RelatorioService;
import br.com.setebit.sgr.service.UsuarioAreaServico;
import br.com.setebit.sgr.service.UsuarioNucleoServico;
import br.com.setebit.sgr.service.UsuarioZonaServico;
import br.com.setebit.sgr.service.ZonaServico;
import br.com.setebit.sgr.util.RelatorioUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class RelatorioServiceImpl implements RelatorioService {

	@Autowired
	private RelatorioUtil relatorioUtil;

	@Autowired
	private ZonaServico zonaServico;

	@Autowired
	private NucleoServico nucleoServico;

	@Autowired
	private AreaServico areaServico;

	@Autowired
	private UsuarioZonaServico usuarioZonaServico;

	@Autowired
	private UsuarioNucleoServico usuarioNucleoServico;

	@Autowired
	private UsuarioAreaServico usuarioAreaServico;

	private ParametroRelatorioDTO2 parametroRelatorioDTO;

	@Override
	public JasperPrint gerarPdf(ParametroRelatorioDTO dto) throws JRException, SQLException {
		return relatorioUtil.gerarPdf(dto);
	}

	public ParametroRelatorioDTO2 garregarDadosTela(Usuario usuario) {
		this.parametroRelatorioDTO = new ParametroRelatorioDTO2();

		this.parametroRelatorioDTO.setZonas(new ArrayList<ZonaDTO>());

		JwtUser user = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		this.parametroRelatorioDTO.getUsuarioLogado().setId(Integer.parseInt(user.getId()));
		this.parametroRelatorioDTO.getUsuarioLogado().setLogin(user.getUsername());

		this.preencherCombos(this.parametroRelatorioDTO.getUsuarioLogado());

		return parametroRelatorioDTO;
	}

	public void preencherCombos(Usuario usuario) {

		this.parametroRelatorioDTO.setZonas(new ArrayList<ZonaDTO>());
		this.parametroRelatorioDTO.setNucleos(new ArrayList<NucleoDTO>());
		this.parametroRelatorioDTO.setAreas(new ArrayList<AreaDTO>());

		this.parametroRelatorioDTO.setZonas(ZonaDTO.toDTO(this.zonaServico.listarTodos()));

		// Flag para identificar se o usuario eh administrador do Sistema
		if (usuario.isZona() && usuario.isNucleo() && usuario.isArea()) {
			this.parametroRelatorioDTO.setZonas(ZonaDTO.toDTO(this.zonaServico.listarTodos()));
		} else {
			this.parametroRelatorioDTO
					.setZonas(ZonaDTO.toDTO(this.zonaServico.listaZonaUsuario(usuario.getId())));

			if (this.parametroRelatorioDTO.getZonas().size() == 1) {
				this.parametroRelatorioDTO.setZona(this.parametroRelatorioDTO.getZonas().iterator().next());
				this.atualizarNucleo();
			}

			if (this.parametroRelatorioDTO.getNucleos().size() == 1) {
				this.parametroRelatorioDTO.setNucleo(this.parametroRelatorioDTO.getNucleos().iterator().next());
				this.atualizarArea();
			}
		}
	}

	public void atualizarNucleo() {

		boolean zonaAssociada = false;

	}

	/**
	 * Metodo utilizado para atualizar o combo de Nucleo
	 */
	public void atualizarArea() {

	}
}