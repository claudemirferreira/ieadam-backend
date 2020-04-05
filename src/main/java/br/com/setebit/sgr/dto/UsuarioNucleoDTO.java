package br.com.setebit.sgr.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.setebit.sgr.security.entity.Nucleo;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.entity.UsuarioNucleo;

public class UsuarioNucleoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idUsuarioNucleo;

	private Integer idNucleo;

	private Integer idUsuario;

	private String nome;

	private boolean usuarioNucleo;

	public UsuarioNucleoDTO() {
	}

	public UsuarioNucleoDTO(Integer idUsuarioNucleo, Integer idNucleo, Integer idUsuario, String nome,
			boolean usuarioNucleo) {
		this.idUsuarioNucleo = idUsuarioNucleo;
		this.idNucleo = idNucleo;
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.usuarioNucleo = usuarioNucleo;
	}

	public UsuarioNucleoDTO(Integer idNucleo, String nome) {
		this.idNucleo = idNucleo;
		this.nome = nome;
		this.usuarioNucleo = false;
	}

	public Integer getIdUsuarioNucleo() {
		return idUsuarioNucleo;
	}

	public void setIdUsuarioNucleo(Integer idUsuarioNucleo) {
		this.idUsuarioNucleo = idUsuarioNucleo;
	}

	public Integer getIdNucleo() {
		return idNucleo;
	}

	public void setIdNucleo(Integer idNucleo) {
		this.idNucleo = idNucleo;
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

	public boolean isUsuarioNucleo() {
		return usuarioNucleo;
	}

	public void setUsuarioNucleo(boolean usuarioNucleo) {
		this.usuarioNucleo = usuarioNucleo;
	}

	public static UsuarioNucleo toEntity(UsuarioNucleoDTO dto) {
		UsuarioNucleo u = new UsuarioNucleo();
		if (null != dto.getIdUsuarioNucleo())
			u.setIdUsuarioNucleo(dto.getIdUsuarioNucleo());
		u.setUsuario(new Usuario(dto.getIdUsuario()));
		u.setNucleo(new Nucleo(dto.getIdNucleo()));
		return u;
	}

	public static UsuarioNucleoDTO toDTO(Nucleo entity) {
		return new UsuarioNucleoDTO(entity.getId(), entity.getNome());
	}

	public static List<UsuarioNucleoDTO> toDTO(List<Nucleo> list) {
		List<UsuarioNucleoDTO> dtos = new ArrayList<UsuarioNucleoDTO>();
		list.forEach(item -> dtos.add(toDTO(item)));
		return dtos;
	}

}