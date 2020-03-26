package br.com.setebit.sgr.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.setebit.sgr.dto.AreaDTO;
import br.com.setebit.sgr.dto.FiltroRelatorioDTO;
import br.com.setebit.sgr.dto.NucleoDTO;
import br.com.setebit.sgr.dto.UsuarioDTO;
import br.com.setebit.sgr.dto.FiltroDTO;
import br.com.setebit.sgr.dto.ZonaDTO;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.jwt.JwtUser;
import br.com.setebit.sgr.service.AreaServico;
import br.com.setebit.sgr.service.NucleoServico;
import br.com.setebit.sgr.service.RelatorioService;
import br.com.setebit.sgr.service.UsuarioServico;
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
	private UsuarioServico usuarioServico;

	private FiltroRelatorioDTO parametroRelatorioDTO;

	@Override
	public JasperPrint gerarPdf(FiltroDTO dto) throws JRException, SQLException {
		return relatorioUtil.gerarPdf(dto);
	}

	//TODO inicio
	public FiltroRelatorioDTO garregarDadosTela() {
		this.parametroRelatorioDTO = new FiltroRelatorioDTO();
		this.parametroRelatorioDTO.setZonas(new ArrayList<ZonaDTO>());
		this.parametroRelatorioDTO.setZona(new ZonaDTO());
		this.parametroRelatorioDTO.setNucleo(new NucleoDTO());
		this.parametroRelatorioDTO.setArea(new AreaDTO());		
		
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		
		JwtUser user = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//TODO pega o usuario no banco de dados
		UsuarioDTO usuario = UsuarioDTO.toDTO(usuarioServico.findByOne( Integer.parseInt(user.getId())));
		this.parametroRelatorioDTO.setUsuarioLogado(usuario);
		this.preencherCombos(this.parametroRelatorioDTO.getUsuarioLogado());
		/*
		if (this.parametroRelatorioDTO.getZonas().size() == 1) {
			this.parametroRelatorioDTO.setZona(this.parametroRelatorioDTO.getZonas().get(0));
		}
		*/

		return parametroRelatorioDTO;
	}
	
	public void preencherCombos(UsuarioDTO usuario) {

		this.parametroRelatorioDTO.setZonas(new ArrayList<ZonaDTO>());
		this.parametroRelatorioDTO.setNucleos(new ArrayList<NucleoDTO>());
		this.parametroRelatorioDTO.setAreas(new ArrayList<AreaDTO>());

		// Flag para identificar se o usuario eh administrador do Sistema
		if (usuario.isZona() && usuario.isNucleo() && usuario.isArea()) {
			this.parametroRelatorioDTO.setZonas(ZonaDTO.toDTO(this.zonaServico.listarTodos()));
		} else {
			this.parametroRelatorioDTO.setZonas(ZonaDTO.toDTO(this.zonaServico
					.listaZonaUsuario(usuario.getId())));
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

	public void preencherCombosOld(Usuario usuario) {
		this.parametroRelatorioDTO.setZonas(new ArrayList<ZonaDTO>());
		this.parametroRelatorioDTO.setNucleos(new ArrayList<NucleoDTO>());
		this.parametroRelatorioDTO.setAreas(new ArrayList<AreaDTO>());

		this.parametroRelatorioDTO.setZonas(ZonaDTO.toDTO(this.zonaServico.listarTodos()));

		// Flag para identificar se o usuario eh administrador do Sistema
		if (usuario.isZona() && usuario.isNucleo() && usuario.isArea()) {
			this.parametroRelatorioDTO.setZonas(ZonaDTO.toDTO(this.zonaServico.listarTodos()));
		} else {
			this.parametroRelatorioDTO.setZonas(ZonaDTO.toDTO(this.zonaServico.listaZonaUsuario(usuario.getId())));

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

		this.parametroRelatorioDTO.setNucleos(new ArrayList<NucleoDTO>());
		this.parametroRelatorioDTO.setNucleo(new NucleoDTO());
		this.parametroRelatorioDTO.setAreas(new ArrayList<AreaDTO>());
		this.parametroRelatorioDTO.setArea(new AreaDTO());

		/*
		 * Verifica se a zona escolhida no combo esta associada ao usuario. SE estiver,
		 * devera listar todos os Nucleos desta zona e nao apenas o Nucleo associado.
		 */
		zonaAssociada = this.zonaServico.isUsuarioDeZona(this.parametroRelatorioDTO.getUsuarioLogado().getId(),
				this.parametroRelatorioDTO.getZona().getId());

		this.parametroRelatorioDTO.setAreas(new ArrayList<AreaDTO>());

		/*
		 * SE a ZONA nao estiver associada ao usuario, deverah ser pesquisado os NUCLEOS
		 * que o usuario faz parte DESTA regiao
		 */
		if (!zonaAssociada) {
			this.parametroRelatorioDTO.setNucleos(this.nucleoServico.listaNucleoToUsuarioAndZona(
					this.parametroRelatorioDTO.getUsuarioLogado().getId(),
					this.parametroRelatorioDTO.getZona().getId()));
		}

		/*
		 * SE a lista de nucleos estiver vazia, significa que o Usuario eh de REGIAO
		 */
		if (this.parametroRelatorioDTO.getNucleos().size() == 0) {
			this.parametroRelatorioDTO
					.setNucleos(this.nucleoServico.findByZona(this.parametroRelatorioDTO.getZona().getId()));
		}

		/*
		 * SE a lista de NUCLEO estiver com tamanho 1, deverah ser setado o NUCLEO da
		 * lista no objeto NUCLEO e deverah atualizar o combo de AREA
		 */
		else if (this.parametroRelatorioDTO.getNucleos().size() == 1) {
			this.parametroRelatorioDTO.setNucleo(this.parametroRelatorioDTO.getNucleos().iterator().next());
			this.atualizarArea();
		}

	}

	/**
	 * Metodo utilizado para atualizar o combo de Nucleo
	 */
	public void atualizarArea() {

		this.parametroRelatorioDTO.setAreas(new ArrayList<AreaDTO>());
		this.parametroRelatorioDTO.setArea(new AreaDTO());

		boolean nucleoAssociado = false;

		if (this.parametroRelatorioDTO.getNucleo().getId() != 0) {
			/*
			 * Verifica se o nucleo escolhido no combo esta associado ao usuario. SE
			 * estiver, devera listar todas as Areas deste nucleo e nao apenas a Area
			 * associada.
			 */
			nucleoAssociado = this.nucleoServico.isUsuarioDeNucleo(
					this.parametroRelatorioDTO.getUsuarioLogado().getId(),
					this.parametroRelatorioDTO.getNucleo().getId());

			/*
			 * SE o NUCLEO nao estiver associada ao usuario, deverah ser pesquisada as AREAS
			 * que o usuario faz parte DESTE nucleo
			 */
			if (!nucleoAssociado) {

				this.parametroRelatorioDTO.setAreas(this.areaServico.listaAreaToUsuarioAndNucleo(
						this.parametroRelatorioDTO.getUsuarioLogado().getId(),
						this.parametroRelatorioDTO.getNucleo().getId()));
				/*
				 * SE a lista de AREA estiver com tamanho 1, deverah ser setado a AREA da lista
				 * no objeto AREA
				 */
				if (this.parametroRelatorioDTO.getAreas().size() == 1)
					this.parametroRelatorioDTO.setArea(this.parametroRelatorioDTO.getAreas().iterator().next());
			}

			/*
			 * SE a lista de areas estiver vazia, significa que o Usuario eh de NUCLEO
			 */
			if (this.parametroRelatorioDTO.getAreas().size() == 0) {
				this.parametroRelatorioDTO
						.setAreas(this.areaServico.findByNucleo(this.parametroRelatorioDTO.getNucleo().getId()));
			}
		}
	}

	public List<NucleoDTO> carregarNucleo(int id) {
		return nucleoServico.findByZona(id);
	}
	
	public List<NucleoDTO> setarNucleo(int id) {
		atualizarNucleo();
		return nucleoServico.findByZona(id);
	}
	
	public List<AreaDTO> carregarArea(int idNucleo) {

		this.parametroRelatorioDTO.setAreas(new ArrayList<AreaDTO>());
		this.parametroRelatorioDTO.setArea(new AreaDTO());
		this.parametroRelatorioDTO.setNucleo(new NucleoDTO(idNucleo));

		boolean nucleoAssociado = false;

		if (this.parametroRelatorioDTO.getNucleo().getId() != 0) {
			/*
			 * Verifica se o nucleo escolhido no combo esta associado ao usuario. SE
			 * estiver, devera listar todas as Areas deste nucleo e nao apenas a Area
			 * associada.
			 */
			nucleoAssociado = this.nucleoServico.isUsuarioDeNucleo(
					this.parametroRelatorioDTO.getUsuarioLogado().getId(),
					this.parametroRelatorioDTO.getNucleo().getId());

			/*
			 * SE o NUCLEO nao estiver associada ao usuario, deverah ser pesquisada as AREAS
			 * que o usuario faz parte DESTE nucleo
			 */
			if (!nucleoAssociado) {

				this.parametroRelatorioDTO.setAreas(this.areaServico.listaAreaToUsuarioAndNucleo(
						this.parametroRelatorioDTO.getUsuarioLogado().getId(),
						this.parametroRelatorioDTO.getNucleo().getId()));
				/*
				 * SE a lista de AREA estiver com tamanho 1, deverah ser setado a AREA da lista
				 * no objeto AREA
				 */
				if (this.parametroRelatorioDTO.getAreas().size() == 1)
					this.parametroRelatorioDTO.setArea(this.parametroRelatorioDTO.getAreas().iterator().next());
			}

			/*
			 * SE a lista de areas estiver vazia, significa que o Usuario eh de NUCLEO
			 */
			if (this.parametroRelatorioDTO.getAreas().size() == 0) {
				this.parametroRelatorioDTO
						.setAreas(this.areaServico.findByNucleo(this.parametroRelatorioDTO.getNucleo().getId()));
			}
		}
		
		return this.parametroRelatorioDTO.getAreas();
	}

}