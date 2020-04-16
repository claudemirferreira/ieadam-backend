package br.com.setebit.sgr.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.setebit.sgr.security.entity.Perfil;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.entity.UsuarioPerfil;

public class UsuarioPerfilDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idUsuario;

	private Integer idPerfil;

	private String nome;

	private boolean checked;

	public UsuarioPerfilDTO() {
	}

	public UsuarioPerfilDTO(Integer idPerfil, Integer idUsuario, String nome, boolean usuarioNucleo) {
		this.idPerfil = idPerfil;
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.checked = false;
	}

	public UsuarioPerfilDTO(Integer idPerfil, String nome) {
		this.idPerfil = idPerfil;
		this.nome = nome;
		this.checked = false;
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

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public static UsuarioPerfil toEntity(UsuarioPerfilDTO dto) {
		UsuarioPerfil u = new UsuarioPerfil();
		u.setUsuario(new Usuario(dto.getIdUsuario()));
		u.setPerfil(new Perfil(dto.getIdPerfil()));
		return u;
	}

	public static UsuarioPerfilDTO toDTO(Perfil entity) {
		return new UsuarioPerfilDTO(entity.getId(), entity.getNome());
	}

	public static List<UsuarioPerfilDTO> toDTO(List<Perfil> list) {
		List<UsuarioPerfilDTO> dtos = new ArrayList<UsuarioPerfilDTO>();
		list.forEach(item -> dtos.add(toDTO(item)));
		return dtos;
	}

}