package br.com.setebit.sgr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.setebit.sgr.repository.SistemaRepositorio;
import br.com.setebit.sgr.security.entity.Sistema;
import br.com.setebit.sgr.service.SistemaServico;

@Service
public class SistemaServicoImpl implements SistemaServico {

	@Autowired
	private SistemaRepositorio servico;

	@Override
	public List<Sistema> listarTodos() {
		return this.servico.findAll();
	}

	@Override
	public Sistema salvar(Sistema sistema) {
		return this.servico.save(sistema);
	}

	@Override
	public void remover(Sistema sistema) {
		this.servico.delete(sistema);
	}

	@Override
	public List<Sistema> findByNomeLike(String nome) {
		return this.servico.findByNomeLike(nome);
	}

	@Override
	public Sistema findByCodigo(String codigo) {
		return this.servico.findByCodigo(codigo);
	}

}