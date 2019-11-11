package br.com.setebit.sgr.service;

import java.util.List;

import br.com.setebit.sgr.security.entity.Perfil;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.entity.UsuarioPerfil;

public interface UsuarioPerfilServico {

	public List<UsuarioPerfil> listarTodos();

	public UsuarioPerfil salvar(UsuarioPerfil usuarioPerfil);

	public void remover(UsuarioPerfil usuarioPerfil);

	public List<Perfil> listaPerfilNotInUsuario(int idUsuario);

	public List<UsuarioPerfil> findByUsuario(Usuario usuario);
}