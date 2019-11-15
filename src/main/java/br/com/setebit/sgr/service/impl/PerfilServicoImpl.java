package br.com.setebit.sgr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.setebit.sgr.dto.PerfilDTO;
import br.com.setebit.sgr.dto.RotinaDTO;
import br.com.setebit.sgr.repository.PerfilRepositorio;
import br.com.setebit.sgr.repository.PerfilRepositorioSql;
import br.com.setebit.sgr.repository.RotinaRepositorio;
import br.com.setebit.sgr.security.entity.Perfil;
import br.com.setebit.sgr.security.jwt.JwtUser;
import br.com.setebit.sgr.service.PerfilServico;

@Service
public class PerfilServicoImpl implements PerfilServico {

	@Autowired
	private PerfilRepositorio perfilRepositorio;

	@Autowired
	private PerfilRepositorioSql perfilRepositorioSql;
	
	@Autowired
	private RotinaRepositorio rotinaRepositorio;

	@Override
	public List<Perfil> listarTodos() {
		return this.perfilRepositorio.findAll();
	}

	@Override
	public Perfil salvar(Perfil perfil) {
		return this.perfilRepositorio.save(perfil);
	}

	@Override
	public void remover(Perfil perfil) {
		this.perfilRepositorio.delete(perfil);
	}

	@Override
	public List<Perfil> findByNomeLike(String nome) {
		return this.perfilRepositorio.findByNomeLike(nome);
	}

	@Override
	public List<Perfil> listaPerfilPorSistemaPorUsuario(int sistemaId, int usuarioId) {
		return this.perfilRepositorioSql.listaPerfilPorSistemaPorUsuario(sistemaId, usuarioId);
	}

	@Override
	public List<Perfil> listarPerfilUsuario(Integer idSistema, Integer idUsuario) {
		return this.perfilRepositorio.listarPerfilUsuario(idSistema, idUsuario);
	}

	@Override
	public List<Perfil> listarPerfil() {
		JwtUser user = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return this.perfilRepositorio.listarPerfilUsuario(2, Integer.parseInt(user.getId()));
	}
	
	public List<PerfilDTO> listarPerfilDto() {
		JwtUser user = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Perfil> list = this.perfilRepositorio.listarPerfilUsuario(2, Integer.parseInt(user.getId()));
		
		List<PerfilDTO> listDto = new ArrayList<PerfilDTO>();
		PerfilDTO dto;
	    for (Perfil perfil : list) {
	    	dto = new PerfilDTO();
	    	dto = PerfilDTO.toDTO(perfil);
			//TODO seta no codigo do sistema na variavel
	    	dto.setRotinas( RotinaDTO.toDTO( rotinaRepositorio.findByPerfil(perfil)));
	    	listDto.add(dto);
		}
		
		return listDto;
	}
}