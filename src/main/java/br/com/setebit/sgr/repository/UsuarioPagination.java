package br.com.setebit.sgr.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.setebit.sgr.security.entity.Usuario;

public interface UsuarioPagination extends PagingAndSortingRepository<Usuario, Integer> {

	Page<Usuario> findByNomeLike(String lastName, Pageable pageable);

}
