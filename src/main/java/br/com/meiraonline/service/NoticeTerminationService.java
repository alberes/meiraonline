package br.com.meiraonline.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.meiraonline.domain.Employee;
import br.com.meiraonline.domain.NoticeTermination;
import br.com.meiraonline.exception.MeiraOnlineObjectNotFoundException;
import br.com.meiraonline.repository.EmployeeRepository;
import br.com.meiraonline.repository.NoticeTerminationRepository;

@Service
public class NoticeTerminationService {
	
	@Autowired
	private NoticeTerminationRepository noticeTerminationRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public NoticeTermination insert(NoticeTermination noticeTermination) {
		noticeTermination.setId(null);
		Optional<Employee> employee = employeeRepository.findById(noticeTermination.getEmployee().getId());
		noticeTermination.setEmployee(employee.orElseThrow(
				() -> new MeiraOnlineObjectNotFoundException("Entity not found. Id: " + noticeTermination.getEmployee().getId()
						+ " Type: " + Employee.class.getName())));
		return this.noticeTerminationRepository.save(noticeTermination);
	}
	
	public NoticeTermination find(Long id) {
		Optional<NoticeTermination> noticeTermination = noticeTerminationRepository.findById(id);
		return noticeTermination.orElseThrow(() -> new MeiraOnlineObjectNotFoundException(
				"Entity not found. Id: " + id + ", Type: " + NoticeTermination.class.getName()));
	}
	
	public NoticeTermination findByEmployee(Long id) {
		Employee employee = new Employee();
		employee.setId(id);
		NoticeTermination noticeTermination = noticeTerminationRepository.findByEmployee(employee);
		return noticeTermination;
	}
	
	public NoticeTermination update(NoticeTermination noticeTermination) {
		NoticeTermination noticeTerminationFind = this.find(noticeTermination.getId());
		noticeTerminationFind.setNoticeTypeId(noticeTermination.getNoticeTypeId());
		noticeTerminationFind.setNoticeReasonId(noticeTermination.getNoticeReasonId());
		noticeTerminationFind.setNoticeDate(noticeTermination.getNoticeDate());
		noticeTerminationFind.setLastDay(noticeTermination.getLastDay());
		noticeTerminationFind.setEndDate(noticeTermination.getEndDate());
		noticeTerminationFind.setNoticeStatus(noticeTermination.getNoticeStatus());
		noticeTerminationFind.setNoticeTypeWorkedId(noticeTermination.getNoticeTypeWorkedId());
		noticeTerminationFind.setCancelDate(noticeTermination.getCancelDate());
		noticeTerminationFind.setCancelNoticeReasonId(noticeTermination.getCancelNoticeReasonId());
		return this.noticeTerminationRepository.save(noticeTerminationFind);
	}
	
	public NoticeTermination export(NoticeTermination noticeTermination) {
		NoticeTermination noticeTerminationFind = this.find(noticeTermination.getId());
		noticeTerminationFind.setExport(noticeTermination.getExport());
		return this.noticeTerminationRepository.save(noticeTerminationFind);
	}

	public void delete(Long id) {
		this.find(id);
		try {
			this.noticeTerminationRepository.deleteById(id);
		}catch(DataIntegrityViolationException div) {
			throw new DataIntegrityViolationException("Could not delete NoticeTermination. Id " + id + ", Type: " + NoticeTermination.class.getName());
		}
	}
}
