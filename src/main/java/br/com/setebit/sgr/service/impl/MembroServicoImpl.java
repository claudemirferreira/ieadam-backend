package br.com.setebit.sgr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.setebit.sgr.dto.FiltroDTO;
import br.com.setebit.sgr.repository.MembroRepositorio;
import br.com.setebit.sgr.repository.MembroRepositorioSql;
import br.com.setebit.sgr.security.entity.Membro;
import br.com.setebit.sgr.security.entity.ViewMembro;
import br.com.setebit.sgr.service.MembroServico;

@Service
public class MembroServicoImpl implements MembroServico {

	@Autowired
	private MembroRepositorio membroRepositorio;

	@Autowired
	private MembroRepositorioSql repositorioSql;

	@Override
	public List<Membro> listarTodos() {
		return membroRepositorio.findAll();
	}

	@Override
	public Membro salvar(Membro membro) {
		return membroRepositorio.save(membro);
	}

	@Override
	public void remover(Membro membro) {
		membroRepositorio.delete(membro);
	}

	@Override
	public List<Membro> listarMembrosPorNomeLike(String nome) {
		return this.membroRepositorio.listarMembrosPorNomeLike(nome);
	}

	@Override
	public List<ViewMembro> listarMembrosByFiltros(FiltroDTO filtroDTO) {

		if (filtroDTO.getArea().getId() > 0) {
			filtroDTO.getZona().setId(0);
			filtroDTO.getNucleo().setId(0);
		} else if (filtroDTO.getNucleo().getId() > 0) {
			filtroDTO.getZona().setId(0);
			filtroDTO.getArea().setId(0);
		}

		return this.repositorioSql.listarMembrosByFiltros(filtroDTO);
	}
	
	public ViewMembro findById(int idMembro) {
		return this.repositorioSql.findById(idMembro);
	}
}
