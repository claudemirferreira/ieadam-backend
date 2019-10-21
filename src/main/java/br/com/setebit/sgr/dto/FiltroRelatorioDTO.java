package br.com.setebit.sgr.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.entity.Zona;
import br.com.setebit.sgr.security.enums.Mes;
import br.com.setebit.sgr.util.DataUtil;

public class FiltroRelatorioDTO {
	
	private Mes mes = Mes.JANEIRO;

	private Mes mesInicio = Mes.JANEIRO;

	private Mes mesFim = Mes.JANEIRO;

	private String usuario;

	private int ano;

	private List<Integer> anos;

	private ZonaDTO zona;

	private AreaDTO area;

	private NucleoDTO nucleo;

	private List<ZonaDTO> zonas;

	private List<AreaDTO> areas;

	private List<NucleoDTO> nucleos;

	private int idNucleo;

	private int idZona;

	private int idArea;

	private String nomeRelatorio;

	private Usuario usuarioLogado;

	private int anoInicio;

	private int anoFim;
	
	private List<Mes> meses = new ArrayList<Mes>();

	public FiltroRelatorioDTO(String nomeRelatorio, int ano, Zona zona, int idNucleo, int idArea) {
		this.nomeRelatorio = nomeRelatorio;
		this.ano = ano;
		this.idNucleo = idNucleo;
		this.idArea = idArea;
		this.zonas = new ArrayList<ZonaDTO>();
		this.areas = new ArrayList<AreaDTO>();
		this.nucleos = new ArrayList<NucleoDTO>();
		this.usuarioLogado = new Usuario();
	}

	public FiltroRelatorioDTO() {
		this.setZonas(new ArrayList<ZonaDTO>());
		this.usuarioLogado = new Usuario();
		this.anos = DataUtil.pegarAnos();
		this.anoInicio = DataUtil.pegarAnocorrente();
		this.anoFim = DataUtil.pegarAnocorrente();
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getIdNucleo() {
		return idNucleo;
	}

	public void setIdNucleo(int idNucleo) {
		this.idNucleo = idNucleo;
	}

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public String getNomeRelatorio() {
		return nomeRelatorio;
	}

	public void setNomeRelatorio(String nomeRelatorio) {
		this.nomeRelatorio = nomeRelatorio;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public int getIdZona() {
		return idZona;
	}

	public void setIdZona(int idZona) {
		this.idZona = idZona;
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

	public List<Mes> getMeses() {
		return meses;
	}

	public void setMeses(List<Mes> meses) {
		this.meses = meses;
	}

	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	public Mes getMesInicio() {
		return mesInicio;
	}

	public void setMesInicio(Mes mesInicio) {
		this.mesInicio = mesInicio;
	}

	public Mes getMesFim() {
		return mesFim;
	}

	public void setMesFim(Mes mesFim) {
		this.mesFim = mesFim;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}