package br.com.meiraonline.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class SchoolCalendar implements Serializable{

	private static final long serialVersionUID = 274031587507661116L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Name can not be null")
	@Size(min = 1, message = "Name can not have less than 10 characters")
	private String name;
	
	private Integer yearReference;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startDateSchoolYear;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDateSchoolYear;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startDateFirstHalf;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDateFirstHalf;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startDateFirstHalfVacation;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDateFirstHalfVacation;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startDateSecondHalf;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDateSecondHalf;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startDateSecondHalfVacation;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDateSecondHalfVacation;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startDateFirstHalfRecess;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDateFirstHalfRecess;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startDateSecondHalfRecess;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDateSecondHalfRecess;
	
	private String export;

	public SchoolCalendar() {
		super();
	}

	public SchoolCalendar(String name, Integer yearReference, Date startDateSchoolYear, Date endDateSchoolYear,
			Date startDateFirstHalf, Date endDateFirstHalf, Date startDateFirstHalfVacation,
			Date endDateFirstHalfVacation, Date startDateSecondHalf, Date endDateSecondHalf,
			Date startDateSecondHalfVacation, Date endDateSecondHalfVacation, Date startDateFirstHalfRecess,
			Date endDateFirstHalfRecess, Date startDateSecondHalfRecess, Date endDateSecondHalfRecess) {
		super();
		this.name = name;
		this.yearReference = yearReference;
		this.startDateSchoolYear = startDateSchoolYear;
		this.endDateSchoolYear = endDateSchoolYear;
		this.startDateFirstHalf = startDateFirstHalf;
		this.endDateFirstHalf = endDateFirstHalf;
		this.startDateFirstHalfVacation = startDateFirstHalfVacation;
		this.endDateFirstHalfVacation = endDateFirstHalfVacation;
		this.startDateSecondHalf = startDateSecondHalf;
		this.endDateSecondHalf = endDateSecondHalf;
		this.startDateSecondHalfVacation = startDateSecondHalfVacation;
		this.endDateSecondHalfVacation = endDateSecondHalfVacation;
		this.startDateFirstHalfRecess = startDateFirstHalfRecess;
		this.endDateFirstHalfRecess = endDateFirstHalfRecess;
		this.startDateSecondHalfRecess = startDateSecondHalfRecess;
		this.endDateSecondHalfRecess = endDateSecondHalfRecess;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYearReference() {
		return yearReference;
	}

	public void setYearReference(Integer yearReference) {
		this.yearReference = yearReference;
	}

	public Date getStartDateSchoolYear() {
		return startDateSchoolYear;
	}

	public void setStartDateSchoolYear(Date startDateSchoolYear) {
		this.startDateSchoolYear = startDateSchoolYear;
	}

	public Date getEndDateSchoolYear() {
		return endDateSchoolYear;
	}

	public void setEndDateSchoolYear(Date endDateSchoolYear) {
		this.endDateSchoolYear = endDateSchoolYear;
	}

	public Date getStartDateFirstHalf() {
		return startDateFirstHalf;
	}

	public void setStartDateFirstHalf(Date startDateFirstHalf) {
		this.startDateFirstHalf = startDateFirstHalf;
	}

	public Date getEndDateFirstHalf() {
		return endDateFirstHalf;
	}

	public void setEndDateFirstHalf(Date endDateFirstHalf) {
		this.endDateFirstHalf = endDateFirstHalf;
	}

	public Date getStartDateFirstHalfVacation() {
		return startDateFirstHalfVacation;
	}

	public void setStartDateFirstHalfVacation(Date startDateFirstHalfVacation) {
		this.startDateFirstHalfVacation = startDateFirstHalfVacation;
	}

	public Date getEndDateFirstHalfVacation() {
		return endDateFirstHalfVacation;
	}

	public void setEndDateFirstHalfVacation(Date endDateFirstHalfVacation) {
		this.endDateFirstHalfVacation = endDateFirstHalfVacation;
	}

	public Date getStartDateSecondHalf() {
		return startDateSecondHalf;
	}

	public void setStartDateSecondHalf(Date startDateSecondHalf) {
		this.startDateSecondHalf = startDateSecondHalf;
	}

	public Date getEndDateSecondHalf() {
		return endDateSecondHalf;
	}

	public void setEndDateSecondHalf(Date endDateSecondHalf) {
		this.endDateSecondHalf = endDateSecondHalf;
	}

	public Date getStartDateSecondHalfVacation() {
		return startDateSecondHalfVacation;
	}

	public void setStartDateSecondHalfVacation(Date startDateSecondHalfVacation) {
		this.startDateSecondHalfVacation = startDateSecondHalfVacation;
	}

	public Date getEndDateSecondHalfVacation() {
		return endDateSecondHalfVacation;
	}

	public void setEndDateSecondHalfVacation(Date endDateSecondHalfVacation) {
		this.endDateSecondHalfVacation = endDateSecondHalfVacation;
	}

	public Date getStartDateFirstHalfRecess() {
		return startDateFirstHalfRecess;
	}

	public void setStartDateFirstHalfRecess(Date startDateFirstHalfRecess) {
		this.startDateFirstHalfRecess = startDateFirstHalfRecess;
	}

	public Date getEndDateFirstHalfRecess() {
		return endDateFirstHalfRecess;
	}

	public void setEndDateFirstHalfRecess(Date endDateFirstHalfRecess) {
		this.endDateFirstHalfRecess = endDateFirstHalfRecess;
	}

	public Date getStartDateSecondHalfRecess() {
		return startDateSecondHalfRecess;
	}

	public void setStartDateSecondHalfRecess(Date startDateSecondHalfRecess) {
		this.startDateSecondHalfRecess = startDateSecondHalfRecess;
	}

	public Date getEndDateSecondHalfRecess() {
		return endDateSecondHalfRecess;
	}

	public void setEndDateSecondHalfRecess(Date endDateSecondHalfRecess) {
		this.endDateSecondHalfRecess = endDateSecondHalfRecess;
	}

	public String getExport() {
		return export;
	}

	public void setExport(String export) {
		this.export = export;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SchoolCalendar other = (SchoolCalendar) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
