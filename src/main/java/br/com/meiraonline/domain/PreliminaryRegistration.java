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
public class PreliminaryRegistration implements Serializable{
	
	private static final long serialVersionUID = -7312619560500223658L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Name can not be null")
	@Size(min = 1, message = "Name can not have less than 1 characters")
	private String name;
	
	@NotNull(message = "Gender can not be null")
	private String gender;
	
	@NotNull(message = "Document can not be null")
	private String documentId;
	
	@NotNull(message = "Date birth can not be null")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateBirth;
	
	@NotNull(message = "Admission can not be ")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date admissionDate;
	
	private String export;

	public PreliminaryRegistration() {
		super();
	}

	public PreliminaryRegistration(String name, String gender, String documentId, Date dateBirth, Date admissionDate,
			String export) {
		super();
		this.name = name;
		this.gender = gender;
		this.documentId = documentId;
		this.dateBirth = dateBirth;
		this.admissionDate = admissionDate;
		this.export = export;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
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
		PreliminaryRegistration other = (PreliminaryRegistration) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	

}
