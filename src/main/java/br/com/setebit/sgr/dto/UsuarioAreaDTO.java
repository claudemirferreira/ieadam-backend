package br.com.setebit.sgr.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.entity.UsuarioArea;
import br.com.setebit.sgr.security.entity.Area;

public class UsuarioAreaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idUsuarioArea;

	private Integer idArea;

	private Integer idUsuario;

	private String nome;
	
	private boolean usuarioArea;

	public UsuarioAreaDTO() {
	}

	public UsuarioAreaDTO(Integer idUsuarioArea, Integer idArea, Integer idUsuario, String nome, boolean usuarioArea) {
		this.idUsuarioArea = idUsuarioArea;
		this.idArea = idArea;
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.usuarioArea = usuarioArea;
	}

	public UsuarioAreaDTO( Integer idArea, String nome) {
		this.idArea = idArea;
		this.nome = nome;
		this.usuarioArea = false;
	}

	public Integer getIdUsuarioArea() {
		return idUsuarioArea;
	}

	public void setIdUsuarioArea(Integer idUsuarioArea) {
		this.idUsuarioArea = idUsuarioArea;
	}

	public Integer getIdArea() {
		return idArea;
	}

	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isUsuarioArea() {
		return usuarioArea;
	}

	public void setUsuarioArea(boolean usuarioArea) {
		this.usuarioArea = usuarioArea;
	}
	
	public static UsuarioArea toEntity(UsuarioAreaDTO dto) {
		UsuarioArea u = new UsuarioArea();
		if(null != dto.getIdUsuarioArea())
			u.setIdUsuarioArea(dto.getIdUsuarioArea());
		u.setUsuario(new Usuario(dto.getIdUsuario()));
		u.setArea(new Area(dto.getIdArea()));
		return u;
	}

	public static UsuarioAreaDTO toDTO(Area entity) {
		return new UsuarioAreaDTO(entity.getIdArea(), entity.getNome());
	}

	public static List<UsuarioAreaDTO> toDTO(List<Area> list) {
		List<UsuarioAreaDTO> dtos = new ArrayList<UsuarioAreaDTO>();
		list.forEach(item -> dtos.add(toDTO(item)));
		return dtos;
	}

}