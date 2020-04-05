package br.com.setebit.sgr.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UsuarioAssociacaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<UsuarioZonaDTO> usuarioZonas = new ArrayList<UsuarioZonaDTO>();

	private List<UsuarioNucleoDTO> usuarioNucleos = new ArrayList<UsuarioNucleoDTO>();

	private List<UsuarioAreaDTO> usuarioAreas = new ArrayList<UsuarioAreaDTO>();

	private UsuarioDTO usuario;

	public List<UsuarioNucleoDTO> getUsuarioNucleos() {
		return usuarioNucleos;
	}

	public void setUsuarioNucleos(List<UsuarioNucleoDTO> usuarioNucleos) {
		this.usuarioNucleos = usuarioNucleos;
	}

	public List<UsuarioAreaDTO> getUsuarioAreas() {
		return usuarioAreas;
	}

	public void setUsuarioAreas(List<UsuarioAreaDTO> usuarioAreas) {
		this.usuarioAreas = usuarioAreas;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public List<UsuarioZonaDTO> getUsuarioZonas() {
		return usuarioZonas;
	}

	public void setUsuarioZonas(List<UsuarioZonaDTO> usuarioZonas) {
		this.usuarioZonas = usuarioZonas;
	}

}