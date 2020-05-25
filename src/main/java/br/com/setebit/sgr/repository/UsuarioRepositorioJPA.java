package br.com.setebit.sgr.repository;

import java.util.List;

import br.com.setebit.sgr.security.entity.Usuario;

public interface UsuarioRepositorioJPA {

	List<Usuario> findByUsuario(Usuario usuario, int pageNumber, int pageSize);

}