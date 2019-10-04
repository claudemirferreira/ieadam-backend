package br.com.setebit.sgr.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.setebit.sgr.repository.MembroRepository;
import br.com.setebit.sgr.security.entity.Membro;
import br.com.setebit.sgr.service.MembroService;

@Component
public class MembroServiceImpl implements MembroService {

	@Autowired
	private MembroRepository repository;

	public Membro findByIdMembro(Long id) {
		return this.repository.findByIdMembro(id);
	}

	public Membro createOrUpdate(Membro entity) {
		return this.repository.save(entity);
	}

	public Optional<Membro> findById(Long id) {
		return this.repository.findById(id);
	}

	public void delete(String id) {
		this.repository.deleteById(Long.valueOf(id));
	}

	public Page<Membro> findAll(int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return this.repository.findAll(pages);
	}

}