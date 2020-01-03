package br.com.setebit.sgr.service;

import java.util.List;

import br.com.setebit.sgr.dto.PerfilDTO;
import br.com.setebit.sgr.dto.RotinaDTO;
import br.com.setebit.sgr.security.entity.Perfil;
import br.com.setebit.sgr.security.entity.ViewPerfilRotina;

public interface PerfilServico {

	public List<Perfil> listarTodos();

	public Perfil salvar(Perfil perfil);

	public void remover(Perfil perfil);

	public List<Perfil> findByNomeLike(String nome);

	public List<Perfil> listaPerfilPorSistemaPorUsuario(int sistemaId, int usuarioId);

	public List<Perfil> listarPerfilUsuario(Integer idSistema, Integer idUsuario);
	
	public List<Perfil> listarPerfil();
	
	public List<PerfilDTO> listarPerfilDto();
	
	public PerfilDTO listarPerfilDto(Long idPerfil);
	
	public List<RotinaDTO> listarRotinaPorPerfil(int idPerfil);

}