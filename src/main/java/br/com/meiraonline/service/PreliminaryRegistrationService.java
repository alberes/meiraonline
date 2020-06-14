package br.com.meiraonline.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.meiraonline.domain.PreliminaryRegistration;
import br.com.meiraonline.exception.MeiraOnlineObjectNotFoundException;
import br.com.meiraonline.repository.PreliminaryRegistrationRepository;

@Service
public class PreliminaryRegistrationService {
	
	@Autowired
	private PreliminaryRegistrationRepository preliminaryRegistrationRepository;
	
	public PreliminaryRegistration save(PreliminaryRegistration preliminaryRegistration) {
		preliminaryRegistration.setId(null);
		preliminaryRegistration.setExport("N");
		preliminaryRegistration = this.preliminaryRegistrationRepository.save(preliminaryRegistration);
		return preliminaryRegistration;
	}
	
	public PreliminaryRegistration find(Long id) {
		Optional<PreliminaryRegistration> preliminaryRegistration = this.preliminaryRegistrationRepository.findById(id);
		return preliminaryRegistration.orElseThrow(() -> new MeiraOnlineObjectNotFoundException(
				"Entity not found. Id: " + id + ", Type: " + PreliminaryRegistration.class.getName()));
	}
	
	public Page<PreliminaryRegistration> findAll(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return this.preliminaryRegistrationRepository.findAll(pageRequest);
	}
	
	public PreliminaryRegistration update(PreliminaryRegistration preliminaryRegistration) {
		PreliminaryRegistration preliminaryRegistrationFind = this.find(preliminaryRegistration.getId());
		preliminaryRegistrationFind.setName(preliminaryRegistration.getName());
		preliminaryRegistrationFind.setGender(preliminaryRegistration.getGender());
		preliminaryRegistrationFind.setDocumentId(preliminaryRegistration.getDocumentId());
		preliminaryRegistrationFind.setDateBirth(preliminaryRegistration.getDateBirth());
		preliminaryRegistrationFind.setAdmissionDate(preliminaryRegistration.getAdmissionDate());
		preliminaryRegistrationFind = this.preliminaryRegistrationRepository.save(preliminaryRegistration);
		return preliminaryRegistrationFind;
	}
	
	public PreliminaryRegistration export(Long id) {
		PreliminaryRegistration preliminaryRegistration = this.find(id);
		preliminaryRegistration.setExport("S");
		preliminaryRegistration = this.preliminaryRegistrationRepository.save(preliminaryRegistration);
		return preliminaryRegistration;
	}
	
	public void delete(Long id) {
		PreliminaryRegistration preliminaryRegistration = this.find(id);
		try {
			this.preliminaryRegistrationRepository.deleteById(preliminaryRegistration.getId());
		}catch(DataIntegrityViolationException div) {
			throw new DataIntegrityViolationException("Could not delete Preliminary Registration. Id " + id + ", Type: " + PreliminaryRegistration.class.getName());
		}
	} 

}
