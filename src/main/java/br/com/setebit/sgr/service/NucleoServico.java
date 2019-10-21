package br.com.setebit.sgr.service;

import java.util.List;

import br.com.setebit.sgr.dto.NucleoDTO;
import br.com.setebit.sgr.security.entity.Nucleo;
import br.com.setebit.sgr.security.entity.Usuario;

public interface NucleoServico {

	public List<Nucleo> listarTodos();

	public Nucleo salvar(Nucleo nucleo);

	public void remover(Nucleo nucleo);

	public List<NucleoDTO> findByZona(int zona);

	public List<Nucleo> findByMembro(int membro);

	public Nucleo findOne(int id);

	public List<Nucleo> listaNucleoUsuario(Usuario usuario);

	public List<NucleoDTO> listaNucleoToUsuarioAndZona(int idUsuario, int idZona);

	public boolean isUsuarioDeNucleo(int usuarioId, int idNucleo);
}