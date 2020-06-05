package br.com.meiraonline.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meiraonline.domain.Employee;
import br.com.meiraonline.exception.MeiraOnlineObjectNotFoundException;
import br.com.meiraonline.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee find(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		return employee.orElseThrow(
				() -> new MeiraOnlineObjectNotFoundException("Entity not found. Id: " + id
						+ " Type: " + Employee.class.getName()));
	}
}
