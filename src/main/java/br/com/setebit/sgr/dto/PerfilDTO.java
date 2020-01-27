package br.com.setebit.sgr.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.setebit.sgr.security.entity.Perfil;

public class PerfilDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String nome;

	private String imagem;
	
	private List<RotinaDTO> rotinas = new ArrayList<RotinaDTO>();

	public PerfilDTO() {
	}

	public PerfilDTO(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	


	public PerfilDTO(Perfil perfil) {
		this.id = perfil.getId();
		this.nome = perfil.getNome();
		this.imagem = perfil.getImagem().replace("resources/imagens/perfil/", "").replace(".png", "");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<RotinaDTO> getRotinas() {
		return rotinas;
	}

	public void setRotinas(List<RotinaDTO> rotinas) {
		this.rotinas = rotinas;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public static PerfilDTO toDTO(Perfil entity) {
		return new PerfilDTO(entity);
	}

	public static List<PerfilDTO> toDTO(List<Perfil> list) {
		List<PerfilDTO> dtos = new ArrayList<PerfilDTO>();
		list.forEach(item -> dtos.add(toDTO(item)));
		return dtos;
	}

}