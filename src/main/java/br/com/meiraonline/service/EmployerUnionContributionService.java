package br.com.meiraonline.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.meiraonline.domain.EmployerUnionContribution;
import br.com.meiraonline.exception.MeiraOnlineObjectNotFoundException;
import br.com.meiraonline.repository.EmployerUnionContributionRepository;

@Service
public class EmployerUnionContributionService {
	
	@Autowired
	private EmployerUnionContributionRepository employerUnionContributionRepository;
	
	public EmployerUnionContribution save(EmployerUnionContribution employerUnionContribution) {
		employerUnionContribution.setId(null);
		employerUnionContribution.setExport("N");
		employerUnionContribution =  this.employerUnionContributionRepository.save(employerUnionContribution);
		return employerUnionContribution;
	}
	
	public EmployerUnionContribution find(Long id) {
		Optional<EmployerUnionContribution> employerUnionContribution = this.employerUnionContributionRepository.findById(id);
		return employerUnionContribution.orElseThrow(() -> new MeiraOnlineObjectNotFoundException(
				"Entity not found. Id: " + id + ", Type: " + EmployerUnionContribution.class.getName()));
	}

	public Page<EmployerUnionContribution> findAll(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return this.employerUnionContributionRepository.findAll(pageRequest);
	}
	
	public EmployerUnionContribution update(EmployerUnionContribution employerUnionContribution) {
		EmployerUnionContribution employerUnionContributionFind = this.find(employerUnionContribution.getId());
		employerUnionContributionFind.setName(employerUnionContribution.getName());;
		employerUnionContributionFind.setEmployerUnion(employerUnionContribution.getEmployerUnion());
		employerUnionContributionFind.setContributionType(employerUnionContribution.getContributionType());;
		employerUnionContributionFind.setContributionAmount(employerUnionContribution.getContributionAmount());
		this.employerUnionContributionRepository.save(employerUnionContributionFind);
		return employerUnionContributionFind;
	}
	
	public EmployerUnionContribution export(Long id) {
		EmployerUnionContribution employerUnionContribution = this.find(id);
		employerUnionContribution.setExport("S");
		employerUnionContribution = this.employerUnionContributionRepository.save(employerUnionContribution);
		return employerUnionContribution;
	}
	
	public void delete(Long id) {
		EmployerUnionContribution employerUnionContribution = this.find(id);
		try {
			this.employerUnionContributionRepository.deleteById(employerUnionContribution.getId());
		}catch(DataIntegrityViolationException div) {
			throw new DataIntegrityViolationException("Could not delete Employer Union Contribution. Id " + id + ", Type: " + EmployerUnionContribution.class.getName());
		}
	}
}
