package br.com.meiraonline.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meiraonline.domain.Employee;
import br.com.meiraonline.domain.NoticeTermination;
import br.com.meiraonline.domain.SickLeave;
import br.com.meiraonline.repository.EmployeeRepository;
import br.com.meiraonline.repository.SickLeaveReponsitory;

@Service
public class DBService {
	
	//@Autowired
	//private NoticeTerminationRepository noticeTerminationRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private SickLeaveReponsitory sickLeaveReponsitory;
	
	public void instantiateTestDataBase() {
		List<Employee> employees = new ArrayList<Employee>();
		//List<NoticeTermination> terminationNotices = new ArrayList<NoticeTermination>();
		List<SickLeave> sickLeaves = new ArrayList<SickLeave>();
		
		for(int i = 0; i <= 10; i++) {
			Employee employee = new Employee("Employee " + (i + 1));
			employees.add(employee);
			//terminationNotices.add(new NoticeTermination(i, i, i, new Date(), new Date(),
			//		new Date(), "S", i, new Date(), i, "N", employee));
			//sickLeaves.add(new SickLeave("sickNumber " + i, "Reason " + i, new Date(), new Date(), i,
			//		"Doctor " +i, "Organ " + i, "Institution " + i, "N", employee));
			
		}
		
		employeeRepository.saveAll(employees);
		//employeeRepository.flush();
		sickLeaveReponsitory.saveAll(sickLeaves);
		//noticeTerminationRepository.saveAll(terminationNotices);
	}

}
