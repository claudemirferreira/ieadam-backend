package br.com.setebit.sgr.service;

import java.util.List;

import br.com.setebit.sgr.security.entity.Nucleo;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.entity.Zona;

public interface NucleoServico {

	public List<Nucleo> listarTodos();

	public Nucleo salvar(Nucleo nucleo);

	public void remover(Nucleo nucleo);

	public List<Nucleo> findByZona(int zona);

	public List<Nucleo> findByMembro(int membro);

	public Nucleo findOne(int id);

	public List<Nucleo> listaNucleoUsuario(Usuario usuario);

	public List<Nucleo> listaNucleoToUsuarioAndZona(Usuario usuario, Zona zona);

	public boolean isUsuarioDeNucleo(int usuarioId, int idNucleo);
}