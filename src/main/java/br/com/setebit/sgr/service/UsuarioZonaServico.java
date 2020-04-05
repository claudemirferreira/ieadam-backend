package br.com.setebit.sgr.service;

import java.util.List;

import br.com.setebit.sgr.dto.UsuarioZonaDTO;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.entity.UsuarioZona;
import br.com.setebit.sgr.security.entity.Zona;

public interface UsuarioZonaServico {

	public List<UsuarioZona> listarTodos();

	public UsuarioZona salvar(UsuarioZona usuarioZona);

	public void remover(UsuarioZona usuarioZona);

	public void deleteByUsuarioAndByZona(Usuario usuario, Zona zona);

	public UsuarioZona findByUsuarioAndByZona(Usuario usuario, Zona zona);

	public List<Zona> findByUsuario(Usuario usuario);
	
	public UsuarioZona findByUsuarioAndByZona(Integer idUsuario, Integer idZona);

	public UsuarioZonaDTO atualizar(UsuarioZonaDTO usuarioZonaDTO);
	
}