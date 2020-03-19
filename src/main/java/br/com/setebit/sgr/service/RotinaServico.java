package br.com.setebit.sgr.service;

import java.util.List;

import br.com.setebit.sgr.security.entity.Rotina;

public interface RotinaServico {

	public List<Rotina> listarTodos();

	public Rotina salvar(Rotina rotina);

	public void remover(Rotina rotina);

	public List<Rotina> listaRotinasPorPerfil(int id);

	public List<Rotina> findByNomeLike(String nome);

	public List<Rotina> listarRotinaPorPerfil(Integer idPerfil);
	
	public Rotina findById(Integer id);
	
	public void delete(Integer id);

}