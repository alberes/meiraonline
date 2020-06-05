package br.com.meiraonline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.meiraonline.domain.Employee;
import br.com.meiraonline.domain.SickLeave;
import br.com.meiraonline.exception.MeiraOnlineObjectNotFoundException;
import br.com.meiraonline.repository.SickLeaveReponsitory;
import br.com.meiraonline.resource.EmployeeService;

@Service
public class SickLeaveService {
	
	@Autowired
	private SickLeaveReponsitory sickLeaveReponsitory;
	
	@Autowired
	private EmployeeService employeeService;
	
	public SickLeave insert(SickLeave sickLeave) {
		sickLeave.setId(null);
		Employee employee = this.employeeService.find(sickLeave.getEmployee().getId());
		sickLeave.setEmployee(employee);
		this.sickLeaveReponsitory.save(sickLeave);
		return sickLeave;
	}
	
	public SickLeave find(Long id) {
		Optional<SickLeave> sickLeave = this.sickLeaveReponsitory.findById(id);
		return sickLeave.orElseThrow(() -> new MeiraOnlineObjectNotFoundException(
				"Entity not found. Id: " + id + ", Type: " + SickLeave.class.getName()));
	}
	
	public List<SickLeave> findAll(Long employeeId){
		Employee employee = new Employee();
		employee.setId(employeeId);
		return this.sickLeaveReponsitory.findByEmployee(employee);
	}
	
	public Page<SickLeave> findAll(Integer page, Integer linesPerPage, String orderBy, String direction, Long employeeId){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Employee employee = new Employee();
		employee.setId(employeeId);
		return this.sickLeaveReponsitory.findByEmployee(pageRequest, employee);
	}
	
	public int export(Long employeeId) {
		List<SickLeave> sickLeaves = this.findAll(employeeId);
		sickLeaves.forEach(sickLeave -> sickLeave.setExport("S"));
		this.sickLeaveReponsitory.saveAll(sickLeaves);
		return sickLeaves.size();
	}
	
	public void delete(Long id) {
		this.find(id);
		try {
			this.sickLeaveReponsitory.deleteById(id);
		}catch(DataIntegrityViolationException div) {
			throw new DataIntegrityViolationException("Could not delete NoticeTermination. Id " + id + ", Type: " + SickLeave.class.getName());
		}
	}
}