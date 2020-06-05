package br.com.meiraonline.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SickLeave implements Serializable{
	
	private static final long serialVersionUID = 8244205019119233104L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String sickNumber;
	
	private String reason;
	
	private Date startDate;
	
	private Date endDate;
	
	private Integer quantity;
	
	private String doctorName;
	
	private String organ;
	
	private String institution;
	
	private String export;
	
	@ManyToOne(optional=false,fetch=FetchType.EAGER)
	@JoinColumn(name="employee_id")
	private Employee employee;

	public SickLeave() {
		super();
	}

	public SickLeave(String sickNumber, String reason, Date startDate, Date endDate, Integer quantity,
			String doctorName, String organ, String institution, String export) {
		super();
		this.sickNumber = sickNumber;
		this.reason = reason;
		this.startDate = startDate;
		this.endDate = endDate;
		this.quantity = quantity;
		this.doctorName = doctorName;
		this.organ = organ;
		this.institution = institution;
		this.export = export;
	}

	public SickLeave(String sickNumber, String reason, Date startDate, Date endDate, Integer quantity,
			String doctorName, String organ, String institution, String export, Employee employee) {
		super();
		this.sickNumber = sickNumber;
		this.reason = reason;
		this.startDate = startDate;
		this.endDate = endDate;
		this.quantity = quantity;
		this.doctorName = doctorName;
		this.organ = organ;
		this.institution = institution;
		this.export = export;
		this.employee = employee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSickNumber() {
		return sickNumber;
	}

	public void setSickNumber(String sickNumber) {
		this.sickNumber = sickNumber;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getOrgan() {
		return organ;
	}

	public void setOrgan(String organ) {
		this.organ = organ;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getExport() {
		return export;
	}

	public void setExport(String export) {
		this.export = export;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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
		SickLeave other = (SickLeave) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
