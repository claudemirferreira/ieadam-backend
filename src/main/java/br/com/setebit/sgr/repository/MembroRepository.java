package br.com.setebit.sgr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.setebit.sgr.security.entity.Membro;

public interface MembroRepository extends JpaRepository<Membro, Long> {

	Membro findByIdMembro(Long id);

}