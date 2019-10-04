package br.com.setebit.sgr.repository;

import java.util.List;

import br.com.setebit.sgr.security.entity.Perfil;

public interface UsuarioPerfilRepositorioSql {

	public List<Perfil> listaPerfilNotInUsuario(int idUsuario);

}