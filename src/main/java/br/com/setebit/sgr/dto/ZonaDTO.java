package br.com.setebit.sgr.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.setebit.sgr.security.entity.Zona;

public class ZonaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String nome;
	
	private boolean usuarioZona;

	public ZonaDTO() {
	}

	public ZonaDTO(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public static ZonaDTO toDTO(Zona entity) {
		return new ZonaDTO(entity.getIdZona(), entity.getNome());
	}

	public static List<ZonaDTO> toDTO(List<Zona> list) {
		List<ZonaDTO> dtos = new ArrayList<ZonaDTO>();
		list.forEach(item -> dtos.add(toDTO(item)));
		return dtos;
	}

}