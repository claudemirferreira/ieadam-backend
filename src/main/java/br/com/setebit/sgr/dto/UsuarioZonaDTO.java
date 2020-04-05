package br.com.setebit.sgr.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.entity.UsuarioZona;
import br.com.setebit.sgr.security.entity.Zona;

public class UsuarioZonaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idUsuarioZona;

	private Integer idZona;

	private Integer idUsuario;

	private String nome;
	
	private boolean usuarioZona;

	public UsuarioZonaDTO() {
	}

	public UsuarioZonaDTO(Integer idUsuarioZona, Integer idZona, Integer idUsuario, String nome, boolean usuarioZona) {
		this.idUsuarioZona = idUsuarioZona;
		this.idZona = idZona;
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.usuarioZona = usuarioZona;
	}

	public UsuarioZonaDTO( Integer idZona, String nome) {
		this.idZona = idZona;
		this.nome = nome;
		this.usuarioZona = false;
	}

	public Integer getIdUsuarioZona() {
		return idUsuarioZona;
	}

	public void setIdUsuarioZona(Integer idUsuarioZona) {
		this.idUsuarioZona = idUsuarioZona;
	}

	public Integer getIdZona() {
		return idZona;
	}

	public void setIdZona(Integer idZona) {
		this.idZona = idZona;
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

	public boolean isUsuarioZona() {
		return usuarioZona;
	}

	public void setUsuarioZona(boolean usuarioZona) {
		this.usuarioZona = usuarioZona;
	}
	
	public static UsuarioZona toEntity(UsuarioZonaDTO dto) {
		UsuarioZona u = new UsuarioZona();
		if(null != dto.getIdUsuarioZona())
			u.setIdUsuarioZona(dto.getIdUsuarioZona());
		u.setUsuario(new Usuario(dto.getIdUsuario()));
		u.setZona(new Zona(dto.getIdZona()));
		return u;
	}

	public static UsuarioZonaDTO toDTO(Zona entity) {
		return new UsuarioZonaDTO(entity.getIdZona(), entity.getNome());
	}

	public static List<UsuarioZonaDTO> toDTO(List<Zona> list) {
		List<UsuarioZonaDTO> dtos = new ArrayList<UsuarioZonaDTO>();
		list.forEach(item -> dtos.add(toDTO(item)));
		return dtos;
	}

}