package br.com.setebit.sgr.service;

import java.util.List;

import br.com.setebit.sgr.dto.UsuarioNucleoDTO;
import br.com.setebit.sgr.security.entity.Nucleo;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.entity.UsuarioNucleo;

public interface UsuarioNucleoServico {

	public List<UsuarioNucleo> listarTodos();

	public UsuarioNucleo salvar(UsuarioNucleo usuarioNucleo);

	public void remover(UsuarioNucleo usuarioNucleo);

	public void deleteByUsuarioAndByNucleo(Usuario usuario, Nucleo nucleo);

	public UsuarioNucleo findByUsuarioAndByNucleo(Usuario usuario, Nucleo nucleo);

	public List<Nucleo> findByUsuario(Usuario usuario);

	UsuarioNucleoDTO atualizar(UsuarioNucleoDTO dto);
}