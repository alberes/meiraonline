package br.com.meiraonline.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.meiraonline.domain.Employee;
import br.com.meiraonline.domain.NoticeTermination;
import br.com.meiraonline.exception.MeiraOnlineObjectNotFoundException;
import br.com.meiraonline.repository.NoticeTerminationRepository;

@Service
public class NoticeTerminationService {
	
	@Autowired
	private NoticeTerminationRepository noticeTerminationRepository;
	
	@Autowired
	private EmployeeService employeeService;
	
	public NoticeTermination save(NoticeTermination noticeTermination) {
		noticeTermination.setId(null);
		Employee employee = employeeService.find(noticeTermination.getEmployee().getId());
		noticeTermination.setEmployee(employee);
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
		noticeTerminationFind = this.noticeTerminationRepository.save(noticeTerminationFind);
		return noticeTerminationFind;
	}
	
	public NoticeTermination export(Long id) {
		NoticeTermination noticeTermination = this.find(id);
		noticeTermination.setExport("S");
		noticeTermination = this.noticeTerminationRepository.save(noticeTermination);
		return noticeTermination;
	}

	public void delete(Long id) {
		NoticeTermination noticeTermination = this.find(id);
		try {
			this.noticeTerminationRepository.deleteById(noticeTermination.getId());
		}catch(DataIntegrityViolationException div) {
			throw new DataIntegrityViolationException("Could not delete Notice Termination. Id " + id + ", Type: " + NoticeTermination.class.getName());
		}
	}
}
