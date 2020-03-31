package br.com.setebit.sgr.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UsuarioAssociacaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ZonaDTO> zonas = new ArrayList<ZonaDTO>();

	private List<NucleoDTO> nucleos = new ArrayList<NucleoDTO>();

	private List<AreaDTO> areas = new ArrayList<AreaDTO>();

	private UsuarioDTO usuario;

	public List<ZonaDTO> getZonas() {
		return zonas;
	}

	public void setZonas(List<ZonaDTO> zonas) {
		this.zonas = zonas;
	}

	public List<NucleoDTO> getNucleos() {
		return nucleos;
	}

	public void setNucleos(List<NucleoDTO> nucleos) {
		this.nucleos = nucleos;
	}

	public List<AreaDTO> getAreas() {
		return areas;
	}

	public void setAreas(List<AreaDTO> areas) {
		this.areas = areas;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

}