package br.com.setebit.sgr.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.setebit.sgr.security.entity.Perfil;
import br.com.setebit.sgr.security.entity.Rotina;

public class RotinaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String nome;
	
	private String acao;

	public RotinaDTO() {
	}

	public RotinaDTO(int id, String nome, String acao) {
		this.id = id;
		this.nome = nome;
		this.acao = acao;
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

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public static RotinaDTO toDTO(Rotina entity) {
		return new RotinaDTO(entity.getId(), entity.getNome(), entity.getAcao());
	}

	public static List<RotinaDTO> toDTO(List<Rotina> list) {
		List<RotinaDTO> dtos = new ArrayList<RotinaDTO>();
		list.forEach(item -> dtos.add(toDTO(item)));
		return dtos;
	}

}