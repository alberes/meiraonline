package br.com.meiraonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.meiraonline.domain.Employee;
import br.com.meiraonline.domain.NoticeTermination;

@Repository
public interface NoticeTerminationRepository extends JpaRepository<NoticeTermination, Long> {
	
	@Transactional(readOnly=true)
	public NoticeTermination findByEmployee(Employee employee);

}
