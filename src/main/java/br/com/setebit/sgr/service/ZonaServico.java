package br.com.setebit.sgr.service;

import java.util.List;

import br.com.setebit.sgr.dto.ZonaDTO;
import br.com.setebit.sgr.security.entity.Zona;

public interface ZonaServico {

	public List<Zona> listarTodos();

	public List<ZonaDTO> listarTodosDto();

	List<Zona> listarTodosPorSituacao(String situacao);

	public Zona salvar(Zona zona);

	public void remover(Zona zona);

	public List<Zona> findByMembro(int membro);

	public Zona findOne(int id);

	public List<Zona> listaZonaUsuario(int usuarioId);

	public boolean isUsuarioDeZona(int usuarioId, int idZona);

}