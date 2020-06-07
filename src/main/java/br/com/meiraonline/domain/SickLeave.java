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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class SickLeave implements Serializable{
	
	private static final long serialVersionUID = 8244205019119233104L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Sick number can not be null")
	@Size(min = 1, message = "Sick number can not have less than 1 characters")
	private String sickNumber;
	
	private String reasonSickLeave;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@NotNull(message = "Start date can not be null")
	private Date startDate;
	
	@Min(value = 0, message = "Quantity can not be less then 1")
	private Integer quantity;

	@JsonFormat(pattern="yyyy-MM-dd")
	@NotNull(message = "End date can not be null")
	private Date endDate;
	
	private String noticeStatus;
	
	private String trafficAccidentType;
	
	@NotNull(message="Obligatory field")
	@Size(min=10, max=255, message="Datail sick leave must have between 10 and 255 characters")
	private String detailSickLeave;
	
	@NotNull(message="Obligatory field")
	private String cid;
	
	@NotNull(message="Obligatory field")
	@Size(min=10, max=80, message="Doctor name must have between 10 and 80 characters")
	private String doctorName;
	
	private String organClass;
	
	private String classOrganRegistration;
	
	private String state;
	
	private String rectification;
	
	private String rectificationOrigin;
	
	private String processType;
	
	@NotNull(message="Obligatory field")
	@Size(min=1, message="Process number can not have less than 1 characters")
	private String processNumber;
	
	private String responsibleCompensation;
	
	private String laborUnion;
	
	private String documentNumber;

	private String export;
	
	@ManyToOne(optional=false,fetch=FetchType.EAGER)
	@JoinColumn(name="employee_id")
	private Employee employee;

	public SickLeave() {
		super();
	}
	
	public SickLeave(String sickNumber, String reasonSickLeave, Date startDate, Integer quantity, Date endDate,
			String noticeStatus, String trafficAccidentType, String detailSickLeave, String cid, String doctorName,
			String organClass, String classOrganRegistration, String state, String rectification,
			String rectificationOrigin, String processType, String processNumber, String responsibleCompensation,
			String laborUnion, String documentNumber, String export) {
		super();
		this.sickNumber = sickNumber;
		this.reasonSickLeave = reasonSickLeave;
		this.startDate = startDate;
		this.quantity = quantity;
		this.endDate = endDate;
		this.noticeStatus = noticeStatus;
		this.trafficAccidentType = trafficAccidentType;
		this.detailSickLeave = detailSickLeave;
		this.cid = cid;
		this.doctorName = doctorName;
		this.organClass = organClass;
		this.classOrganRegistration = classOrganRegistration;
		this.state = state;
		this.rectification = rectification;
		this.rectificationOrigin = rectificationOrigin;
		this.processType = processType;
		this.processNumber = processNumber;
		this.responsibleCompensation = responsibleCompensation;
		this.laborUnion = laborUnion;
		this.documentNumber = documentNumber;
		this.export = export;
	}

	public SickLeave(String sickNumber, String reasonSickLeave, Date startDate, Integer quantity, Date endDate,
			String noticeStatus, String trafficAccidentType, String detailSickLeave, String cid, String doctorName,
			String organClass, String classOrganRegistration, String state, String rectification,
			String rectificationOrigin, String processType, String processNumber, String responsibleCompensation,
			String laborUnion, String documentNumber, String export, Employee employee) {
		super();
		this.sickNumber = sickNumber;
		this.reasonSickLeave = reasonSickLeave;
		this.startDate = startDate;
		this.quantity = quantity;
		this.endDate = endDate;
		this.noticeStatus = noticeStatus;
		this.trafficAccidentType = trafficAccidentType;
		this.detailSickLeave = detailSickLeave;
		this.cid = cid;
		this.doctorName = doctorName;
		this.organClass = organClass;
		this.classOrganRegistration = classOrganRegistration;
		this.state = state;
		this.rectification = rectification;
		this.rectificationOrigin = rectificationOrigin;
		this.processType = processType;
		this.processNumber = processNumber;
		this.responsibleCompensation = responsibleCompensation;
		this.laborUnion = laborUnion;
		this.documentNumber = documentNumber;
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

	public String getReasonSickLeave() {
		return reasonSickLeave;
	}

	public void setReasonSickLeave(String reasonSickLeave) {
		this.reasonSickLeave = reasonSickLeave;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getNoticeStatus() {
		return noticeStatus;
	}

	public void setNoticeStatus(String noticeStatus) {
		this.noticeStatus = noticeStatus;
	}

	public String getTrafficAccidentType() {
		return trafficAccidentType;
	}

	public void setTrafficAccidentType(String trafficAccidentType) {
		this.trafficAccidentType = trafficAccidentType;
	}

	public String getDetailSickLeave() {
		return detailSickLeave;
	}

	public void setDetailSickLeave(String detailSickLeave) {
		this.detailSickLeave = detailSickLeave;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getOrganClass() {
		return organClass;
	}

	public void setOrganClass(String organClass) {
		this.organClass = organClass;
	}

	public String getClassOrganRegistration() {
		return classOrganRegistration;
	}

	public void setClassOrganRegistration(String classOrganRegistration) {
		this.classOrganRegistration = classOrganRegistration;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRectification() {
		return rectification;
	}

	public void setRectification(String rectification) {
		this.rectification = rectification;
	}

	public String getRectificationOrigin() {
		return rectificationOrigin;
	}

	public void setRectificationOrigin(String rectificationOrigin) {
		this.rectificationOrigin = rectificationOrigin;
	}

	public String getProcessType() {
		return processType;
	}

	public void setProcessType(String processType) {
		this.processType = processType;
	}

	public String getProcessNumber() {
		return processNumber;
	}

	public void setProcessNumber(String processNumber) {
		this.processNumber = processNumber;
	}

	public String getResponsibleCompensation() {
		return responsibleCompensation;
	}

	public void setResponsibleCompensation(String responsibleCompensation) {
		this.responsibleCompensation = responsibleCompensation;
	}

	public String getLaborUnion() {
		return laborUnion;
	}

	public void setLaborUnion(String laborUnion) {
		this.laborUnion = laborUnion;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
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
