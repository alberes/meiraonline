package br.com.meiraonline.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.meiraonline.domain.Employee;
import br.com.meiraonline.service.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeResource {
	
	@Autowired
	private EmployeeService employeeService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<Employee> find(@PathVariable Long id){
		Employee employee = employeeService.find(id);
		return ResponseEntity.ok().body(employee);
	}

}
