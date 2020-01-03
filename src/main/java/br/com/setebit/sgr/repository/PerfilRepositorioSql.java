package br.com.setebit.sgr.repository;

import java.util.List;

import br.com.setebit.sgr.security.entity.Perfil;

public interface PerfilRepositorioSql {

	public List<Perfil> listaPerfilPorSistemaPorUsuario(int sistemaId, int usuarioId);
	
	public Perfil getPerfil(Long id);

}