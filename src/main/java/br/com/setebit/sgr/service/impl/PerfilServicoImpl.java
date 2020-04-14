package br.com.setebit.sgr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.setebit.sgr.dto.PerfilDTO;
import br.com.setebit.sgr.dto.RotinaDTO;
import br.com.setebit.sgr.dto.UsuarioPerfilDTO;
import br.com.setebit.sgr.dto.UsuarioZonaDTO;
import br.com.setebit.sgr.repository.PerfilRepositorio;
import br.com.setebit.sgr.repository.PerfilRepositorioSql;
import br.com.setebit.sgr.repository.PerfilRotinaRepositorioSql;
import br.com.setebit.sgr.repository.RotinaRepositorio;
import br.com.setebit.sgr.repository.UsuarioPerfilRepositorio;
import br.com.setebit.sgr.repository.ViewPerfilRotinaRepositorioSql;
import br.com.setebit.sgr.security.entity.Perfil;
import br.com.setebit.sgr.security.entity.Rotina;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.entity.UsuarioPerfil;
import br.com.setebit.sgr.security.entity.UsuarioZona;
import br.com.setebit.sgr.security.entity.ViewPerfilRotina;
import br.com.setebit.sgr.security.entity.Zona;
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
	
	@Autowired
	private PerfilRotinaRepositorioSql perfilRotinaRepositorioSql;
	
	@Autowired
	private UsuarioPerfilRepositorio usuarioPerfilRepositorio;

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
		return this.perfilRepositorio.findByNomeLike(nome+"%");
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

	@Override
	public List<UsuarioPerfilDTO> listarUsuarioPerfil() {
		JwtUser user = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Integer idUsuario = Integer.parseInt(user.getId());
		Usuario usuario = new Usuario(idUsuario);
		List<Perfil> list = this.perfilRepositorio.findAll();
		List<UsuarioPerfilDTO> listDto = new ArrayList<UsuarioPerfilDTO>();
		UsuarioPerfilDTO dto;
		for (Perfil perfil : list) {
			dto = UsuarioPerfilDTO.toDTO(perfil);
			dto.setIdUsuario(idUsuario);
			if (null != usuarioPerfilRepositorio.findByUsuarioAndPerfil(usuario, perfil)) 
				dto.setChecked(true);
			listDto.add(dto);
		}
		return listDto;
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
	
	public PerfilDTO listarPerfilDto(Long idPerfil) {		
		Perfil perfil = perfilRepositorioSql.getPerfil(idPerfil);
		PerfilDTO perfilDTO = PerfilDTO.toDTO(perfil);
		perfilDTO.setRotinas( RotinaDTO.toDTO( rotinaRepositorio.findByPerfil(perfil)));		
		return perfilDTO;
	}

	@Override
	public List<RotinaDTO> listarRotinaPorPerfil(int idPerfil) {
		List<RotinaDTO> list = RotinaDTO.toDTO(rotinaRepositorio.findAll());
		List<RotinaDTO> dtos = new ArrayList<RotinaDTO>();
		Rotina rotina;
		for (RotinaDTO rotinaDTO : list) {	
			try {
				rotina = perfilRotinaRepositorioSql.existeRotinaAssociada(idPerfil, rotinaDTO.getId());
				if(rotina != null)
					rotinaDTO.setChecked(true);
				
				
			} catch (Exception e) {
			}
			dtos.add(rotinaDTO);
		}		
		return dtos;
	}
	


	@Override
	public UsuarioPerfilDTO atualizar(UsuarioPerfilDTO dto) {
		UsuarioPerfil usuarioPerfil = UsuarioPerfilDTO.toEntity(dto);
		if (dto.isChecked())
			usuarioPerfilRepositorio.save(usuarioPerfil);		
		else {
			//usuarioPerfil = usuarioPerfilRepositorio.findByUsuarioAndPerfil(new Usuario(dto.getIdUsuario()), new Perfil(dto.getIdPerfil()));
			System.out.println("deletando o id ");
			usuarioPerfilRepositorio.delete(usuarioPerfil);
		}
		return dto;
	}
}