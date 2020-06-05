package br.com.meiraonline.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.meiraonline.domain.Employee;
import br.com.meiraonline.domain.SickLeave;

@Repository
public interface SickLeaveReponsitory extends JpaRepository<SickLeave, Long>{
	
	@Transactional(readOnly=true)
	Page<SickLeave> findByEmployee(Pageable pageRequest, Employee employee);
	
	@Transactional(readOnly=true)
	List<SickLeave> findByEmployee(Employee employee);

}
