package br.com.meiraonline.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.meiraonline.domain.SchoolCalendar;
import br.com.meiraonline.exception.MeiraOnlineObjectNotFoundException;
import br.com.meiraonline.repository.SchoolCalendarRepository;

@Service
public class SchoolCalendarService {
	
	@Autowired
	private SchoolCalendarRepository schoolCalendarRepository;
	
	public SchoolCalendar save(SchoolCalendar schoolCalendar) {
		schoolCalendar.setId(null);
		this.schoolCalendarRepository.save(schoolCalendar);
		return schoolCalendar;
	}
	
	public SchoolCalendar find(Long id) {
		Optional<SchoolCalendar> schoolCalendar = this.schoolCalendarRepository.findById(id);
		return schoolCalendar.orElseThrow(() -> new MeiraOnlineObjectNotFoundException(
				"Entity not found. Id: " + id + ", Type: " + SchoolCalendar.class.getName()));
	}
	
	public Page<SchoolCalendar> findAll(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return this.schoolCalendarRepository.findAll(pageRequest);
	}
	
	public SchoolCalendar update(SchoolCalendar schoolCalendar) {
		SchoolCalendar schoolCalendarFind = this.find(schoolCalendar.getId());
		schoolCalendarFind.setName(schoolCalendar.getName());
		schoolCalendarFind.setYearReference(schoolCalendar.getYearReference());
		schoolCalendarFind.setStartDateSchoolYear(schoolCalendar.getStartDateSchoolYear());
		schoolCalendarFind.setEndDateSchoolYear(schoolCalendar.getEndDateSchoolYear());
		schoolCalendarFind.setStartDateFirstHalf(schoolCalendar.getStartDateFirstHalf());
		schoolCalendarFind.setEndDateFirstHalf(schoolCalendar.getEndDateFirstHalf());
		schoolCalendarFind.setStartDateFirstHalfVacation(schoolCalendar.getStartDateFirstHalfVacation());
		schoolCalendarFind.setEndDateFirstHalfVacation(schoolCalendar.getEndDateFirstHalfVacation());
		schoolCalendarFind.setStartDateSecondHalf(schoolCalendar.getStartDateSecondHalf());
		schoolCalendarFind.setEndDateSecondHalf(schoolCalendar.getEndDateSecondHalf());
		schoolCalendarFind.setStartDateSecondHalfVacation(schoolCalendar.getStartDateSecondHalfVacation());
		schoolCalendarFind.setEndDateSecondHalfVacation(schoolCalendar.getEndDateSecondHalfVacation());
		schoolCalendarFind.setStartDateFirstHalfRecess(schoolCalendar.getStartDateFirstHalfRecess());
		schoolCalendarFind.setEndDateFirstHalfRecess(schoolCalendar.getEndDateFirstHalfRecess());
		schoolCalendarFind.setStartDateSecondHalfRecess(schoolCalendar.getStartDateSecondHalfRecess());
		schoolCalendarFind.setEndDateSecondHalfRecess(schoolCalendar.getEndDateSecondHalfRecess());		
		schoolCalendarFind = this.schoolCalendarRepository.save(schoolCalendarFind);
		return schoolCalendarFind;
	}
	
	public SchoolCalendar export(Long id) {
		SchoolCalendar schoolCalendar = this.find(id);
		schoolCalendar.setExport("S");
		schoolCalendar = this.schoolCalendarRepository.save(schoolCalendar);
		return schoolCalendar;
	}
	
	public void delete(Long id) {
		SchoolCalendar schoolCalendar = this.find(id);
		try {
			this.schoolCalendarRepository.deleteById(schoolCalendar.getId());
		}catch(DataIntegrityViolationException div) {
			throw new DataIntegrityViolationException("Could not delete School Calendar. Id " + id + ", Type: " + SchoolCalendar.class.getName());
		}
	}

}
