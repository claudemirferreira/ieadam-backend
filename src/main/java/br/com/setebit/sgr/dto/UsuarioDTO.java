package br.com.setebit.sgr.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.enums.ProfileEnum;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String login;

	private String senha;

	private String status;

	private ProfileEnum profile;

	private boolean zona;

	private boolean area;

	private boolean nucleo;

	private boolean in_privilegio;

	private String telefone;

	private String email;

	private Integer idMembro;

	private String nome;

	public UsuarioDTO() {
	}

	public UsuarioDTO(int id, String login, String senha, String status, ProfileEnum profile, boolean zona,
			boolean area, boolean nucleo, boolean in_privilegio, String telefone, String email, Integer idMembro,
			String nome) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.status = status;
		this.profile = profile;
		this.zona = zona;
		this.area = area;
		this.nucleo = nucleo;
		this.in_privilegio = in_privilegio;
		this.telefone = telefone;
		this.email = email;
		this.idMembro = idMembro;
		this.nome = nome;
	}

	public static UsuarioDTO getDTO(Usuario entity) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.id = entity.getId();
		dto.login = entity.getLogin();
		dto.senha = entity.getSenha();
		dto.status = entity.getStatus();
		dto.profile = entity.getProfile();
		dto.zona = entity.isZona();
		dto.area = entity.isArea();
		dto.nucleo = entity.isNucleo();
		dto.in_privilegio = entity.isIn_privilegio();
		dto.telefone = entity.getTelefone();
		dto.email = entity.getEmail();
		dto.idMembro = entity.getIdMembro();
		dto.nome = entity.getNome();
		
		return dto;
	}

	public static UsuarioDTO toDTO(Usuario entity) {
		return getDTO(entity);
	}

	public static List<UsuarioDTO> toDTO(List<Usuario> list) {
		List<UsuarioDTO> dtos = new ArrayList<UsuarioDTO>();
		list.forEach(item -> dtos.add(toDTO(item)));
		return dtos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ProfileEnum getProfile() {
		return profile;
	}

	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
	}

	public boolean isZona() {
		return zona;
	}

	public void setZona(boolean zona) {
		this.zona = zona;
	}

	public boolean isArea() {
		return area;
	}

	public void setArea(boolean area) {
		this.area = area;
	}

	public boolean isNucleo() {
		return nucleo;
	}

	public void setNucleo(boolean nucleo) {
		this.nucleo = nucleo;
	}

	public boolean isIn_privilegio() {
		return in_privilegio;
	}

	public void setIn_privilegio(boolean in_privilegio) {
		this.in_privilegio = in_privilegio;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdMembro() {
		return idMembro;
	}

	public void setIdMembro(Integer idMembro) {
		this.idMembro = idMembro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}