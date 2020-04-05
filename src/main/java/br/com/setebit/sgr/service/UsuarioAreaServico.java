package br.com.setebit.sgr.service;

import java.util.List;

import br.com.setebit.sgr.dto.UsuarioAreaDTO;
import br.com.setebit.sgr.security.entity.Area;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.entity.UsuarioArea;

public interface UsuarioAreaServico {

	public List<UsuarioArea> listarTodos();

	public UsuarioArea salvar(UsuarioArea usuarioArea);

	public void remover(UsuarioArea usuarioArea);

	public void deleteByUsuarioAndByArea(Usuario usuario, Area area);

	public UsuarioArea findByUsuarioAndByArea(Usuario usuario, Area area);

	public List<Area> findByUsuario(Usuario usuario);

	UsuarioAreaDTO atualizar(UsuarioAreaDTO dto);

}