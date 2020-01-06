package br.com.setebit.sgr.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import br.com.setebit.sgr.dto.FiltroDTO;
import br.com.setebit.sgr.security.entity.Membro;
import br.com.setebit.sgr.security.entity.ViewMembro;

public interface MembroServico {

	public List<Membro> listarTodos();

	public Membro salvar(Membro membro);

	public void remover(Membro membro);

	public List<Membro> listarMembrosPorNomeLike( String nome);

	public List<ViewMembro> listarMembrosByFiltros(FiltroDTO filtroDTO);
	
	public ViewMembro findById(int idMembro);

}