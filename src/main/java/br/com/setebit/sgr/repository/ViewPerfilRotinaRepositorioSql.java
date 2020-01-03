package br.com.setebit.sgr.repository;

import java.util.List;

import br.com.setebit.sgr.dto.FiltroDTO;
import br.com.setebit.sgr.security.entity.ViewMembro;
import br.com.setebit.sgr.security.entity.ViewPerfilRotina;

public interface ViewPerfilRotinaRepositorioSql {

	public List<ViewPerfilRotina> listarRotinaPorPerfil(int idPerfil);

}