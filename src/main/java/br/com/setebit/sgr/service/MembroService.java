package br.com.setebit.sgr.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.setebit.sgr.security.entity.Membro;

@Component
public interface MembroService {

	Membro findByIdMembro(Long id);

	Membro createOrUpdate(Membro membro);

	Optional<Membro> findById(Long id);

	void delete(String id);

	Page<Membro> findAll(int page, int count);
}