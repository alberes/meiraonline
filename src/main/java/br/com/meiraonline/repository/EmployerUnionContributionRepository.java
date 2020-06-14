package br.com.meiraonline.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.meiraonline.domain.EmployerUnionContribution;

@Repository
public interface EmployerUnionContributionRepository extends JpaRepository<EmployerUnionContribution, Long>{
	
	@Transactional(readOnly=true)
	Page<EmployerUnionContribution> findAll(Pageable pageRequest);
}
