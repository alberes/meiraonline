package br.com.meiraonline.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.meiraonline.domain.PreliminaryRegistration;

@Repository
public interface PreliminaryRegistrationRepository extends JpaRepository<PreliminaryRegistration, Long> {
	
	@Transactional(readOnly=true)
	Page<PreliminaryRegistration> findAll(Pageable pageRequest);

}
