package br.com.setebit.sgr.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.setebit.sgr.security.entity.Perfil;
import br.com.setebit.sgr.security.entity.PerfilRotina;
import br.com.setebit.sgr.security.entity.Rotina;

public class PerfilRotinaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idRotina;

	private Integer idPerfil;

	private String nome;

	private boolean checked;

	public PerfilRotinaDTO() {
	}

	public PerfilRotinaDTO(Integer idPerfil, Integer idRotina, String nome, boolean usuarioNucleo) {
		this.idPerfil = idPerfil;
		this.idRotina = idRotina;
		this.nome = nome;
		this.checked = false;
	}

	public PerfilRotinaDTO(Integer idPerfil, String nome) {
		this.idPerfil = idPerfil;
		this.nome = nome;
		this.checked = false;
	}

	public PerfilRotinaDTO(Rotina entity) {
		this.idRotina =entity.getId();
		this.nome = entity.getNome();
	}

	public Integer getIdRotina() {
		return idRotina;
	}

	public void setIdRotina(Integer idRotina) {
		this.idRotina = idRotina;
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

	public static PerfilRotina toEntity(PerfilRotinaDTO dto) {
		PerfilRotina u = new PerfilRotina();
		// PerfilRotinaPk pk = new PerfilRotinaPk();
		u.setRotina(new Rotina(dto.getIdRotina()));
		u.setPerfil(new Perfil(dto.getIdPerfil()));
		return u;
	}

	public static PerfilRotinaDTO toDTO(Rotina entity) {
		return new PerfilRotinaDTO(entity);
	}

	public static List<PerfilRotinaDTO> toDTO(List<Rotina> list) {
		List<PerfilRotinaDTO> dtos = new ArrayList<PerfilRotinaDTO>();
		list.forEach(item -> dtos.add(toDTO(item)));
		return dtos;
	}

}