package br.com.setebit.sgr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.setebit.sgr.security.entity.ChangeStatus;

public interface ChangeStatusRepository extends JpaRepository<ChangeStatus, Long> {

	Iterable<ChangeStatus> findByTicketIdOrderByDateChangeStatusDesc(Long ticketId);
}
