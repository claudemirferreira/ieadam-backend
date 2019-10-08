package br.com.setebit.sgr.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.entity.Zona;

public class ParametroRelatorioDTO2 {

	private String ano;

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

	public ParametroRelatorioDTO2(String nomeRelatorio, String ano, Zona zona, int idNucleo, int idArea) {
		this.nomeRelatorio = nomeRelatorio;
		this.ano = ano;
		// this.zona = zona;
		this.idNucleo = idNucleo;
		this.idArea = idArea;
		this.zonas = new ArrayList<ZonaDTO>();
		this.areas = new ArrayList<AreaDTO>();
		this.nucleos = new ArrayList<NucleoDTO>();
		this.usuarioLogado = new Usuario();
		// this.setUsuarioLogado((Usuario)
		// SecurityContextHolder.getContext().getAuthentication().getPrincipal());
	}

	public ParametroRelatorioDTO2() {
		this.setZonas(new ArrayList<ZonaDTO>());
		// this.setNucleos(new ArrayList<Nucleo>());
		// this.setAreas(new ArrayList<Area>());
		this.usuarioLogado = new Usuario();
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
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
}