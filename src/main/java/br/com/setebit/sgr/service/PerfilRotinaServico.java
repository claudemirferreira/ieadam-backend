package br.com.setebit.sgr.service;

import java.util.List;

import br.com.setebit.sgr.security.entity.PerfilRotina;
import br.com.setebit.sgr.security.entity.Rotina;

public interface PerfilRotinaServico {

	public List<PerfilRotina> listarTodos();

	public PerfilRotina salvar(PerfilRotina usuarioPerfil);

	public void remover(PerfilRotina usuarioPerfil);

	public List<Rotina> listaRotinaNotInPerfil(int idPerfil);

}
