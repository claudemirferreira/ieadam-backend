package br.com.setebit.sgr.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.setebit.sgr.security.entity.Area;
import br.com.setebit.sgr.security.entity.Nucleo;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.entity.Zona;

public class ParametroRelatorioDTO {

	private String ano;

	private Zona zona;

	private Area area;

	private Nucleo nucleo;

	private List<Zona> zonas;

	private List<Area> areas;

	private List<Nucleo> nucleos;

	private int idNucleo;

	private int idArea;

	private String nomeRelatorio;

	private Usuario usuarioLogado;

	public ParametroRelatorioDTO(String nomeRelatorio, String ano, Zona zona, int idNucleo, int idArea) {
		this.nomeRelatorio = nomeRelatorio;
		this.ano = ano;
		this.zona = zona;
		this.idNucleo = idNucleo;
		this.idArea = idArea;
		this.zonas = new ArrayList<Zona>();
		this.areas = new ArrayList<Area>();
		this.nucleos = new ArrayList<Nucleo>();
		this.usuarioLogado = new Usuario();
		//this.setUsuarioLogado((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
	}

	public ParametroRelatorioDTO() {
		this.setZonas(new ArrayList<Zona>());
		this.setNucleos(new ArrayList<Nucleo>());
		this.setAreas(new ArrayList<Area>());
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
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

	public List<Zona> getZonas() {
		return zonas;
	}

	public void setZonas(List<Zona> zonas) {
		this.zonas = zonas;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public List<Nucleo> getNucleos() {
		return nucleos;
	}

	public void setNucleos(List<Nucleo> nucleos) {
		this.nucleos = nucleos;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Nucleo getNucleo() {
		return nucleo;
	}

	public void setNucleo(Nucleo nucleo) {
		this.nucleo = nucleo;
	}

}