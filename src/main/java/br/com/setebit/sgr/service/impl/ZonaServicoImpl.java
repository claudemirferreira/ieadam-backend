package br.com.setebit.sgr.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.setebit.sgr.dto.ZonaDTO;
import br.com.setebit.sgr.repository.ZonaRepositorio;
import br.com.setebit.sgr.repository.ZonaRepositorioSql;
import br.com.setebit.sgr.security.entity.Zona;
import br.com.setebit.sgr.service.ZonaServico;

@Service
public class ZonaServicoImpl implements ZonaServico, Serializable {

	private static final long serialVersionUID = -5220391642354623929L;

	@Autowired
	private ZonaRepositorio zonaRepositorio;

	@Autowired
	private ZonaRepositorioSql zonaRepositorioSql;

	@Override
	public List<Zona> listarTodos() {
		return this.zonaRepositorio.findAll();
	}

	public List<ZonaDTO> listarTodosDto() {
		List<ZonaDTO> listaDto = new ArrayList<ZonaDTO>();
		List<Zona> lista = this.zonaRepositorio.findAll();
		lista.forEach(item -> listaDto.add(new ZonaDTO(item.getIdZona(), item.getNome())));
		return listaDto;
	}

	@Override
	public List<Zona> listarTodosPorSituacao(String situacao) {
		return this.zonaRepositorio.findAllBySituacao(situacao);
	}

	@Override
	public Zona salvar(Zona zona) {
		return this.zonaRepositorio.save(zona);
	}

	@Override
	public void remover(Zona zona) {
		this.zonaRepositorio.delete(zona);

	}

	@Override
	public List<Zona> findByMembro(int membro) {
		return this.zonaRepositorio.findByMembro(membro);
	}

	public Zona findOne(int id) {
		return this.zonaRepositorio.findOne(id);
	}

	@Override
	public List<Zona> listaZonaUsuario(int usuarioId) {
		return zonaRepositorioSql.listaZonaUsuario(usuarioId);
	}

	@Override
	public boolean isUsuarioDeZona(int usuarioId, int idZona) {
		return zonaRepositorioSql.isUsuarioDeZona(usuarioId, idZona);
	}

}