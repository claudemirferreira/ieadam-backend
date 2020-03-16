package br.com.setebit.sgr.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.setebit.sgr.security.entity.Zona;
import br.com.setebit.sgr.util.DataUtil;

public class FiltroRelatorioDTO {
	
	private int ano;

	private List<Integer> anos;

	private ZonaDTO zona;

	private AreaDTO area;

	private NucleoDTO nucleo;

	private List<ZonaDTO> zonas;

	private List<AreaDTO> areas;

	private List<NucleoDTO> nucleos;

	private String nomeRelatorio;

	private UsuarioDTO usuarioLogado;

	private int anoInicio;

	private int anoFim;
	
	private MesDto mesInicio;
	
	private List<MesDto> meses = new ArrayList<MesDto>();

	public FiltroRelatorioDTO(String nomeRelatorio, int ano, Zona zona) {
		this.nomeRelatorio = nomeRelatorio;
		this.ano = ano;
		this.zonas = new ArrayList<ZonaDTO>();
		this.areas = new ArrayList<AreaDTO>();
		this.nucleos = new ArrayList<NucleoDTO>();
		this.usuarioLogado = new UsuarioDTO();		
		this.meses = MesDto.pegarMeses();
	}

	public FiltroRelatorioDTO() {
		this.setZonas(new ArrayList<ZonaDTO>());
		this.usuarioLogado = new UsuarioDTO();
		this.anos = DataUtil.pegarAnos();
		this.anoInicio = DataUtil.pegarAnocorrente();
		this.anoFim = this.anoInicio;	
		this.ano = this.anoInicio;
		this.meses = MesDto.pegarMeses();
		this.mesInicio = new MesDto(0,"Janeiro");
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getNomeRelatorio() {
		return nomeRelatorio;
	}

	public void setNomeRelatorio(String nomeRelatorio) {
		this.nomeRelatorio = nomeRelatorio;
	}

	public UsuarioDTO getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(UsuarioDTO usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public List<ZonaDTO> getZonas() {
		return zonas;
	}

	public void setZonas(List<ZonaDTO> zonas) {
		this.zonas = zonas;
	}

	public List<AreaDTO> getAreas() {
		return areas;
	}

	public void setAreas(List<AreaDTO> areas) {
		this.areas = areas;
	}

	public List<NucleoDTO> getNucleos() {
		return nucleos;
	}

	public void setNucleos(List<NucleoDTO> nucleos) {
		this.nucleos = nucleos;
	}

	public ZonaDTO getZona() {
		return zona;
	}

	public void setZona(ZonaDTO zona) {
		this.zona = zona;
	}

	public AreaDTO getArea() {
		return area;
	}

	public void setArea(AreaDTO area) {
		this.area = area;
	}

	public NucleoDTO getNucleo() {
		return nucleo;
	}

	public void setNucleo(NucleoDTO nucleo) {
		this.nucleo = nucleo;
	}

	public List<Integer> getAnos() {
		return anos;
	}

	public void setAnos(List<Integer> anos) {
		this.anos = anos;
	}

	public int getAnoInicio() {
		return anoInicio;
	}

	public void setAnoInicio(int anoInicio) {
		this.anoInicio = anoInicio;
	}

	public int getAnoFim() {
		return anoFim;
	}

	public void setAnoFim(int anoFim) {
		this.anoFim = anoFim;
	}

	public List<MesDto> getMeses() {
		return meses;
	}

	public void setMeses(List<MesDto> meses) {
		this.meses = meses;
	}

	public MesDto getMesInicio() {
		return mesInicio;
	}

	public void setMesInicio(MesDto mesInicio) {
		this.mesInicio = mesInicio;
	}
}